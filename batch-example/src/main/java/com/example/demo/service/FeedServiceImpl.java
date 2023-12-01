package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Feed;
import com.example.demo.model.Result;
import com.example.demo.model.User;
import com.example.demo.util.GsonUtils;
import com.example.demo.util.OkHttpUtils;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@Service
@Slf4j
public class FeedServiceImpl implements FeedService {
    /**
     *
     * @return
     */
    @Override
    public Feed index(int id){
        final Feed feed = new Feed();
        List<ImmutablePair<String, Consumer<String>>> requestList = Lists.newArrayList(
                ImmutablePair.of("http://demo.com/getuserstatus?id="+id, c ->{
                    Result<String> source = GsonUtils.toJavaObject(c, new TypeToken<Result<String>>(){});
                    String userStatus = Result.getSuccessResult(source, "");
                    feed.setStatus(userStatus);
                }),
                ImmutablePair.of("http://demo.com/getcurrentuser?id="+id, c -> {
                    Result<User> source = GsonUtils.toJavaObject(c, new TypeToken<Result<User>>(){});
                    User userInfo = Result.getSuccessResult(source, null);
                    if(userInfo != null){
                        feed.setUserId(userInfo.getId());
                        feed.setUserName(userInfo.getUserName());
                    }
                }),
                ImmutablePair.of("http://demo.com/getbloglist", c -> {
                    Result<List<Blog>> source = GsonUtils.toJavaObject(c, new TypeToken<Result<List<Blog>>>(){});
                    List<Blog> blogList = Result.getSuccessResult(source, Collections.emptyList());
                    feed.setBlogList(blogList);
                })
        );

        if(id > 10){
            requestList.add(ImmutablePair.of("http://demo.com/statistics", c -> {
                Result<Map<String, Integer>> source = GsonUtils.toJavaObject(c, new TypeToken<Result<Map<String, Integer>>>(){
                });
                Map<String, Integer> statistics = Result.getSuccessResult(source, Collections.EMPTY_MAP);
                if(!CollectionUtils.isEmpty(statistics)){
                    feed.setViewCount(statistics.get("viewcount"));
                    feed.setLikeCount(statistics.get("likecount"));
                }
            }));
        }

        return feed;
    }

    private void getMultiRequest(List<ImmutablePair<String, Consumer<String>>> requestList){
        if (CollectionUtils.isEmpty(requestList)) {
            return;
        }

        Assert.isTrue(requestList.stream().allMatch(p -> StringUtils.hasText(p.getLeft()) && Objects.nonNull(p.getRight())), "requestList pair contains empty element");
        List<String> results = sendGetMultiRequest(requestList.stream().map(ImmutablePair::getLeft).collect(Collectors.toList()).toArray(new String[0]));
        Assert.isTrue(requestList.size() == results.size(), "results size is not match");

        for (int i = 0; i < requestList.size(); i++) {
            requestList.get(i).getRight().accept(results.get(i));
        }
    }

    ExecutorService executorService = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors() * 2);
    private List<String> sendGetMultiRequest(String[] paths){
        if(ObjectUtils.isEmpty(paths)){
            return Collections.emptyList();
        }

        try {
            List<Future<String>> futureList = executorService.invokeAll(Arrays.stream(paths).map(path -> {
                try {
                    path = URLDecoder.decode(path, StandardCharsets.UTF_8.toString());
                } catch (UnsupportedEncodingException e) {
                    log.error("decode fail", e);
                    return (Callable<String>) () -> null;
                }
                String url = path;
                return (Callable<String>) () -> OkHttpUtils.builder().url(url).get().sync();
            }).collect(Collectors.toList()));
            return futureList.stream().map(p -> {
                try {
                    return Optional.ofNullable(p.get()).orElse(null);
                } catch (InterruptedException e) {
                    log.error("thread interrupt", e);
                    Thread.currentThread().interrupt();
                    return null;
                } catch (ExecutionException e) {
                    log.error("execution interrupt", e);
                    return null;
                }
            }).collect(Collectors.toList());
        } catch (InterruptedException e) {
            log.error("thread interrupt", e);
            Thread.currentThread().interrupt();
            return Collections.emptyList();
        }
    }

    @Override
    public Feed getFeed(int id){
        final Feed feed = new Feed();
        List<ImmutablePair<String, Consumer<String>>> requestList = Lists.newArrayList(
                ImmutablePair.of("/getuserstatus?id="+id, c ->{
                    Result<String> source = GsonUtils.toJavaObject(c, new TypeToken<Result<String>>() {});
                    String userStatus = Result.getSuccessResult(source, "");
                    feed.setStatus("new".equalsIgnoreCase(userStatus) ? "新" : userStatus);
                }),
                ImmutablePair.of("/getcurrentuser?id="+id, c ->{
                    Result<User> source = GsonUtils.toJavaObject(c, new TypeToken<Result<User>>() {});
                    User userInfo = Result.getSuccessResult(source, null);
                    if(userInfo != null){
                        feed.setUserId(userInfo.getId());
                        feed.setUserName(userInfo.getUserName());
                    }
                }),
                ImmutablePair.of("/getbloglist", c ->{
                    Result<List<Blog>> source = GsonUtils.toJavaObject(c, new TypeToken<Result<List<Blog>>>() {
                    });
                    List<Blog> blogList = Result.getSuccessResult(source, Collections.emptyList());
                    if(!CollectionUtils.isEmpty(blogList)){
                        feed.setBlogList(blogList);
                    }
                })
        );

        if(id > 10){
            requestList.add(ImmutablePair.of("/statistics", c ->{
                Result<Map<String, Integer>> source = GsonUtils.toJavaObject(c, new TypeToken<Result<Map<String, Integer>>>() {
                });
                Map<String, Integer> statistics = Result.getSuccessResult(source, Collections.EMPTY_MAP);
                if(!CollectionUtils.isEmpty(statistics)){
                    feed.setViewCount(statistics.get("viewcount"));
                    feed.setLikeCount(statistics.get("likecount"));
                }
            }));
        }

        this.multiGetRequest(requestList);
        
        return feed;
    }

    private void multiGetRequest(List<ImmutablePair<String, Consumer<String>>> requestList){
        if (CollectionUtils.isEmpty(requestList)) {
            return;
        }

        Assert.isTrue(requestList.stream().allMatch(p -> StringUtils.hasText(p.getLeft()) && Objects.nonNull(p.getRight())), "requestList pair contains empty element");
        List<String> results = sendMultiGetRequest(requestList.stream().map(ImmutablePair::getLeft).collect(Collectors.toList()));

        Assert.isTrue(requestList.size() == results.size(), "results size is not match");

        for (int i = 0; i < requestList.size(); i++) {
            requestList.get(i).getRight().accept(results.get(i));
        }
    }

    private List<String> sendMultiGetRequest(List<String> paths){
        if (CollectionUtils.isEmpty(paths)) {
            return Collections.emptyList();
        }

        Assert.isTrue(paths.stream().allMatch(p -> !p.startsWith("http://") && !p.startsWith("https://")), "request path must be relative");
        String mergedPaths = paths.stream().map(p -> {
            try {
                return URLEncoder.encode(p, StandardCharsets.UTF_8.displayName());
            } catch (UnsupportedEncodingException e) {
                log.error("encode fail", e);
                return p;
            }
        }).collect(Collectors.joining(","));


        String source = OkHttpUtils.builder().url("http://demo.com:8301/batch?paths="+mergedPaths).get().sync();
        if(Strings.isNullOrEmpty(source)){
            return Collections.emptyList();
        }

        List<String> resultList = GsonUtils.toJavaList(source, String.class);
        if (CollectionUtils.isEmpty(resultList)) {
            return Collections.emptyList();
        }

        return ObjectUtils.isEmpty(resultList) ? paths.stream().map(p -> "").collect(Collectors.toList()) : resultList;
    }
}

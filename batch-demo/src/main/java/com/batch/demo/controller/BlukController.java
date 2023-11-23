package com.batch.demo.controller;

import com.batch.demo.util.OkHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 模拟底层批量接口
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@Slf4j
@RestController
public class BlukController {
    @Value("${server.port:8301}")
    private Integer serverPort;

    ExecutorService executorService = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors() * 2);
    @GetMapping("/batch")
    public List<String> haha(@RequestParam("paths") String[] paths){
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
                String url = path.startsWith("/") ? "http://localhost:" + serverPort + path : path;
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
}

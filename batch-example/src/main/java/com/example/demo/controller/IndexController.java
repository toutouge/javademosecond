package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟包装接口batch-example应用，在这个应用中需要调用batch-demo应用HomeController中的业务多个接口，但是顺序调用又有网络开销，
 * 所以选择通过batch-demo应用的/batch接口批量调用HomeController中的业务多个接口
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@RestController
public class IndexController {
    /**
     * 聚合接口，
     * 1. 返回当前登录用户信息
     * 2. 查询当前用户写的并且tagId=1的博文列表
     * 3. 查询用户的统计信息，帖子被查看的总数和点赞总数
     *
     * @return
     */

    @Autowired
    FeedService feedService;
    @GetMapping("/feed")
    public Result feed(int id){
        return Result.setSuccessResult(feedService.getFeed(id));
    }
}

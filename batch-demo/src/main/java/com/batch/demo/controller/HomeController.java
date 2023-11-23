package com.batch.demo.controller;

import com.batch.demo.model.Blog;
import com.batch.demo.model.Result;
import com.batch.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模拟底层业务接口
 * @Author chen bo
 * @Date 2024/4
 * @Des
 */
@RestController
public class HomeController {
    @GetMapping("/getuserstatus")
    public Result getUserStatus(int id){
        return Result.setSuccessResult("new");
    }

    @GetMapping("/getcurrentuser")
    public Result getCurrentUser(int id){
        // 暂定这就是登录的用户
        User user = User.builder().id(id).sex(1).userName("张三").build();
        return Result.setSuccessResult(user);
    }

    @GetMapping("/getbloglist")
    public Result getBlogList(){
        List<Blog> blogList = new ArrayList<>();
        Blog blog = Blog.builder().id(1).content("正文1").tagId(1).author("1号主编").build();
        blogList.add(blog);
        Blog blog2 = Blog.builder().id(2).content("正文2").tagId(1).author("2号主编").build();
        blogList.add(blog2);
        Blog blog3 = Blog.builder().id(3).content("正文3").tagId(3).author("3号主编").build();
        blogList.add(blog3);
        return Result.setSuccessResult(blogList);
    }

    @GetMapping("/statistics")
    public Result haha(){
        Map<String, Integer> map = new HashMap<>(2);
        map.put("viewcount", 10000);
        map.put("likecount", 500);
        return Result.setSuccessResult(map);
    }
}

package com.toutou.controller;

import com.toutou.model.vo.ResponseResult;
import com.toutou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author toutou
 * @date by 2020/08
 * @des
 */
@RestController
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping("index")
    public ResponseResult index(int id){
        return ResponseResult.buildSuccessResult(userService.getUserById(id));
    }
}

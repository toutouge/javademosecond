package com.demo.controller.Jump;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by toutou on 2019/1/27.
 */
@RestController
@Slf4j
public class SecondJumpController {

    @RequestMapping(value = "/mysecond")
    public String MySecond(){
        return "mysecond";
    }
}

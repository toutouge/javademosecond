package learn.web.controller;

import learn.model.vo.Result;
import learn.model.vo.UserAccountVO;
import learn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author toutou
 * @date by 2019/07
 */
@RestController
public class UserController {

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/user/hello")
    public String helloWorld() {
        return "hello world.";
    }

    @GetMapping("/user/getuser")
    public Result getUserAccountById(@RequestParam("uid") int id){
        UserAccountVO user = userAccountService.getUserAccountById(id);
        if(user != null){
            return Result.setSuccessResult(user);
        }else{
            return Result.setErrorResult(404, "用户不存在");
        }
    }
}

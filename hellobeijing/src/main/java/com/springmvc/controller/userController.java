package com.springmvc.controller;

import com.springmvc.entity.Userinfo;
import com.springmvc.service.UserinfoService;
import com.springmvc.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by toutou on 2018/5/27.
 */
@Controller
public class userController {
    @Autowired
    private UserinfoService userService;

    @RequestMapping(value="/user/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String loginValidate(HttpSession session, Model model, @ModelAttribute Userinfo user) {
        List<Userinfo> list = new ArrayList<Userinfo>();
        Userinfo record  = new Userinfo();
        record.setName(user.getName());
        list = userService.selectSelective(record);
        if (list.size() == 0) {
            model.addAttribute("status", 1);
        } else {
            record.setPw(Encryption.MD5(user.getPw()));
            list = userService.selectSelective(record);
            if (list.size() == 0) {
                model.addAttribute("status", 2);
            }
            record = list.get(0);
            session.setAttribute("userinfo", record);
            model.addAttribute("status", 0);
        }

        return "login";
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        //session.removeAttribute("user");
        return "login";
    }

    @RequestMapping(value="/user/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, HttpSession session) {
        Userinfo user = (Userinfo) session.getAttribute("userinfo");
        if(user != null){
            model.addAttribute("user", user);
        }

        return "userInfo";
    }

    @RequestMapping(value="/user/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value="/user/register", method = RequestMethod.POST)
    public String addUser(@ModelAttribute Userinfo user, Model model) {
        Userinfo record = new Userinfo();
        record.setName(user.getName());
        List<Userinfo> list = userService.selectSelective(record);
        if (list.size() == 0) {
            user.setCreatetime(new Date());
            user.setPw(Encryption.MD5(user.getPw()));
            if (userService.insert(user) == 1) {
                model.addAttribute("status", 0);
            } else {
                model.addAttribute("status", 1);
            }
        } else {
            model.addAttribute("status", 2);
        }
        return "register";
    }
}

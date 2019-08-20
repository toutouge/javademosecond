package com.demo.controller;

import com.demo.pojo.UserPosition;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by toutou on 2018/10/20.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /***
     * 获取一下附近信息
     * @param request 说明
     * @param model 这是model
     * @param lon 这是lon
     * @param lat test
     * @author 头头
     * @return
     */
    @RequestMapping(value = "/mynearby")
    public String myNearby(HttpServletRequest request, Model model, double lon, double lat)
    {
        double r = 6371;//地球半径千米
        double dis = 2; //半径 单位:km
        double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(lat*Math.PI/180));
        dlng = dlng*180/Math.PI;//角度转为弧度
        double dlat = dis/r;
        dlat = dlat*180/Math.PI;
        double minlat =lat-dlat;
        double maxlat = lat+dlat;
        double minlng = lon -dlng;
        double maxlng = lon + dlng;

        List<UserPosition> list = userService.getVicinity(BigDecimal.valueOf(minlng), BigDecimal.valueOf(maxlng), BigDecimal.valueOf(minlat), BigDecimal.valueOf(maxlat));
        model.addAttribute("myinfo",list);
        return "mynearby";
    }
}

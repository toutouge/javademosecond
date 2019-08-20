package com.csdnspringmvc.controller;

        import com.csdnspringmvc.entity.User;
        import com.csdnspringmvc.entity.User1;
        import com.csdnspringmvc.entity.User2;
        import com.csdnspringmvc.service.User1Service;
        import com.csdnspringmvc.service.User2Service;
        import com.csdnspringmvc.util.Encryption;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import sun.security.provider.MD5;

        import javax.servlet.http.HttpSession;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Random;

/**
 * Created by toutou on 2017/12/20.
 */
@Controller
public class mainController {
    @Autowired
    private User1Service userService;

    @Autowired
    private User2Service user2Service;

    @RequestMapping(value="/lxf/test5/tozc", method = RequestMethod.GET)
    public String toZhuce(){
        return "zc";
    }

    @RequestMapping(value="/lxf/test5/zc", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute User2 user, Model model){
        User2 record = new User2();
        record.setName(user.getName());
        List<User2> list = user2Service.selectSelective(record);
        if(list.size() == 0){
            user.setCreatetime(new Date());
            user.setPw(Encryption.MD5(user.getPw()));
            if(user2Service.insert(user)==1){
                model.addAttribute("result", 1);
            }else{
                model.addAttribute("result", 0);
            }
        }else{
            model.addAttribute("result",2);
        }

        return "zc";
    }

    @RequestMapping(value="/lxf/test5/todl", method=RequestMethod.GET)
    public String toDenglu(){
        return "dl";
    }

    @RequestMapping(value="/lxf/test5/dl", method=RequestMethod.POST)
    public String doDenglu(HttpSession session, Model model, @ModelAttribute User2 user){
        List<User2> list = new ArrayList<User2>();
        User2 record = new User2();
        record.setName(user.getName());
        list = user2Service.selectSelective(record);
        if(list.size() == 0){
            model.addAttribute("result", 0);
        }else{
            record.setPw(Encryption.MD5(user.getPw()));
            list = user2Service.selectSelective(record);
            if(list.size()==0){
                model.addAttribute("result", 1);
            }else{
                record=list.get(0);
                session.setAttribute("user", record);
                model.addAttribute("result", 2);
            }
        }

        return "dl";
    }

    @RequestMapping(value="/lxf/test5/userInfo", method=RequestMethod.GET)
    public String toInfo(Model model, HttpSession session){
        User2 user = (User2)session.getAttribute("user");
        if(user != null){
            model.addAttribute("user", user);
        }

        return "userInfo";
    }

    @RequestMapping(value="/lxf/test5/logout", method=RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "dl";
    }

    @RequestMapping("test/href1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("test/href2")
    public String test2(Model model){
        Random random=new Random();
        model.addAttribute("data", random.nextInt(100));
        return "test2";
    }

    @RequestMapping("test/href3/data={chuan}")
    public String test3(@PathVariable("chuan")String data, Model model){
        model.addAttribute("data", data);
        return "test2";
    }

    @RequestMapping(value="test/href4", method= RequestMethod.GET)
    public String test4(@RequestParam("t1") int begin,
                        @RequestParam("t2") int end, Model model){
        Random r = new Random();
        model.addAttribute("data", begin+r.nextInt(end-begin));
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("fangfa", "GET");
        return  "test4";
    }

    @RequestMapping(value="test/href5", method= RequestMethod.POST)
    public String test5(@RequestParam("t11") int begin,
                        @RequestParam("t22") int end, Model model){
        Random r = new Random();
        model.addAttribute("data", begin+r.nextInt(end-begin));
        model.addAttribute("begin", begin);
        model.addAttribute("end", end);
        model.addAttribute("fangfa", "POST");
        return  "test4";
    }

    // 跳转到user提交界面
    @RequestMapping(value="test/postUser", method= RequestMethod.GET)
    public String toUserPost(){
        return "userPost";
    }

    //提交 保存user
    @RequestMapping(value="test/postUser", method = RequestMethod.POST)
    public String doUserPost(@ModelAttribute User1 user, Model model){
        user.setCreatetime(new Date());
        String result;
        if(userService.insert(user) == 1){
            result = "插入成功！";
        }else{
            result = "插入失败！";
        }

        model.addAttribute("result", result);
        return "userPost";
    }

    @RequestMapping(value="test/getall", method = RequestMethod.GET)
    public String getAll(Model model){
        ArrayList<User1> userList = userService.selectAll();
        model.addAttribute("list", userList);
        return "userList";
    }
}

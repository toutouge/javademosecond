package learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author chen bo
 * @Date 2023/10
 * @Des
 */
@Controller
public class HomeController {
    /**
     * 跳转到websocketDemo.html页面，携带自定义的cid信息。
     * http://localhost:8300/demo/toWebSocketDemo/user-1
     *
     * @param cid
     * @param model
     * @return
     */
    @GetMapping("/demo/toWebSocketDemo/{cid}")
    public String toWebSocketDemo(@PathVariable String cid, Model model) {
        model.addAttribute("cid", cid);
        return "index";
    }

    @GetMapping("hello")
    @ResponseBody
    public String hi(HttpServletResponse response) {
        return "Hi";
    }
}

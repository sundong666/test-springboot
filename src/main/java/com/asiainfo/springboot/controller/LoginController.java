package com.asiainfo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String userLogin(@RequestParam("userName") String userName,
                            @RequestParam("passWord") String passWord,
                            Map<String, Object> map,
                            HttpSession session) {
        if (!StringUtils.isEmpty(userName) && "123456".equals(passWord)) {
            session.setAttribute("userName", userName);
            // 防止登录表单重复提交，采用重定向
            return "redirect:/main.html";
        } else {
            map.put("erro", "用户名或密码错误");
            return "login";
        }
    }

}

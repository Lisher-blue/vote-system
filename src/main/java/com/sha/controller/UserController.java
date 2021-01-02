package com.sha.controller;

import com.sha.entity.User;
import com.sha.exception.UserException;
import com.sha.exception.msg.UserMessage;
import com.sha.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lisher
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("doLogin")
    public String doLogin(User user, Model model, HttpServletRequest request) {

        if (user == null) {
            // 输入为空抛出1000异常
            throw new UserException(UserMessage.USER_CANNOT_BE_NULL);
        }
        User userInfo = userMapper.selectByUserName(user.getUsername());
        if (userInfo == null) {
            model.addAttribute("msg","用户名错误");
            return "login";
        } else {
            if (!userInfo.getPassword().equals(user.getPassword())) {
                model.addAttribute("msg","用户名或者密码错误");
                return "login";
            }
        }
        request.getSession().setAttribute("user",userInfo);
        return "redirect:/index";
    }
}

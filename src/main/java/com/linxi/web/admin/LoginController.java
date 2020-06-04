package com.linxi.web.admin;


import com.linxi.po.User;
import com.linxi.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author linxi
 * @function
 * @project linxiblog
 * @package com.linxi.web.admin
 * @date 2020/4/29-3:22 下午
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

//    跳转到登陆页面
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

//    处理用户名密码
    @PostMapping("/login")
    public String login(@RequestParam String username ,
                        @RequestParam String password,
                        HttpSession session ,
                        RedirectAttributes attributes){
        System.out.println(username+"    "+password);
        System.out.println("=====");
        User user = userService.checkUser(username,password);
        System.out.println(username+"    "+password);
        System.out.println("=====");
        System.out.println(user);

        if (user != null) {
//            用户名密码正确

            System.out.println("用户名密码正确");
//            不传密码到端
            user.setPassword(null);

            session.setAttribute("user", user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message","用户名或密码错误");
//            重定向
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}

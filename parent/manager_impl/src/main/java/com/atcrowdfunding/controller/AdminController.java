package com.atcrowdfunding.controller;

import com.atcrowdfunding.bean.TAdmin;
import com.atcrowdfunding.bean.TMenu;
import com.atcrowdfunding.service.TAdminService;
import com.atcrowdfunding.service.TMenuServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @create 2020-02-04 14:59
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    TAdminService adminService;
    @Autowired
    TMenuServiece menuServiece;

    // 4.跳转用户维护页面
    @GetMapping("/user.html")
    public String toUserPage(Model model){
        List<TAdmin> adminList = adminService.getAllAdmin();
        model.addAttribute("admins", adminList);
        return "admin/user";
    }

    // 3.退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "admin/login";
    }

    // 2.登录成功后跳转页面
    @GetMapping("/main.html")
    public String toMainPage(HttpSession session){
        List<TMenu> menus = menuServiece.getMenus();
        session.setAttribute("menus", menus);
        return "admin/main";
    }

    // 1.处理登录请求
    @PostMapping("/doLogin")
    public String doLogin(TAdmin admin, HttpSession session, Model model){
        //调用业务方法
        TAdmin result = adminService.getAdmin(admin);
        //查询用户是否存在
        if (result == null){
            model.addAttribute("loginacct", admin.getLoginacct());
            model.addAttribute("errorMsg", "账号或密码错误");
            return "admin/login";
        }else {
            session.setAttribute("user", result);
            //登录成功重定向到main页面
            return "redirect:/admin/main.html";
        }
    }
}

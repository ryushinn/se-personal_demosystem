package cn.edu.buaa.se.demosystem.controller;

import cn.edu.buaa.se.demosystem.bean.Admin;
import cn.edu.buaa.se.demosystem.service.AdminService;
import cn.edu.buaa.se.demosystem.service.ApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    ApparatusService apparatusService;

    @PostMapping("/validate")
    public String login(Admin admin, HttpSession session, Model model) {
        if (!adminService.validateLogin(admin, session)) {
            model.addAttribute("message", "用户名或密码错误！");
            return "login";
        }
        return "redirect:/adminSystem";
    }

    @GetMapping("/adminSystem")
    public String showAllApparatuses(Model model) {
        model.addAttribute("apparatuses", apparatusService.findAllApparatuses());
        return "managementPage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "login";
    }



}

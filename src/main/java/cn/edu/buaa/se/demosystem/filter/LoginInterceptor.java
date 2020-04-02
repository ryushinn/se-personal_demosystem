package cn.edu.buaa.se.demosystem.filter;

import cn.edu.buaa.se.demosystem.bean.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
//            request.getServletContext().setAttribute("message", "尚未登录！");
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}

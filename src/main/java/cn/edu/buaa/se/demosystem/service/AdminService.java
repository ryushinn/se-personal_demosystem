package cn.edu.buaa.se.demosystem.service;

import cn.edu.buaa.se.demosystem.bean.Admin;
import cn.edu.buaa.se.demosystem.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Boolean validateLogin(Admin admin, HttpSession session) {
        Admin fromRepo = adminMapper.selectByUsername(admin.getUsername());

        if (fromRepo == null) {
            return false;
        }
        if (!fromRepo.getPassword().equals(admin.getPassword())) {
            return false;
        }
        session.setAttribute("admin", admin);
        return true;
    }
}

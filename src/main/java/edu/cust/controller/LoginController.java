package edu.cust.controller;

import edu.cust.bean.Admin;
import edu.cust.bean.Student;
import edu.cust.service.AdminService;
import edu.cust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;
//    StudentService studentService;
//    @RequestMapping("/admin/login")
//    @ResponseBody
    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam("username") Integer username,
                             @RequestParam("password") String password,
                             Map<String, Object> map,
                             HttpSession session){
        System.out.println(username+"+"+password);
//        Student student = studentService.getStudentById(username);

        List<Admin> adminList = adminService.getAdminById(username,password);

        if(adminList != null && adminList.size()>0){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";//redirect:
        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }

    }
}

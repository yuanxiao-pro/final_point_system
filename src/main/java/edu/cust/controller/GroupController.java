package edu.cust.controller;

import edu.cust.bean.Group;
import edu.cust.service.GroupService;
import edu.cust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    StudentService studentService;

    @Autowired
    GroupService groupService;
    @PostMapping("/group/getIntegral")
    public String getIntegral(Model model){
        List<Group> integrals = groupService.selectIntegralDesc();
        if(integrals != null && integrals.size()>0){
            model.addAttribute("grades",integrals);
            return "redirect:/main.html"; //去到dashboard.html
        } else {
            return "emp/list"; //为空就返回到学生列表
        }
    }

}

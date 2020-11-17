package edu.cust.controller;

import edu.cust.bean.Group;
import edu.cust.bean.Student;
import edu.cust.service.GroupService;
import edu.cust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    GroupService groupService;

    @GetMapping("/stus")
    public String selectAllStudent(Model model){
        List<Student> allStudent = studentService.getAllStudent();
        List<Group> groups= groupService.selectAllGroup();
        model.addAttribute("stus",allStudent);
        model.addAttribute("groups",groups);
        return "emp/list";
    }

    @GetMapping("/stu/toadd")
    public String toAddPage(Model model){
        List<Group> groups= groupService.selectAllGroup();
        model.addAttribute("groups" , groups);
        return "emp/add"; //.html
    }


    @PostMapping("/stu/add")
    public String addStu(Student student,Model model){
        System.out.println("添加的学生基本信息 : "+student);
        boolean flag = studentService.saveStu(student);
        if(flag){
            //跳转页面
            return "redirect:/stus"; //重定向到页面
        }else {
            model.addAttribute("msg","添加失败");
            return "redirect:/stu/toadd";
        }
    }

    @GetMapping("/stu/toedit/{stuId}")
    public String toEditPage(@PathVariable("stuId") Integer stuId, Model model){
        Student student = studentService.getStudentById(stuId);
        model.addAttribute("stu",student);
        List<Group> groups = groupService.selectAllGroup();
        model.addAttribute("groups",groups);
        return "emp/add"; //.html
    }

    @PutMapping("/stu/add")
    public String updateStuById(Student student){
        System.out.println("修改的员工数据："+student);
        studentService.updateStuById(student);
        return "redirect:/stus";
    }

    @DeleteMapping("/stu/del/{stuId}")
    public String deleteStuById(@PathVariable("stuId")Integer stuId){
        studentService.deleteStu(stuId);
        return  "redirect:/stus";
    }
}

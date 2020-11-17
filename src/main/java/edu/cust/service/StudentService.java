package edu.cust.service;

import edu.cust.bean.Student;
import edu.cust.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
//@Repository
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Student getStudentById(Integer id){
        Student student = studentMapper.getStudentById(id);
        if(student != null){
            return student;
        }else {
            System.out.println("无效学号");
            return null;
        }
    }

    public List<Student> getAllStudent(){
        List<Student> students = studentMapper.getAllStudent();
        System.out.println("结果集共"+students.size()+"个学生");
        if(students == null){
            System.out.println("结果集为空");
            return null;
        } else {
            for (Student stu:
                 students) {
                if(stu == null)
                    System.out.println("student is null");
            }
        }
        return students;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveStu(Student student){
        if(student != null){
            studentMapper.saveStu(student);
            return true;
        }
        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStu(Integer id){
        studentMapper.deleteStu(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStuById(Student student){
        studentMapper.updateStuById(student);
    }



}

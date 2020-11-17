package edu.cust.mapper;

import edu.cust.bean.Admin;
import edu.cust.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component //加注解,消除service层中自动注入时的红线
public interface StudentMapper {
    @Select("select * from student_table where stu_id = #{id}")
    public Student getStudentById(Integer id);

    @Select("select * from student_table")
    @ResultType(Student.class)
    public List<Student> getAllStudent();

    @Insert("insert into student_table (stu_id,class_name,stu_name,group_id) " +
            "values (#{stuId},#{className},#{stuName},#{groupId})")
    public void saveStu(Student student);

    @Delete("delete from student_table where stu_id = #{stuId}")
    public void deleteStu(Integer stuId);

    @Update({"<script>",
            "update student_table",
            "  <set>",
            "    <if test='groupId != null'>group_id=#{groupId},</if>",
            "    <if test='stuName != null'>stu_name=#{stuName},</if>",
            "  </set>",
            "where stu_id = #{stuId}",
            "</script>"})
    public void updateStuById(Student student);
}

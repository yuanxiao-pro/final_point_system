package edu.cust.mapper;

import edu.cust.bean.Group;
import edu.cust.bean.Student;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupMapper {

    @Select("SELECT * FROM group_table")
    @ResultType(Group.class)
    public List<Group> selectAllGroup();

    @Select("SELECT * FROM group_table ORDER BY group_integral DESC")
    @ResultType(Group.class)
    public List<Group> selectIntegralDesc();
}

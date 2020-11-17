package edu.cust.mapper;

import edu.cust.bean.Admin;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminMapper {
    @Select("select * from admin_table where admin_id = #{adminId} and admin_pwd = #{pwd}")
    @ResultType(Admin.class)
    public List<Admin> getAdminById(Integer adminId,String pwd);
}

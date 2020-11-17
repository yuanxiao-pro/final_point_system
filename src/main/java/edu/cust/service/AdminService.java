package edu.cust.service;

import edu.cust.bean.Admin;
import edu.cust.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public List<Admin> getAdminById(Integer id,String pwd){
        List<Admin> adminList = adminMapper.getAdminById(id,pwd);
        if (adminList == null){
            System.out.println(id +" <-该管理员不存在");
            return null;
        }else {
            return adminList;
        }

    }

}

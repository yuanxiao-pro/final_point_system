package edu.cust.service;

import edu.cust.bean.Group;
import edu.cust.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupMapper groupMapper;

    public List<Group> selectAllGroup(){
        List<Group> groups = groupMapper.selectAllGroup();

        if(groups != null && groups.size() > 0){
            return groups;
        } else {
            return null;
        }
    }

    public List<Group> selectIntegralDesc(){
        List<Group> grades = groupMapper.selectIntegralDesc();
        if(grades != null && grades.size() > 0){
            return grades;
        } else {
            return null;
        }
    }

}

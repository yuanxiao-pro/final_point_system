package edu.cust.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//JSR303校验和一对多,多对一

@ApiModel("学生类")
public class Student {

    @ApiModelProperty("学生ID")
    private Integer stuId; //学生ID

    @ApiModelProperty("班级号")
    private String className;

    @ApiModelProperty("学生姓名")
    private String stuName;

    //组别,是Group类对象
    @ApiModelProperty("组别")
    private Integer groupId; //一个学生属于一个组

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", className='" + className + '\'' +
                ", stuName='" + stuName + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}

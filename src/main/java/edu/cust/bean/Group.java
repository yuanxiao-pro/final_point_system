package edu.cust.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("学生小组")
public class Group {
    @ApiModelProperty("小组编号")
    private Integer groupId;

    @ApiModelProperty("小组名字")
    private String groupName;

    @ApiModelProperty("小组积分")
    private Integer groupIntegral;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupIntegral() {
        return groupIntegral;
    }

    public void setGroupIntegral(Integer groupIntegral) {
        this.groupIntegral = groupIntegral;
    }
}

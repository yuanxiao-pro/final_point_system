package edu.cust.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("管理员类")
public class Admin {
    @ApiModelProperty("账号")
    private Integer adminId;
    @ApiModelProperty("密码")
    private String adminPwd;
    @ApiModelProperty("头像")
    private String adminImg;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminImg() {
        return adminImg;
    }

    public void setAdminImg(String adminImg) {
        this.adminImg = adminImg;
    }
}

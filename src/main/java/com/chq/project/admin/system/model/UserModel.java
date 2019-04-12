package com.chq.project.admin.system.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 描述：用户管理实体类
 *
 * @author CHQ
 * @date 2019-01-19
 */
public class UserModel {


    @ApiModelProperty(value = "主键", example = "123")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "用户类型(0:管理员1:用户)", example = "123")
    private Integer userType;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "是否可用(0:不可用1:可用)", example = "123")
    private String isUsable;

    @ApiModelProperty(value = "是否删除(0:否1:是)", example = "123")
    private Integer isDelete;

    private List<RoleModel> roleList;

    /**
     * 排序字段默认为id
     */
    private String sortCode = "id";

    /**
     * 排序规则默认为降序排列(DESC/ASC)
     */
    private String sortRole = "DESC";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIsUsable() {
        return isUsable;
    }

    public void setIsUsable(String isUsable) {
        this.isUsable = isUsable;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSortRole() {
        return sortRole;
    }

    public void setSortRole(String sortRole) {
        this.sortRole = sortRole;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public List<RoleModel> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleModel> roleList) {
        this.roleList = roleList;
    }
}
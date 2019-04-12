package com.chq.project.admin.system.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
* 描述：角色管理实体类
* @author CHQ
* @date 2019-01-19
*/

public class RoleModel {


    @ApiModelProperty(value = "主键",example = "123")
    private Integer id;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "是否可用(0:不可用1:可用)",example = "123")
    private Integer isUsable;

    @ApiModelProperty(value = "是否删除(0:否1:是)",example = "123")
    private Integer isDelete;

    private List<PermissionModel> permissionList;

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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getIsUsable() {
        return isUsable;
    }

    public void setIsUsable(Integer isUsable) {
        this.isUsable = isUsable;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getSortRole() {
        return sortRole;
    }

    public void setSortRole(String sortRole) {
        this.sortRole = sortRole;
    }

    public List<PermissionModel> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionModel> permissionList) {
        this.permissionList = permissionList;
    }
}
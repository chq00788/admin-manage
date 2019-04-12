package com.chq.project.admin.system.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;


/**
 * 描述：权限管理实体类
 *
 * @author CHQ
 * @date 2019-01-19
 */

public class PermissionModel implements Serializable {

    @ApiModelProperty(value = "主键", example = "123")
    private Integer id;

    @ApiModelProperty(value = "权限名称")
    private String permName;

    @ApiModelProperty(value = "权限编码")
    private String permCode;

    @ApiModelProperty(value = "类型(1:菜单2:按钮)", example = "123")
    private Integer permType;

    @ApiModelProperty(value = "菜单路径")
    private String permUrl;

    @ApiModelProperty(value = "排序", example = "123")
    private Integer permSort;

    @ApiModelProperty(value = "父ID", example = "123")
    private Integer permPid;

    @ApiModelProperty(value = "图标")
    private String permIcon;

    @ApiModelProperty(value = "是否可用(0:不可用1:可用)", example = "123")
    private Integer isUsable;

    @ApiModelProperty(value = "是否删除(0:否1:是)", example = "123")
    private Integer isDelete;

    /**
     * 子节点
     */
    private List<PermissionModel> children;

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

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    public Integer getPermType() {
        return permType;
    }

    public void setPermType(Integer permType) {
        this.permType = permType;
    }

    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    public Integer getPermSort() {
        return permSort;
    }

    public void setPermSort(Integer permSort) {
        this.permSort = permSort;
    }

    public Integer getPermPid() {
        return permPid;
    }

    public void setPermPid(Integer permPid) {
        this.permPid = permPid;
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

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        PermissionModel model = (PermissionModel) obj;
        if (this.id.equals(model.getId())) {
            return true;
        }
        return false;
    }

    public List<PermissionModel> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionModel> children) {
        this.children = children;
    }

    public String getPermIcon() {
        return permIcon;
    }

    public void setPermIcon(String permIcon) {
        this.permIcon = permIcon;
    }
}
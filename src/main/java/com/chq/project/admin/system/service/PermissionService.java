package com.chq.project.admin.system.service;

import com.chq.project.admin.system.dao.PermissionDao;
import com.chq.project.admin.system.model.PermissionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* 描述：权限管理 服务实现层
* @author CHQ
* @date 2019-01-19
*/
@Service
public class PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    /**
    * 查询数据
    *
    * @return
    */
    public List<PermissionModel> selectList(Map<String, Object> searchMap) {
        return permissionDao.selectList(searchMap);
    }


    /**
    * 新增数据
    *
    * @param model
    */
    public void insert(PermissionModel model) {
        permissionDao.insert(model);
    }

    /**
    * 更新数据
    *
    * @param model
    */
    public void update(PermissionModel model) {
        permissionDao.update(model);
    }

    /**
    * 删除数据
    *
    * @param id
    */
    public void delete(Integer id) {
        permissionDao.delete(id);
    }

    /**
    * 根据ID查询数据
    *
    * @param id
    */
    public PermissionModel getById(Integer id) {
        return permissionDao.getById(id);
    }
}
package com.chq.project.admin.system.service;

import com.chq.project.admin.system.dao.RoleDao;
import com.chq.project.admin.system.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* 描述：角色管理 服务实现层
* @author CHQ
* @date 2019-01-19
*/
@Service
public class RoleService{

    @Autowired
    private RoleDao roleDao;

    /**
    * 查询数据
    *
    * @return
    */
    public List<RoleModel> selectList(Map<String, Object> searchMap) {
        return roleDao.selectList(searchMap);
    }


    /**
    * 新增数据
    *
    * @param model
    */
    public void insert(RoleModel model) {
        roleDao.insert(model);
    }

    /**
    * 更新数据
    *
    * @param model
    */
    public void update(RoleModel model) {
        roleDao.update(model);
    }

    /**
    * 删除数据
    *
    * @param id
    */
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    /**
    * 根据ID查询数据
    *
    * @param id
    */
    public RoleModel getById(Integer id) {
        return roleDao.getById(id);
    }
}
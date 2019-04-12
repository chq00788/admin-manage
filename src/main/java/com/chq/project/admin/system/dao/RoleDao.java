package com.chq.project.admin.system.dao;

import com.chq.project.admin.system.model.RoleModel;

import java.util.List;
import java.util.Map;

/**
* 描述：角色管理 Dao接口
* @author CHQ
* @date 2019-01-19
*/
public interface RoleDao {


    /**
    * 查询数据信息
    *
    * @param searchMap
    * @return
    */
    List<RoleModel> selectList(Map<String, Object> searchMap);

    /**
    * 新增
    *
    * @param model
    * @return
    */
    Integer insert(RoleModel model);

    /**
    * 更新
    *
    * @param model
    * @return
    */
    Integer update(RoleModel model);

    /**
    * 删除
    *
    * @param id
    * @return
    */
    Integer delete(Integer id);

    /**
    * 根据ID查询
    *
    * @param id
    * @return
    */
    RoleModel getById(Integer id);

}
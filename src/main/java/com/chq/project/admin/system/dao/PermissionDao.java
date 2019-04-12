package com.chq.project.admin.system.dao;

import com.chq.project.admin.system.model.PermissionModel;

import java.util.List;
import java.util.Map;

/**
 * 描述：权限管理 Dao接口
 *
 * @author CHQ
 * @date 2019-01-19
 */
public interface PermissionDao {


    /**
     * 查询数据信息
     *
     * @param searchMap
     * @return
     */
    List<PermissionModel> selectList(Map<String, Object> searchMap);

    /**
     * 查询所有数据信息
     *
     * @return
     */
    List<PermissionModel> findAll();

    /**
     * 新增
     *
     * @param model
     * @return
     */
    Integer insert(PermissionModel model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    Integer update(PermissionModel model);

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
    PermissionModel getById(Integer id);

}
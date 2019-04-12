package com.chq.project.admin.system.dao;

import com.chq.project.admin.system.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 描述：用户管理 Dao接口
 *
 * @author CHQ
 * @date 2019-01-19
 */
public interface UserDao {


    /**
     * 查询数据信息
     *
     * @param searchMap
     * @return
     */
    List<UserModel> selectList(Map<String, Object> searchMap);

    /**
     * 新增
     *
     * @param model
     * @return
     */
    Integer insert(UserModel model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    Integer update(UserModel model);

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
    UserModel getById(Integer id);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    UserModel getByUsername(@Param(value = "username") String username);

    /**
     * 查询用户的菜单权限
     *
     * @param id
     * @return
     */
    UserModel getMenusByUserId(Integer id);

    /**
     * 查询用户的菜单权限
     *
     * @param username
     * @return
     */
    UserModel getMenusByUsername(String username);

    /**
     * 添加用户角色信息
     *
     * @param userId
     * @param roleId
     * @return
     */
    Integer saveUserRole(@Param(value = "userId") Integer userId, @Param(value = "roleId") Integer roleId);
}
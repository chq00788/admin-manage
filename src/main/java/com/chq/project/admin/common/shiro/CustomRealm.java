package com.chq.project.admin.common.shiro;


import com.chq.project.admin.common.entity.JwtToken;
import com.chq.project.admin.common.utils.JwtUtil;
import com.chq.project.admin.system.model.PermissionModel;
import com.chq.project.admin.system.model.UserModel;
import com.chq.project.admin.system.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author CHQ
 * @Description 自定义 Realm
 * @date 2019/4/2
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("认证失败,请重新登录!");
        }
        UserModel user = userService.getByUsername(username);
        if (user == null) {
            throw new AuthenticationException("该用户不存在!");
        }
//        if (!JwtUtil.verify(token, username, user.getPassword())) {
//            throw new AuthenticationException("登录信息过期,请重新登录!");
//        }
        int ban = Integer.valueOf(user.getIsUsable());
        if (ban == 0) {
            throw new AuthenticationException("该账号已被禁用!");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        String username = JwtUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<PermissionModel> permissionList = userService.getPermissionsByUsername(username);
        //获取该用户所有权限
        Set<String> permissionSet = new HashSet<>();
        for (PermissionModel model : permissionList) {
            if (StringUtils.isNotBlank(model.getPermCode())) {
                permissionSet.add(model.getPermCode());
            }
        }
        //需要将 permission 封装到 Set 作为info.setStringPermissions() 的参数
        //设置该用户拥有和权限
//        info.setStringPermissions(permissionSet);
        info.addStringPermissions(permissionSet);
        return info;
    }

}

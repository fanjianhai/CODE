package com.xiaofan.config;

import com.xiaofan.pojo.User;
import com.xiaofan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义 UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了===> 授权方法");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 拿到当前用户的对象
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        // 设置当前用户的权限
        info.addStringPermission(user.getPerms());
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了===> 认证方法");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        // 用户名认证
        User user = userService.queryUserByName(userToken.getUsername());

        if (user == null) {
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser", user);

        // 可以加密： MD5、MD5盐值加密
        // 密码认证 shiro做~
        return new SimpleAuthenticationInfo(user,user.getPwd(), "");
    }
}

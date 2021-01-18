package com.xiaofan.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 创建realm对象（需要自定义）1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    // DefaultWebSecurityManager 2
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // ShiroFilterFactoryBean
    // 注意这里的限定词Qualifier的使用方法的名字
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        /**
         * 添加shiro内置的过滤器
         * anon: 无需认证就可以访问
         * authc：必须认证了才能访问
         * user：必须拥有“记住我”功能才能使用
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        Map<String, String> filterChainDefinitionMap = new HashMap<>();

        // 授权, 未授权应该跳转到未授权页面
        filterChainDefinitionMap.put("/user/add", "perms[user:add]");
        filterChainDefinitionMap.put("/user/update", "perms[user:update]");

        /*filterChainDefinitionMap.put("/user/add", "authc");
        filterChainDefinitionMap.put("/user/update", "authc");*/
        filterChainDefinitionMap.put("/user/*", "authc");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 设置登录的请求
        bean.setLoginUrl("/toLogin");

        // 设置未授权的页面
        bean.setUnauthorizedUrl("/noauth");

        bean.setSecurityManager(defaultWebSecurityManager);
        return bean;
    }

    // 整合ShiroDialect 和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}

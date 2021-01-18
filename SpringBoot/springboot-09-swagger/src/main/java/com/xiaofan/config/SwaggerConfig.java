package com.xiaofan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        // 判断是否处在在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)      // 是否启动swagger
                .groupName("雪山飞狐")
                .select()
                /**
                 * 配置要扫描的接口的方式 RequestHandlerSelectors
                 * basePackage：指定要扫描的包
                 * any(): 扫描全部
                 * none()：不扫描
                 * withClassAnnotation(RestController.class): 扫描类上有RestController.class的注解
                 * withMethodAnnotation(GetMapping.class):    扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.xiaofan.controller"))
                // 过滤请求路径
                .paths(PathSelectors.ant("/xiaofan/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("雪山飞狐", "https://blog.csdn.net/fanjianhai", "594042358@qq.com");

        return new ApiInfo(
                "小范的SwaggerAPI文档",
                "即使再小的帆也能远航",
                "v1.0",
                "https://github.com/fanjianhai/kuangshen",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}

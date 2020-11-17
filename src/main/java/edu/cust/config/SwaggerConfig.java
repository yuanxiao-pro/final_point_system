package edu.cust.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {
    //在这里配置swagger信息(私有方法)
    private ApiInfo apiInfo() {
        Contact contact = new Contact("xiaoj", "https://blog.csdn.net/qq_45596525", "1665219552@qq.com");
        return new ApiInfo(
                "Xiaoj的blog",
                "流水不争先",
                "1.0",
                "https://blog.csdn.net/qq_45596525",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

    //docket对象接管容器
    @Bean
    public Docket docket(Environment environment) { //向docket容器传入环境参数
        //根据当前环境判断是否开启swagger
        Profiles profile = Profiles.of("dev", "test"); //指定再开发和测试环境中开启swagger
        boolean flag = environment.acceptsProfiles(profile);//传入参数

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("xiaoj")
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                //添加接口处理方式,扫描controller包下的内容
                .apis(RequestHandlerSelectors.basePackage("edu.cust.controller"))
//                    .apis(RequestHandlerSelectors.basePackage("edu.cust.cs.springboot08swagger.pojo"))
                .build(); //向docket加入apiInfo()
    }

    @Bean
    public Docket docket01() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

}
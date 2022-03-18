package com.suue.bmmp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2API文档的配置
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).groupName("产品接口组")
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.suue.bmmp.controller"))
                .build();
        return docket;
    }


    //构建 api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")
                .contact(new Contact("sds", "http://www.sds.com", ""))
                .version("1.0")
                .description("Swagger3的访问地址为 http://{host}:{port}/swagger-ui/")
                .build();
    }
}

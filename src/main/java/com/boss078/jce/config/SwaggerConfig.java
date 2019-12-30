package com.boss078.jce.config;

import com.boss078.jce.controllers.AdvertiserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = AdvertiserController.class)
public class SwaggerConfig {

    public static final String SWAGGER_VERSION = "1.0";
    public static final String LICENSE_TEXT = "License for JCE project";
    public static final String title = "API for JCE project";
    public static final String descriotion = "This is RESTful API for Java Code Example project";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(descriotion)
                .license(LICENSE_TEXT)
                .version(SWAGGER_VERSION)
                .build();
    }

    @Bean
    public Docket advertisersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("api/*"))
                .build();
    }
}
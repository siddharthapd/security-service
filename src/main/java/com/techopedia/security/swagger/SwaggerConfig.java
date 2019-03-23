package com.techopedia.security.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.techopedia.security.endpoint"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Security Rest API",
                "Security Rest API for validating users",
                "1.0",
                "https://www.linkedin.com/in/siddharthapd",
                new Contact("Siddhartha Prasad", "https://www.linkedin.com/in/siddharthapd", "sid.cse2013@gmail.com"),
                "License of API", "https://www.linkedin.com/in/siddharthapd", Collections.emptyList());
    }
}

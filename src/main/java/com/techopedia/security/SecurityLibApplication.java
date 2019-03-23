package com.techopedia.security;

import com.techopedia.security.endpoint.LoginRestController;
import com.techopedia.security.swagger.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackageClasses = {LoginRestController.class, SwaggerConfig.class})
@EnableEurekaClient
public class SecurityLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityLibApplication.class, args);
    }

}

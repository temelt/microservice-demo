package com.temelt.common.util;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Created by temelt on 29.01.2019.
 */
public class SwaggerUtil {

    public static Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private static ApiInfo apiInfo() {
        return new ApiInfo(
                "Microservice Demo",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("Taner TEMEL", "www.temel.com", "tanertemel@outlook.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}

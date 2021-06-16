package com.myorganization.myservice.configuration;

import static com.google.common.collect.Lists.newArrayList;
import static com.myorganization.myservice.constants.SwaggerConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.myorganization.myservice.bundle.BundleDefinition;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableSwagger2
public class SwaggerConfig{

    @Autowired
    BundleDefinition bundleDefinition;


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE_KEY))
                .build().pathMapping("/").apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title(API_TITLE).description(API_DESCRIPTOR).extensions(createVendorExtensions()).version(API_VERSION).build();
    }

    @SuppressWarnings("rawtypes")
    private List<VendorExtension> createVendorExtensions(){
        return newArrayList(bundleDefinition.createInfoExtension(), bundleDefinition.createBundleExtensions());
    }

}
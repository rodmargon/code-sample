package com.myorganization.myservice.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.myorganization.myservice.bundle.BundleDefinition;

@SpringBootConfiguration
public class BundleDefinitionConfiguration {

    @Bean
    public BundleDefinition bundleDefinition(MessageSource messageSource){
        BundleDefinition bundleDefinition = new BundleDefinition();
        bundleDefinition.setMessageSource(messageSource);
        return bundleDefinition;
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/translation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
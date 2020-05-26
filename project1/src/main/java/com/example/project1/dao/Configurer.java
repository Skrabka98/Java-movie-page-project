package com.example.project1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@Configuration
public class Configurer implements WebMvcConfigurer {

    @Autowired
    private Set<HandlerInterceptor> interceptors;

    @Override
    public void addInterceptors(final InterceptorRegistry interceptorRegistry){
        interceptors.stream().forEach(interceptorRegistry::addInterceptor);
    }
}

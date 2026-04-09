package com.example.courseapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // 标记为配置类，Spring 启动时自动加载
public class MvcConfig implements WebMvcConfigurer {

    // 配置 JSP 视图解析器：映射 Controller 返回值到实际 JSP 文件路径
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 1. 前缀：JSP 文件存放的根目录（必须和你的实际文件路径一致）
        resolver.setPrefix("/WEB-INF/jsp/"); 
        // 2. 后缀：自动拼接 .jsp 后缀
        resolver.setSuffix(".jsp"); 
        // 注册解析器
        registry.viewResolver(resolver);
    }
}
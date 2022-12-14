package com.example.takeaway.config;

import com.example.takeaway.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

// WebMvcConfigurationSupport 注册拦截器用的
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
//  设置静态资源的映射
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始进行静态资源映射");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        创建消息转换器
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        设置对象转换器
        mappingJackson2HttpMessageConverter.setObjectMapper(new JacksonObjectMapper());
//        将上面的消息转换器添加到mvc框架的转换器集合中
        converters.add(0,mappingJackson2HttpMessageConverter);
    }
}

package com.kind1ess.config;

import com.kind1ess.component.LoginHandlerInterceptor;
import com.kind1ess.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * SpringBoot 2.x版本需要实现WebMvcConfigurer接口
 * SpringBoot 1.x需要继承WebMvcConfigurerAdapter
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //浏览器发送请求/kind1ess来到success
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/kind1ess").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login","/webjars/**");
            }
        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

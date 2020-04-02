package cn.edu.buaa.se.demosystem.config;

import cn.edu.buaa.se.demosystem.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> static_files = new ArrayList<>();
        static_files.add("/images/**");
        static_files.add("/css/**");
        static_files.add("/js/**");
        static_files.add("/webjars/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login").excludePathPatterns("/").excludePathPatterns("/index")
                .excludePathPatterns("/validate")
                .excludePathPatterns(static_files);
    }
}

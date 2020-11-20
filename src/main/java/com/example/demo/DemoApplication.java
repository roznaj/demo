package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements WebMvcConfigurer{
   

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

       
        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
        
    }

}

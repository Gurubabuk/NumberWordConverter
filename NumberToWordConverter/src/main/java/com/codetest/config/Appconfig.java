package com.codetest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = { "com.codetest.*" })
	public class Appconfig extends WebMvcConfigurerAdapter {

	  @Bean
	  public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/view/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	  }

	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/");
	  }

	
}

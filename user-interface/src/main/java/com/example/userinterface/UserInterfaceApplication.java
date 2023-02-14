package com.example.userinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.applicationservice.service.master.*;

@SpringBootApplication
public class UserInterfaceApplication {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext app = new AnnotationConfigApplicationContext(SpringDiConfig.class);
		
		@SuppressWarnings("unused")
		PersonService personService = app.getBean(PersonService.class);
		
		SpringApplication.run(UserInterfaceApplication.class, args);
	}

    @Bean
    public FilterRegistrationBean<?> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>(new LoggingFilter());
        registrationBean.setOrder(Integer.MIN_VALUE);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

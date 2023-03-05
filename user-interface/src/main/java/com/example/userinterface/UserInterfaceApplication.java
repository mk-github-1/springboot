package com.example.userinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


// @SpringBootApplicationにより、基本的にComponentは自動スキャンされる
@SpringBootApplication
public class UserInterfaceApplication {

	public static void main(String[] args) {
		// Application起動時に実行したいDIはここに記載、デフォルトでsingletonになる
		/*
		1. ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		2. ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.example.applicationservice);
		3. ApplicationContext applicationContext = new ClassPassXmlApplicationContext("META-INF/spring/");
		4. ApplicationContext applicationContext = new FileSystemXmlApplicationContext("./spring/applicationContext.xml");
		PersonService personService = applicationContext.getBean(”PersonService”, PersonService.class);
		 */

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

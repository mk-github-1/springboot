package com.example.userinterface.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * WebApplicationのConfig
 *
 * 'Spring徹底入門'を引用
 */
public class WebApplicationConfig /* extends WebMvcConfigurerAdapter */ {

    /**
	 *　OpenEntityManagerInViewInterceptorのBean定義を行う
	 */
	@Bean
	public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
		return new OpenEntityManagerInViewInterceptor();
	}

    /**
	 *　Open EntityManager in Viewパターンの設定
	 */
	//@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addWebRequestInterceptor(openEntityManagerInViewInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/**/*.html")
			.excludePathPatterns("/**/*.js")
			.excludePathPatterns("/**/*.css")
			.excludePathPatterns("/**/*.png");
	}
}

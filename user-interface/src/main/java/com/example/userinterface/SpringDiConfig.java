package com.example.userinterface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.applicationservice.service.implement.master.*;
import com.example.applicationservice.service.master.*;

/*
import com.example.domainservice.repository.master.*;
import com.example.infrastructure.implement.repository.master.*;
 */

// 主にコンポーネントスキャンによる自動登録ができない（例. 外部ライブラリに含まれるクラスをBeanとして登録する）場合に使われる。
// 自作クラスは@Service, @Repository, @ComponentアノテーションでOK

/*
@Configuration
public class SpringDiConfig {

	@Bean
	public PersonService personService() {
		return new PersonService();
	}
}
 */
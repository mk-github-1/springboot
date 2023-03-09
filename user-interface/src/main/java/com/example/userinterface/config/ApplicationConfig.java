package com.example.userinterface.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ApplicationのConfig
 * Spring DIをConfiguration方法
 * 主にコンポーネントスキャンによる自動登録ができない時に使用
 * 通常はアノテーション方法(@Service, @Repository, @Component)でOK
 *
 * 'Spring徹底入門'を引用
 */
@Configuration
public class ApplicationConfig {

    /**
	 * constructor
	 */
	public ApplicationConfig() {

	}

	/* 例
	@Bean
	PersonRepository personRepository() {
		return new PersonRepositoryImplements();
	}

	@Bean
	PersonService personService() {
		return new PersonServiceImplements(personRepository());
	}

	// LightWeightインタフェースを作成すると、Qualifierで利用可能
	@Bean（name = "lightweight"）
	PasswordEncoder sha256PasswordEncoder() {
		return new BCryptPasswordEncoder();
	｝

	// コンストラクタインジェクションにするので@Resourceは使用しないこと
	 */
}

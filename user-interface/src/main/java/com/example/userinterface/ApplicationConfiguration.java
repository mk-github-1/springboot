package com.example.userinterface;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	// Java configuration方法
	// 主にコンポーネントスキャンによる自動登録ができない（例. 外部ライブラリに含まれるクラスをBeanとして登録する）場合に使われる。
	// ↓
	//
	// 通常はアノテーションベースConfigurationでOK　（@Service, @Repository, @Component）
    // @Autowiredは省略可能

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

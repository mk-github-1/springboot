package com.example.userinterface.config;

/*
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
 */

/**
 * JpaのConfig
 *
 * 'Spring徹底入門'を引用
 */
/*
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.example.applicationservice")
public class JpaConfig {

	private final DataSource dataSource;

    // constructor
	public JpaConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    // JpaVenderAdapterのBean定義を行う
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		// JPA実装の独自設定を行うため、JpaVenderAdapterインタフェースの実装クラスのBeanを定義する
		HibernateJpaVendorAdapter hibernateJpaVendorAdaptor = new HibernateJpaVendorAdapter();

		// 使用するデータベース製品を指定する
		hibernateJpaVendorAdaptor.setDatabase(Database.POSTGRESQL);

		// Hibernateがデータベースに対して発行するSQLをコンソールに出力する機能を有効化する
		hibernateJpaVendorAdaptor.setShowSql(true);

		return hibernateJpaVendorAdaptor;
	}

    // LocalContainerEntityManagerFactoryBeanのBean定義を行う
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
		// LocalContainerEntityManagerFactoryBeanを定義し、指定されたJPAが提供するEntityManagerFactoryがBeanとしてDIコンテナ上で管理されるようにする
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		// JPAの永続化処理で使用するデータソースを設定する
		localContainerEntityManagerFactoryBean.setDataSource(this.dataSource);

		// Entityクラスが定義されているパッケージを指定する　※ModelでなくEntityを指定するように変更する？
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.domainmodel");

		// 定義したJpaVenderAdapterを指定する
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());

		return localContainerEntityManagerFactoryBean;
	}

    // PlatformTransactionManagerのBean定義を行う ※JpaTransactionManager（@Transactional）の利用
	@Bean
	public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}
}
 */

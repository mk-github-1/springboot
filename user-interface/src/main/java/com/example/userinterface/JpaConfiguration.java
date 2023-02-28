package com.example.userinterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import jakarta.activation.DataSource;

@Configuration
public class JpaConfiguration {

	/*
	@SuppressWarnings("unused")
	@Autowired
	private DataSource dataSource;

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		// JPA実装の独自設定を行うため、JpaVenderAdapterインタフェースの実装クラスのBeanを定義
		// 使用するデータベースを指定
		// HibernateのSQLをコンソール出力する
		HibernateJpaVendorAdapter hibernateJpaVendorAdaptor = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdaptor.setDatabase(Database.POSTGRESQL);
		hibernateJpaVendorAdaptor.setShowSql(true);
		return hibernateJpaVendorAdaptor;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
		// EntityManagerFactoryをBean定義として、DIコンテナ上で管理できるようにする
		// JPAで使用するデータベースを指定
		// Entityクラスが定義されているパッケージを指定　※ModelでなくEntityを指定するように変更する
		// 作成したJpaVenderAdapterを指定する
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource);
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.domainmodel");
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		return localContainerEntityManagerFactoryBean;
	}
	 */

}

package com.yongbingxue.blog;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Profile({ "local", "uat", "production" })
@Configuration
public class DatabaseConfiguration {
	@Bean
	@ConfigurationProperties(prefix = "datasource.tomcat")
	public DataSource dataSource() {
		return new DataSource();
	}

	//@formatter:off
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSource())
				.packages("com.yongbingxue.blog.entity")
				.build();
	}
	//@formatter:on
}

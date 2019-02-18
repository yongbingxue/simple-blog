package com.yongbingxue.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.yongbingxue.blog.entity.EntityBase;

@SpringBootApplication
@EntityScan(basePackageClasses = EntityBase.class)
@ComponentScan(basePackages = { "com.yongbingxue.blog" })
public class AppBoot extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppBoot.class, args);
	}

}

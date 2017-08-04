package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
//	    app.setBannerMode(Banner.Mode.OFF);
	    app.run(args);
	}
}

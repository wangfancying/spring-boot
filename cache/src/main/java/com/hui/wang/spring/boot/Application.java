package com.hui.wang.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 注解 @EnableCaching	开启缓存功能，放在配置类或启动类上
 *
 * @author hui.wang09
 * @since 14 November 2018
 */
@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

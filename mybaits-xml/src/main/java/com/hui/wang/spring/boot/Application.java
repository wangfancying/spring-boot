package com.hui.wang.spring.boot;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring 整合 mybaits ，使用xml方式
 *
 * @author hui.wang09
 * @since 09 十月 2018
 */
@SpringBootApplication
@MapperScan("com.hui.wang.spring.boot.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

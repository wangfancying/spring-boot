package com.hui.wang.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hui.wang09
 * @since 09 十月 2018
 */
@RestController
public class HelloWorld {

	@RequestMapping("/")
	public String index() {
		return "hello,world";
	}
}

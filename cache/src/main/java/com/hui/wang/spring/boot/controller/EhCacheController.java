package com.hui.wang.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hui.wang09
 * @since 14 November 2018
 */
@RestController
@CacheConfig(cacheNames = "myEhCache")
public class EhCacheController {

	private static Logger LOGGER = LoggerFactory.getLogger(EhCacheController.class);

	@RequestMapping("/ehcache")
	@Cacheable(key = "#request")
	public String ehcacahe(@RequestParam String request) {
		LOGGER.info("==========================");
		LOGGER.info("执行ehcache方法");
		LOGGER.info("==========================");
		return request;
	}
}

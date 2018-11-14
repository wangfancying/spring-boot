package com.hui.wang.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用spring cache
 *
 * 常用注解含义
 * 注解@CacheConfig，在类上设置当前缓存的一些公共设置，比如缓存名称；
 * 注解@Cacheable，作用在方法上，触发缓存读取操作。表明该方法的结果是可以缓存的，如果缓存存在，则目标方法不会被调用，直接取出缓存。
 * 注解@CacheEvice，作用在方法上，触发缓存失效操作，删除缓存项或者清空缓存；
 * 注解@CachePut，作用在方法上，触发缓存更新操作
 * 注解@Caching，作用在方法上，综合上面的各种操作，在有些场景上，调用业务会触发多种缓存操作。
 *
 *
 * @author hui.wang09
 * @since 14 November 2018
 */
@RestController
public class HelloController {

	private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	/**
	 * 注解@Cacheable可以标记在一个方法上，也可以标记在一个类上。当标记在一个方法上时表示该方法是支持缓存的，
	 * 当标记在一个类上时则表示该类所有的方法都是支持缓存的。@Cacheable可以指定三个属性，value、key和condition。
	 *
	 * value：缓存的名称，在 spring 配置文件中定义，必须指定至少一个。如@Cacheable(value=”mycache”)
	 * key：缓存的 key，可以为空，如果指定要按照SpEL表达式编写，如果不指定，则缺省按照方法的所有参数进行组合。
	 * 		如@Cacheable(value=”mycache”,key=”#request”)
	 * condition：缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存。
	 * 		如@Cacheable(value=”mycache”,condition=”#request.length()>2”)
	 *
	 */
	@RequestMapping("/hello")
	@Cacheable(value = "myEhCache", key = "#request")
	public String hello(@RequestParam String request) {
		LOGGER.info("==========================");
		LOGGER.info("执行hello方法");
		LOGGER.info("==========================");
		return request;
	}

	/**
	 * 注解@CachePut使用方式和@Cacheable是一样的
	 * Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，
	 * 而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
	 *
	 */
	@RequestMapping("/put")
	@CachePut(value = "mycache", key = "#request")
	public String put(@RequestParam String request) {
		LOGGER.info("==========================");
		LOGGER.info("执行put方法");
		LOGGER.info("==========================");
		return request + 1;
	}
}

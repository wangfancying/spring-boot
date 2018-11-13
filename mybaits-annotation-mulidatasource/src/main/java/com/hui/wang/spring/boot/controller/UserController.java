package com.hui.wang.spring.boot.controller;

import java.util.List;

import com.hui.wang.spring.boot.domain.UserEntity;
import com.hui.wang.spring.boot.mapper.datasource1.UserMapper1;
import com.hui.wang.spring.boot.mapper.datasource2.UserMapper2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hui.wang09
 * @since 09 十月 2018
 */
@RestController
public class UserController {

	@Autowired
	private UserMapper1 userMapper1;

	@Autowired
	private UserMapper2 userMapper2;

	@RequestMapping("getUsers")
	public List<UserEntity> getUsers() {
		return userMapper1.getAll();
	}

	@RequestMapping("/getUser")
	public UserEntity getUser(Long id) {
		UserEntity user = userMapper2.getOne(id);
		return user;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody UserEntity user) {
		userMapper2.insert(user);
	}


	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userMapper1.delete(id);
	}
}

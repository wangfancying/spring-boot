package com.hui.wang.spring.boot.controller;

import java.util.List;

import com.hui.wang.spring.boot.domain.UserEntity;
import com.hui.wang.spring.boot.mapper.UserMapper;

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
	private UserMapper userMapper;

	@RequestMapping("getUsers")
	public List<UserEntity> getUsers() {
		return userMapper.getAll();
	}

	@RequestMapping("/getUser")
	public UserEntity getUser(Long id) {
		UserEntity user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void save(@RequestBody UserEntity user) {
		userMapper.insert(user);
	}


	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}
}

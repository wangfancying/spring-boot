package com.hui.wang.spring.boot.domain;

import java.io.Serializable;

import com.hui.wang.spring.boot.enums.UserSexEnum;

/**
 * @author hui.wang09
 * @since 09 十月 2018
 */
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserSexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "userName:" + this.userName + ", password:" + this.passWord + ", sex:" + this.userSex;
	}
}

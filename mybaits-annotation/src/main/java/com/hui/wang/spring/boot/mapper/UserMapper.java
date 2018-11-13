package com.hui.wang.spring.boot.mapper;

import java.util.List;

import com.hui.wang.spring.boot.domain.UserEntity;
import com.hui.wang.spring.boot.enums.UserSexEnum;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author hui.wang09
 * @since 09 十月 2018
 */
public interface UserMapper {

	@Select("select * from user ")
	@Results({
			@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name")
	})
	List<UserEntity> getAll();

	@Select("select * from user where id=#{id}")
	@Results({
			@Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
			@Result(property = "nickName", column = "nick_name")
	})
	UserEntity getOne(Long id);

	@Insert("insert into user (userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserEntity userEntity);


	@Delete("DELETE FROM user WHERE id =#{id}")
	void delete(Long id);
}

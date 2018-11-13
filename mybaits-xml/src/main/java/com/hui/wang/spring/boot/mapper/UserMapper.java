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

	List<UserEntity> getAll();

	UserEntity getOne(Long id);

	void insert(UserEntity userEntity);

	void delete(Long id);
}

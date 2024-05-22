package org.bitcprac.boot05.mapper;

import org.apache.ibatis.annotations.*;
import org.bitcprac.boot05.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

	//XML 대신 @sql 로 바로 작성
	@Select("select * from mybatis_user where id=#{id}")
	public User getUser(String id);

	@Select("select * from mybatis_user")
	public List<User> getUsers();

	@Insert("Insert Into mybatis_user values(#{id}, #{name}, #{phone}, #{address})")
	public void insertUser(User user);

	@Update("update mybatis_user set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
	public void updateUser(User user);

	@Delete("delete from mybatis_user where id=#{id}")
	public void deleteUser(String id);

}

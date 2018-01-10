package com.hjp.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hjp.mybatis.po.User;
import com.hjp.mybatis.po.UserCustom;
import com.hjp.mybatis.po.UserQueryVo;

/**
 * 
 * @author Huang jianping e-mail:hardon123a@163.com
 * @version V-1.0
 */
public interface UserMapper {
	
	//用户信息综合查询
	//public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	//public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	
    //根据用户名列查询用户列表
	public List<User> findUserByName(String name)throws Exception;

	//根据用户名列查询用户列表 param
	public List<User> findUserByNameParam(@Param("userName11") String name)throws Exception;
	
	//插入用户
	public void insertUser(User user)throws Exception;
	
	//插入用户
    public void updateUser(User user)throws Exception;
	
	//删除用户
	public void deleteUser(int id)throws Exception;
	
	//根据多个用户ID查询用户信息
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
}

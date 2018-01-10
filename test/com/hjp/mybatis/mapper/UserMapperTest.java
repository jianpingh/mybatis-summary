package com.hjp.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hjp.mybatis.po.User;
import com.hjp.mybatis.po.UserCustom;
import com.hjp.mybatis.po.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		
		User user = userMapper.findUserById(1);
		
		System.out.println(user);				
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);		
		//调用userMapper的方法		
		User user = userMapper.findUserByIdResultMap(1);
		
		System.out.println(user);		
	}
	@Test
	public void testFindUserByName() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);		
		//调用userMapper的方法		
		List<User> list = userMapper.findUserByName("小明");
		
		//sqlSession.close();		
		System.out.println(list);
			
	}
	
	@Test
	public void testFindUserByNamePara() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);		
		//调用userMapper的方法		
		List<User> list = userMapper.findUserByNameParam("陈小明");
		
		//sqlSession.close();		
		System.out.println(list);
			
	}
	
	@Test
	public void testFindUserList() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);	
		
		UserQueryVo userQueryVo=new UserQueryVo();
		UserCustom userCustom=new  UserCustom();
		//userCustom.setSex("1");
		//userCustom.setUsername("陈小明");
		userQueryVo.setUserCustom(userCustom);
		
		//传入多个id
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		userQueryVo.setIds(ids);
		
		//调用userMapper的方法		
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		
		//sqlSession.close();		
		System.out.println(list);
			
	}

}

package com.hjp.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hjp.mybatis.po.User;

public class MyBatisTest {

	//会话工厂
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void createSqlSessionFactory() throws IOException {
		//配置文件
		String resource="SqlMapConfig.xml";
		
		InputStream inputStream=Resources.getResourceAsStream(resource);
		 
		// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//根据 id查询用户信息
	@Test
	public void testFindUserById(){
		//数据库会话实例
		SqlSession sqlSession=null;
		try{
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 查询单个记录，根据用户id查询用户信息
			
			User user=sqlSession.selectOne("test.findUserById", 1);
			System.out.println(user);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	//根据名称查询用户信息
	@Test
	public void testFindUserByName(){
		//数据库会话实例
		SqlSession sqlSession=null;
		try{
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 查询单个记录，根据用户id查询用户信息
			
			List<User> user=sqlSession.selectList("test.findUserByName", "张");
			System.out.println(user);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	//插入用户
	@Test
	public void testInsert() {
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 添加用户信息
			User user = new User();
			user.setUsername("Mr.Huang");
			user.setAddress("上海浦东");
			  
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String birthday="2008-4-24";  
			java.util.Date date=sdf.parse(birthday);  
			user.setBirthday(date);
			user.setSex("1");
			sqlSession.insert("test.insertUser", user);
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	//更新用户
	@Test
	public void testUpdate() {
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 添加用户信息
			User user = new User();
			user.setId(28);
			user.setUsername("黄建平");
			user.setAddress("河南郑州");
			user.setSex("1");
			sqlSession.update("test.updateUser", user);
			// 提交事务
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

    //删除用户
	@Test
	public void testDelete() {
		// 数据库会话实例
		SqlSession sqlSession = null;
		try {
			// 创建数据库会话实例sqlSession
			sqlSession = sqlSessionFactory.openSession();
			// 删除用户
			sqlSession.delete("test.deleteUserById",28);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

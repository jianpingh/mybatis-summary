package com.hjp.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hjp.mybatis.po.Orders;
import com.hjp.mybatis.po.OrdersCustom;
import com.hjp.mybatis.po.User;

public class OrderMapperTest {

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
	public void testFindOrderCustom() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建orderMapper对象，mybatis自动生成mapper代理对象
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		//调用userMapper的方法
		
		List<OrdersCustom> ordersCustom = orderMapper.findOrderCustom();
		
		System.out.println(ordersCustom);				
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建orderMapper对象，mybatis自动生成mapper代理对象
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		//调用userMapper的方法
		
		List<Orders> ordersCustom = orderMapper.findOrdersUserResultMap();
		
		System.out.println(ordersCustom);				
	}
	
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建orderMapper对象，mybatis自动生成mapper代理对象
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		//调用userMapper的方法
		
		List<Orders> ordersCustom = orderMapper.findOrdersAndOrderDetailResultMap();
		
		System.out.println(ordersCustom);				
	}
	
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建orderMapper对象，mybatis自动生成mapper代理对象
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		//调用userMapper的方法
		
		List<User> orderUser = orderMapper.findUserAndItemsResultMap();
		
		System.out.println(orderUser);				
	}
}

package com.atguigu.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {

	private static DataSource dataSource;//数据源 
	//一个map集合   threadLocal, 线程为键， connection  对象为值 ；  
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	static {
		//记载驱动和创建数据库连接池只需要执行一次，所以放在static中
		
		try {
			Properties prop = new Properties();
			prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		//通过ThreadLocal获取
		Connection connection = threadLocal.get();
		//第一次访问时，Connection还未和Thread绑定
		if(connection == null) {
			//通过数据库连接池获取Connection，并且与Thread绑定，在当前线程中，每次获取的Connection都是同一个
			connection = dataSource.getConnection();
			threadLocal.set(connection);
		}
		
		return connection;
		
	}
	
	/**
	 * 关闭连接
	 * @param connection
	 */
	public static void close() {
		
		Connection connection = threadLocal.get();
		
		if(connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		threadLocal.remove();//将已经关闭的connection移除
		
	}
	
}

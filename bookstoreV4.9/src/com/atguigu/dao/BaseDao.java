package com.atguigu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.utils.JDBCUtils;


public class BaseDao {
	
	private static QueryRunner queryRunner = new QueryRunner();
	
	public Object getSingleData(String sql, Object... args) {
		
		Object object = null;
		
		try {
			object = queryRunner.query(JDBCUtils.getConnection(), sql, new ScalarHandler<>(), args);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return object;
	}

	public int update(String sql, Object... args) {
		
		int i = 0;
		
		try {
			i = queryRunner.update(JDBCUtils.getConnection(), sql, args);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return i;
	}
	
	public<T> T getBean(Class<T> clazz, String sql, Object...args) {
		
		T t = null;
		try {
			t = queryRunner.query(JDBCUtils.getConnection(), sql, new BeanHandler<>(clazz), args);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}
	
	public<T> List<T> getBeanList(Class<T> clazz, String sql, Object...args) {
		
		List<T> list = null;
		
		
		try {
			list = queryRunner.query(JDBCUtils.getConnection(), sql, new BeanListHandler<>(clazz), args);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
	}
	
}

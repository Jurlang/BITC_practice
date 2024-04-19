package org.zerock.w3.w3.todo_0.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

/*
	Class 가 아닌 Enum 을 사용하여 하나의 객체 INSTANCE 를 이용해 싱글톤 패턴 가능.
	HikariCP 라이브러리의 Connection Pool 을 이용해 DB 연결.
 */
public enum ConnectionUtil {
	INSTANCE;

	private HikariDataSource ds;

	ConnectionUtil() {
		HikariConfig config = new HikariConfig();

		config.setDriverClassName("org.mariadb.jdbc.Driver");
		config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
		config.setUsername("webuser");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		ds = new HikariDataSource(config);
	}
	public Connection getConnection() throws Exception{
		return ds.getConnection();
	}
}

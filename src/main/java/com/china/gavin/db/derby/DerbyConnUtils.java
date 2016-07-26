package com.china.gavin.db.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DerbyConnUtils {
	private final static String DB_URL = "jdbc:derby:C:\\Program Files\\Sun\\JavaDB\\bin\\testdb";
	private final static String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

	/**
	 * Create database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:derby:testdb;create=true;user=test;password=test");
		connection.setAutoCommit(false);
		return connection;
	}

	public void netConnectionMethod() {
		Connection conn = null;
		try {
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection("jdbc:derby://localhost:1527/testdb");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM firsttab");
			while (rs.next()) {
				System.out.println("序号 : " + rs.getString(1));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void embeddedConnectionMethod() {
		Connection conn = null;
		try {
			Class.forName(DERBY_DRIVER);
			Properties properties = new Properties();
			// properties.put("create", "true"); // 新建数据库
			// properties.put("user", "APP"); // 用户名
			// properties.put("password", "APP"); // 密码
			// properties.put("retreiveMessagesFromServerOnGetMessage", "true");

			conn = DriverManager.getConnection(DB_URL, properties);

			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM firsttab");

			while (result.next()) {
				System.out.println("序号 : " + result.getInt(1));
			}
			result.close();
			stat.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 内嵌模式数据库操作用完之后需要关闭数据库,这里没有执行数据库名称则全部关闭.
			try {
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}

	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		DerbyConnUtils dc = new DerbyConnUtils();
		dc.embeddedConnectionMethod();
	}
}

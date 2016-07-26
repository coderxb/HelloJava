package com.china.gavin.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String username = "root"; // root为数据库用户名
		String password = "123456"; // 定义密码字符串
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "webdb";
		String url = "jdbc:MySQL://127.0.0.1:3306/";
		Connection conn = null;
		// 定义数据库连接字
		try {
			Class.forName(driver);
			conn = DriverManager
					.getConnection(url + dbName, username, password);
			if (!conn.isClosed()) {
				System.out.println("database connection success");

				Statement st = conn.createStatement();
				String sql = "select * from tb_user";
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					System.out.println(rs.getString("name"));
				}
				rs.close();
			} else {
				System.out.println("database is close");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

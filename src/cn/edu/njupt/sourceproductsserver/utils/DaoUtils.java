package cn.edu.njupt.sourceproductsserver.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 提供数据操作的工具类
 * 
 * @author Administrator
 */
public class DaoUtils {

	private static Connection mConn = null;
	private static Statement mStmt = null;

	/**
	 * 开启与数据库的连接
	 */
	private static void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			mConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/source_products", "root",
					"123");
			mStmt = mConn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭与数据库的连接
	 */
	public static void closeConnection() {
		try {
			if (mStmt != null) {
				mStmt.close();
			}
			if (mConn != null) {
				mConn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行数据库的更新操作
	 * 
	 * @param sql
	 *            更新操作的sql语句
	 */
	public static void update(String sql) {
		try {
			if (mStmt == null || mStmt.isClosed()) {
				openConnection();
			}
			mStmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * 执行数据库的查询操作
	 * 
	 * @param sql
	 *            查询操作的sql语句
	 * @return 查询出来的结果集
	 */
	public static ResultSet query(String sql) {
		try {
			if (mStmt == null || mStmt.isClosed()) {
				openConnection();
			}
			return mStmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

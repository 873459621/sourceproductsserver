package cn.edu.njupt.sourceproductsserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.njupt.sourceproductsserver.domain.User;
import cn.edu.njupt.sourceproductsserver.utils.DaoUtils;

/**
 * 提供对用户表操作的Dao
 * 
 * @author hhw
 */
public class UserDao {

	private static UserDao mDao;

	private UserDao() {
	}

	/**
	 * 获取UserDao的实例
	 * 
	 * @return UserDao的实例
	 */
	public static UserDao getInstance() {
		if (mDao == null) {
			mDao = new UserDao();
		}
		return mDao;
	}

	/**
	 * 根据用户名查找user表，获取User对象
	 * 
	 * @param username
	 *            用户名
	 * @return 找到的User对象，返回null代表未找到
	 */
	public User getUser(String username) {
		String sql = "SELECT * FROM user WHERE username='" + username + "'";
		ResultSet rs = DaoUtils.query(sql);
		User user = null;

		try {
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				DaoUtils.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return user;
	}

	/**
	 * 注册一名用户，向用户表中插入一条数据
	 * 
	 * @param user
	 *            要插入的User对象
	 */
	public void regist(User user) {
		String sql = "INSERT INTO user VALUES(NULL, '" + user.getUsername()
				+ "', '" + user.getPassword() + "', '" + user.getEmail()
				+ "', '" + user.getPhone() + "')";
		DaoUtils.update(sql);
	}

	/**
	 * 根据用户名查找user表，判断用户是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return true代表存在，false代表不存在
	 */
	public boolean exists(String username) {
		String sql = "SELECT username FROM user WHERE username='" + username
				+ "'";
		ResultSet rs = DaoUtils.query(sql);

		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				DaoUtils.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return false;
	}

}

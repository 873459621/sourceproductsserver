package cn.edu.njupt.sourceproductsserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.njupt.sourceproductsserver.domain.Order;
import cn.edu.njupt.sourceproductsserver.utils.DaoUtils;

/**
 * 提供对订单表操作的Dao，单例设计模式
 * 
 * @author hhw
 */
public class OrderDao {

	private static OrderDao mDao;

	private OrderDao() {
	}

	/**
	 * 获取OrderDao的实例
	 * 
	 * @return OrderDao的实例
	 */
	public static OrderDao getInstance() {
		if (mDao == null) {
			mDao = new OrderDao();
		}
		return mDao;
	}

	/**
	 * 向order表中插入一条订单
	 * 
	 * @param order
	 *            要插入的订单
	 * @return 插入的订单的的id，插入失败返回0
	 */
	public int addOrder(Order order) {
		String sql = "INSERT INTO `order` VALUES(NULL, NULL, "
				+ order.getTotal() + ", 1, " + order.getUid() + ")";
		DaoUtils.update(sql);

		sql = "SELECT oid FROM `order` ORDER BY oid DESC";
		ResultSet rs = DaoUtils.query(sql);
		try {
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoUtils.closeConnection(rs);
		}
		return 0;
	}

}

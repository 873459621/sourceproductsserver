package cn.edu.njupt.sourceproductsserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.njupt.sourceproductsserver.domain.Product;
import cn.edu.njupt.sourceproductsserver.utils.DaoUtils;

/**
 * 提供对产品表操作的Dao，单例设计模式
 * 
 * @author hhw
 */
public class ProductDao {

	private static ProductDao mDao;

	private ProductDao() {
	}

	/**
	 * 获取ProductDao的实例
	 * 
	 * @return ProductDao的实例
	 */
	public static ProductDao getInstance() {
		if (mDao == null) {
			mDao = new ProductDao();
		}
		return mDao;
	}

	/**
	 * 根据指定位置索引值获取20个产品的数据
	 * 
	 * @param index
	 *            位置索引值
	 * @return 20个产品的List集合
	 */
	public List<Product> getProductList(String index) {
		String sql = "SELECT * FROM product LIMIT " + index + ", 20";
		return getList(sql);

	}

	/**
	 * 根据指定位置索引值和产品分类ID，获取20个产品的数据
	 * 
	 * @param index
	 *            位置索引值
	 * @param cid
	 *            产品分类ID
	 * @return 20个产品的List集合
	 */
	public List<Product> getProductList(String index, String cid) {
		String sql = "SELECT * FROM product WHERE cid=" + cid + " LIMIT "
				+ index + ", 20";
		return getList(sql);
	}

	/**
	 * 根据sql语句，获取产品的数据集
	 * 
	 * @param sql
	 *            sql语句
	 * @return 产品的数据集
	 */
	private List<Product> getList(String sql) {
		List<Product> productList = new ArrayList<Product>();
		Product product;
		ResultSet rs = DaoUtils.query(sql);
		try {
			while (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2),
						rs.getDouble(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DaoUtils.closeConnection(rs);
		}
		return productList;
	}

	/**
	 * 获取产品总数
	 * 
	 * @return 产品总数
	 */
	public int getTotal() {
		String sql = "SELECT COUNT(*) FROM product";
		return getCount(sql);
	}

	/**
	 * 根据产品分类ID，获取分类产品的总个数
	 * 
	 * @param cid
	 *            产品分类ID
	 * @return 分类产品的总个数
	 */
	public int getTotal(String cid) {
		String sql = "SELECT COUNT(*) FROM product WHERE cid=" + cid;
		return getCount(sql);
	}

	/**
	 * 根据sql语句，获取产品总数
	 * 
	 * @param sql
	 *            sql语句
	 * @return 产品总数
	 */
	private int getCount(String sql) {
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

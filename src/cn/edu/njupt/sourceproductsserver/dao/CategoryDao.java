package cn.edu.njupt.sourceproductsserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.njupt.sourceproductsserver.domain.Category;
import cn.edu.njupt.sourceproductsserver.utils.DaoUtils;

/**
 * 产品分类表的dao，单例设计模式
 * 
 * @author hhw
 */
public class CategoryDao {

	private static CategoryDao mInstance;

	private CategoryDao() {
	}

	/**
	 * 获取CategoryDao的实例
	 * 
	 * @return CategoryDao的实例
	 */
	public static CategoryDao getInstance() {
		if (mInstance == null) {
			mInstance = new CategoryDao();
		}
		return mInstance;
	}

	/**
	 * 获取产品分类的数据
	 * 
	 * @return 产品分类的List集合
	 */
	public List<Category> getCategoryList() {
		List<Category> categoryList = new ArrayList<Category>();
		Category category;

		String sql = "SELECT * FROM category";
		ResultSet rs = DaoUtils.query(sql);

		try {
			while (rs.next()) {
				category = new Category(rs.getInt(1), rs.getString(2));
				categoryList.add(category);
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

		return categoryList;
	}

}

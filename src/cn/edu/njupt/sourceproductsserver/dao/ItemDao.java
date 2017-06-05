package cn.edu.njupt.sourceproductsserver.dao;

import java.util.List;

import cn.edu.njupt.sourceproductsserver.domain.Item;
import cn.edu.njupt.sourceproductsserver.utils.DaoUtils;

/**
 * 提供对订单条目表操作的Dao，单例设计模式
 * 
 * @author hhw
 */
public class ItemDao {

	private static ItemDao mDao;

	private ItemDao() {
	}

	/**
	 * 获取ItemDao的实例
	 * 
	 * @return ItemDao的实例
	 */
	public static ItemDao getInstance() {
		if (mDao == null) {
			mDao = new ItemDao();
		}
		return mDao;
	}

	/**
	 * 向item表中插入多条条目
	 * 
	 * @param oid
	 *            订单ID
	 * @param itemList
	 *            条目的集合
	 */
	public void addItemList(int oid, List<Item> itemList) {
		for (Item item : itemList) {
			String sql = "INSERT INTO item VALUES(NULL, " + item.getNumber()
					+ ", " + item.getSubtotal() + ", " + oid + ", "
					+ item.getPid() + ")";
			DaoUtils.update(sql);
		}
	}

}

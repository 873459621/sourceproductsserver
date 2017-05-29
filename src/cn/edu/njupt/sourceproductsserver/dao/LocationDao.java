package cn.edu.njupt.sourceproductsserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.njupt.sourceproductsserver.domain.Location;
import cn.edu.njupt.sourceproductsserver.utils.DaoUtils;

/**
 * 产品溯源信息表的dao，单例设计模式
 * 
 * @author hhw
 */
public class LocationDao {

	private static LocationDao mInstance;

	private LocationDao() {
	}

	/**
	 * 获取CategoryDao的实例
	 * 
	 * @return CategoryDao的实例
	 */
	public static LocationDao getInstance() {
		if (mInstance == null) {
			mInstance = new LocationDao();
		}
		return mInstance;
	}

	public List<Location> getLocationList(int pid) {
		List<Location> locationList = new ArrayList<Location>();
		Location location;

		String sql = "SELECT * FROM location WHERE pid=" + pid;
		ResultSet rs = DaoUtils.query(sql);

		try {
			while (rs.next()) {
				String ltime = rs.getString(3);
				ltime = ltime.substring(0, ltime.length() - 2);
				location = new Location(ltime, rs.getString(2));
				locationList.add(location);
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

		return locationList;
	}
}

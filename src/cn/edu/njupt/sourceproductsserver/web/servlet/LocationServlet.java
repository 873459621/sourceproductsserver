package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.sourceproductsserver.dao.LocationDao;
import cn.edu.njupt.sourceproductsserver.domain.Location;
import cn.edu.njupt.sourceproductsserver.utils.JSONUtils;
import cn.edu.njupt.sourceproductsserver.utils.ResponseUtils;

/**
 * 传输产品溯源信息数据的Servlet
 * 
 * @author hhw
 */
public class LocationServlet extends HttpServlet {

	/**
	 * 自动生成的序列号
	 */
	private static final long serialVersionUID = -9039846012795627064L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		LocationDao locationDao = LocationDao.getInstance();
		List<Location> locationList = locationDao.getLocationList(pid);
		ResponseUtils.write(response,
				JSONUtils.toJSON(locationList, "locationList"));
	}

}

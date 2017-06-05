package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.sourceproductsserver.dao.ItemDao;
import cn.edu.njupt.sourceproductsserver.dao.OrderDao;
import cn.edu.njupt.sourceproductsserver.domain.Order;
import cn.edu.njupt.sourceproductsserver.utils.JSONUtils;
import cn.edu.njupt.sourceproductsserver.utils.ResponseUtils;

/**
 * 控制订单信息传输逻辑的Servlet
 * 
 * @author hhw
 */
public class OrderServlet extends HttpServlet {

	/**
	 * 自动生成的序列号
	 */
	private static final long serialVersionUID = 4094825738845756054L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String json = request.getParameter("json");
		Order order = JSONUtils.toOrder(json);

		OrderDao orderDao = OrderDao.getInstance();
		int oid = orderDao.addOrder(order);

		ItemDao itemDao = ItemDao.getInstance();
		itemDao.addItemList(oid, order.getItemList());

		ResponseUtils.write(response, "success");
	}

}

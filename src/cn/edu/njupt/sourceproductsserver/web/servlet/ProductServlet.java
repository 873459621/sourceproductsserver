package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.sourceproductsserver.dao.ProductDao;
import cn.edu.njupt.sourceproductsserver.domain.Product;
import cn.edu.njupt.sourceproductsserver.utils.JSONUtils;
import cn.edu.njupt.sourceproductsserver.utils.ResponseUtils;

/**
 * 控制用户登录逻辑的Servlet
 * 
 * @author hhw
 */
public class ProductServlet extends HttpServlet {

	/**
	 * 自动生成的序列号
	 */
	private static final long serialVersionUID = -4375826309368323745L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");

		ProductDao productDao = ProductDao.getInstance();

		if ("productList".equals(method)) {
			String index = request.getParameter("index");
			List<Product> productList = productDao.getProductList(index);
			ResponseUtils.write(response, JSONUtils.toJSON(productList));

		} else if ("total".equals(method)) {

		}
	}

}

package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.njupt.sourceproductsserver.dao.ProductDao;
import cn.edu.njupt.sourceproductsserver.domain.Product;
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
		String cid = request.getParameter("cid");

		if ("productList".equals(method)) {
			String index = request.getParameter("index");
			List<Product> productList;
			if (cid == null) {
				productList = productDao.getProductList(index);
			} else {
				productList = productDao.getProductList(index, cid);
			}
			ResponseUtils.write(response, JSONArray.fromObject(productList)
					.toString());

		} else if ("total".equals(method)) {
			if (cid == null) {
				ResponseUtils.write(response, productDao.getTotal() + "");
			} else {
				ResponseUtils.write(response, productDao.getTotal(cid) + "");
			}
		}
	}
}

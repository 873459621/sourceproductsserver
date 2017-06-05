package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.edu.njupt.sourceproductsserver.dao.CategoryDao;
import cn.edu.njupt.sourceproductsserver.domain.Category;
import cn.edu.njupt.sourceproductsserver.utils.ResponseUtils;

/**
 * 传送产品分类数据的Servlet
 * 
 * @author hhw
 */
public class CategoryServlet extends HttpServlet {

	/**
	 * 自动生成的序列号
	 */
	private static final long serialVersionUID = -1308887582400431864L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDao categoryDao = CategoryDao.getInstance();
		List<Category> categoryList = categoryDao.getCategoryList();
		ResponseUtils.write(response, JSONArray.fromObject(categoryList)
				.toString());
	}

}

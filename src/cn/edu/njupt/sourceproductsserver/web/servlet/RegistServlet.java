package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.sourceproductsserver.dao.UserDao;
import cn.edu.njupt.sourceproductsserver.domain.User;
import cn.edu.njupt.sourceproductsserver.utils.ResponseUtils;

/**
 * 控制用户注册逻辑的Servlet
 * 
 * @author hhw
 */
public class RegistServlet extends HttpServlet {

	/**
	 * 自动生成的序列号
	 */
	private static final long serialVersionUID = -93640757385026107L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		UserDao userDao = UserDao.getInstance();

		if (!userDao.exists(username)) {
			ResponseUtils.write(response, "user");

		} else {
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");

			userDao.regist(new User(username, password, email, phone));

			ResponseUtils.write(response, "success");
		}
	}

}

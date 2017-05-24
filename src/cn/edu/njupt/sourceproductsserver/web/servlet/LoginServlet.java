package cn.edu.njupt.sourceproductsserver.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njupt.sourceproductsserver.dao.UserDao;
import cn.edu.njupt.sourceproductsserver.domain.User;

/**
 * 控制用户登录逻辑的Servlet
 * 
 * @author hhw
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 自动生成的序列号
	 */
	private static final long serialVersionUID = -3199292737958373196L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao userDao = UserDao.getInstance();
		User user = userDao.getUser(username);

		if (user == null) {
			response.getOutputStream().write("user".getBytes("utf-8"));
		} else {
			if (password.equals(user.getPassword())) {
				response.getOutputStream().write(
						user.toString().getBytes("utf-8"));
			} else {
				response.getOutputStream().write("pwd".getBytes("utf-8"));
			}
		}
	}

}

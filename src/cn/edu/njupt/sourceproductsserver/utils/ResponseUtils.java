package cn.edu.njupt.sourceproductsserver.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

/**
 * 网络连接响应的工具类
 * 
 * @author hhw
 */
public class ResponseUtils {

	/**
	 * 使用utf-8编码，传输响应数据
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param data
	 *            响应数据
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static void write(HttpServletResponse response, String data)
			throws UnsupportedEncodingException, IOException {
		response.getOutputStream().write(data.getBytes("utf-8"));
	}

}

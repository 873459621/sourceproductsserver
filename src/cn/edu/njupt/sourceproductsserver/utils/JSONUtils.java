package cn.edu.njupt.sourceproductsserver.utils;

import java.util.List;

/**
 * 提供JSON字符串转换的工具类
 * 
 * @author hhw
 */
public class JSONUtils {

	/**
	 * 把列表转换为JSON字符串
	 * 
	 * @param list
	 *            列表
	 * @param name
	 *            列表名称
	 * @return JSON字符串
	 */
	public static String toJSON(List<?> list, String name) {
		StringBuilder sb = new StringBuilder();

		sb.append("{\"" + name + "\":[");
		sb.append(list.get(0).toString());

		for (int i = 1; i < list.size(); i++) {
			sb.append(", ");
			sb.append(list.get(i).toString());
		}

		sb.append("]}");

		return sb.toString();
	}

}

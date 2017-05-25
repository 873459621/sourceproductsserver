package cn.edu.njupt.sourceproductsserver.utils;

import java.util.List;

import cn.edu.njupt.sourceproductsserver.domain.Product;

/**
 * 提供JSON字符串转换的工具类
 * 
 * @author hhw
 */
public class JSONUtils {

	/**
	 * 把产品数据列表转换为JSON字符串
	 * 
	 * @param productList
	 *            产品数据列表
	 * @return JSON字符串
	 */
	public static String toJSON(List<Product> productList) {
		StringBuilder sb = new StringBuilder();

		sb.append("{productList:[");
		sb.append(productList.get(0).toJSON());

		for (int i = 1; i < productList.size(); i++) {
			sb.append(", ");
			sb.append(productList.get(i).toJSON());
		}

		sb.append("]}");

		return sb.toString();
	}

}

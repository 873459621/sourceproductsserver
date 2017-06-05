package cn.edu.njupt.sourceproductsserver.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import cn.edu.njupt.sourceproductsserver.domain.Item;
import cn.edu.njupt.sourceproductsserver.domain.Order;

/**
 * 提供JSON字符串转换的工具类
 * 
 * @author hhw
 */
public class JSONUtils {


	/**
	 * 把JSON字符串转换为Order对象
	 * 
	 * @param json
	 *            JSON字符串
	 * @return Order对象
	 */
	public static Order toOrder(String json) {
		Map<String, Class<Item>> classMap = new HashMap<String, Class<Item>>();
		classMap.put("itemList", Item.class);
		return (Order) JSONObject.toBean(JSONObject.fromObject(json),
				Order.class, classMap);
	}

}

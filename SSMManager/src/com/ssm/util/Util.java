package com.ssm.util;

import java.util.Date;
import java.util.List;
import com.ssm.util.GridManagerList;
import com.ssm.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 通用方法
 * 
 * @author 
 * 
 * @param <T>
 *            对象
 */
public class Util<T> {
	/**
	 * 分页
	 * 
	 * @param rateds
	 *            分页数据集合
	 * @param row
	 *            数据条数
	 * @return json数据
	 */
	public String SplitPage(List<T> datas, int row) {
		GridManagerList<T> gridManagerList = new GridManagerList<T>();

		gridManagerList.setStatus("success");

		gridManagerList.setData(datas);

		gridManagerList.setTotals(row);

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());

		JSONArray jsonArray = JSONArray.fromObject(gridManagerList, jsonConfig);

		String data = jsonArray.toString();

		data = data.substring(1, data.length() - 1);
		return data;
	}

	

} 

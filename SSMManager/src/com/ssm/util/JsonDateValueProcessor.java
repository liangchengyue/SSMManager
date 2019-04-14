package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;



import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 处理json中日期格式
 * 
 * @author 
 * 
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
	// 定义转换日期类型的输出格式
	private String format = "yyyy-MM-dd HH:mm:ss";

	public JsonDateValueProcessor() {

	}

	public JsonDateValueProcessor(String format) {
		this.format = format;
	}

	private Object process(Object arg0) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(arg0);
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		// TODO Auto-generated method stub
		return process(value);
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		if (value instanceof java.util.Date) {
			String str = new SimpleDateFormat(format).format((Date) value);
			return str;
		}
		if (null != value) {
			return value.toString();
		}
		return "";
	}

}
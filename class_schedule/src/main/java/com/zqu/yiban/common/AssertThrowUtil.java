package com.zqu.yiban.common;

import com.zqu.yiban.exception.UserException;

/**
 *	断言工具类
 */
public class AssertThrowUtil {
	
	/**
	 * 对象为空时抛出用户异常
	 * @param object	对象
	 * @param msg		异常信息
	 * @return
	 */
	public static Object objectIfBlank(Object object, String msg) {
		if(object == null) {
			throw new UserException(msg);
		}
		return object;
	}
	
	/**
	 * 字符串为空时抛出用户异常
	 * @param str	字符串
	 * @param msg	异常信息
	 * @return
	 */
	public static String stringIfBlank(String str, String msg) {
		if("".equals(str) || str.trim().length() <= 0) {
			throw new UserException(msg);
		}
		return str;
	}
}

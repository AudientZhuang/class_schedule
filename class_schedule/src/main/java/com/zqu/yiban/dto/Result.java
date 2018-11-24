package com.zqu.yiban.dto;

import java.util.List;

/**
 * 结果对象
 * @param <T>	返回的数据类型
 */
public class Result <T>{
	public int code;
	public String msg;
	public List<T> datas;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public Result(int code, String msg, List<T> datas) {
		super();
		this.code = code;
		this.msg = msg;
		this.datas = datas;
	}
	public Result() {
		super();
	}
	
	
	
}
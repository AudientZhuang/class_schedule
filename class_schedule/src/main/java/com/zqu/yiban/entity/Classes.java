package com.zqu.yiban.entity;
/**
 * 班级信息对象
 */
public class Classes {
	private int id;		//主键id
	private String name;	//班级名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Classes(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Classes() {
		super();
	}
	
	
}

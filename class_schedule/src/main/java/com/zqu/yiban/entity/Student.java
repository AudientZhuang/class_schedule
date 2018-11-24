package com.zqu.yiban.entity;
/**
 * 学生信息对象
 */
public class Student {
	private int id;		//主键id
	private String number;	//学号
	private String name;	//姓名
	private int classesId;	//所在班级的id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	public Student(int id, String number, String name, int classesId) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.classesId = classesId;
	}
	public Student() {
		super();
	}
	
	
}

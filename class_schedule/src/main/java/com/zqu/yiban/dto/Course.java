package com.zqu.yiban.dto;

/**
 *	普通课程对象
 */
public class Course {
	private int id;	//主键id
	private String content;	//课程详细信息
	private int x;	//坐标x
	private int y;	//坐标y
	private int len;	//课程节数
	private String weeks;	//上课周数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public String getWeeks() {
		return weeks;
	}
	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}
	public Course(int id, String content, int x, int y, int len, String weeks) {
		super();
		this.id = id;
		this.content = content;
		this.x = x;
		this.y = y;
		this.len = len;
		this.weeks = weeks;
	}
	public Course() {
		super();
	}
	
}

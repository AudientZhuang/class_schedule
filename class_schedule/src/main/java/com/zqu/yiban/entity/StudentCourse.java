package com.zqu.yiban.entity;
/**
 *	学生课程信息对象
 */
public class StudentCourse {
	private int id;	//主键id
	private int studentId;	//学生id
	private String content;	//课程详细信息
	private int x;	//坐标x
	private int y;	//坐标y
	private int len;	//课程节数
	private String weeks;	//上课周数
	private int classesCourseId;	//被覆盖的班级课程的id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public int getClassesCourseId() {
		return classesCourseId;
	}
	public void setClassesCourseId(int classesCourseId) {
		this.classesCourseId = classesCourseId;
	}
	public StudentCourse(int id, int studentId, String content, int x, int y, int len, String weeks,
			int classesCourseId) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.content = content;
		this.x = x;
		this.y = y;
		this.len = len;
		this.weeks = weeks;
		this.classesCourseId = classesCourseId;
	}
	public StudentCourse() {
		super();
	}
	
	
}

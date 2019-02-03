package com.zqu.yiban.service;

import java.util.List;

import com.zqu.yiban.entity.StudentCourse;

/**
 *	学生课程信息服务接口
 */
public interface StudentCourseService {
	/**
	 * 通过学生id获取学生课程
	 * @param studentId	学生id
	 * @return			学生课程集合
	 * @throws Exception
	 */
	public List<StudentCourse> listStudentCourse(int studentId) throws Exception;

	public Integer delStudentCourse(Integer studentId);

	public Integer addStudentCourse(StudentCourse studentCourse);
}

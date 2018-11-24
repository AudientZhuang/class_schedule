package com.zqu.yiban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqu.yiban.entity.StudentCourse;
import com.zqu.yiban.mapper.StudentCourseMapper;
import com.zqu.yiban.service.StudentCourseService;

/**
 *	学生课程信息服务实现
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService{

	@Autowired
	private StudentCourseMapper studentCourseMapper;
	
	public StudentCourseMapper getStudentCourseMapper() {
		return studentCourseMapper;
	}


	public void setStudentCourseMapper(StudentCourseMapper studentCourseMapper) {
		this.studentCourseMapper = studentCourseMapper;
	}


	@Override
	public List<StudentCourse> listStudentCourse(int studentId) throws Exception {
		return studentCourseMapper.list("student_id", studentId);
	}

}

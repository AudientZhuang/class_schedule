package com.zqu.yiban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqu.yiban.entity.ClassesCourse;
import com.zqu.yiban.mapper.ClassesCourseMapper;
import com.zqu.yiban.service.ClassesCourseService;

/**
 *	班级课程信息服务实现
 */
@Service
public class ClassesCourseServiceImpl implements ClassesCourseService{
	@Autowired
	private ClassesCourseMapper classesCourseMapper;
	
	public ClassesCourseMapper getClassesCourseMapper() {
		return classesCourseMapper;
	}

	public void setClassesCourseMapper(ClassesCourseMapper classesCourseMapper) {
		this.classesCourseMapper = classesCourseMapper;
	}

	@Override
	public List<ClassesCourse> listClassesCourse(int classesId) throws Exception {
		return classesCourseMapper.list("classes_id", classesId);
	}

}

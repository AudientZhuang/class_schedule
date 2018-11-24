package com.zqu.yiban.service;

import java.util.List;

import com.zqu.yiban.entity.ClassesCourse;

/**
 *	班级课程信息服务接口
 */
public interface ClassesCourseService {
	/**
	 * 通过班级id获取班级课程
	 * @param classesId	班级id
	 * @return			班级课程集合
	 * @throws Exception
	 */
	public List<ClassesCourse> listClassesCourse(int classesId) throws Exception;
}

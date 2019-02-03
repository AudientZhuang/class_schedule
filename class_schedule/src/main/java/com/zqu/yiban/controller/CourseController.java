package com.zqu.yiban.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zqu.yiban.common.AssertThrowUtil;
import com.zqu.yiban.dto.Course;
import com.zqu.yiban.dto.Result;
import com.zqu.yiban.entity.ClassesCourse;
import com.zqu.yiban.entity.Student;
import com.zqu.yiban.entity.StudentCourse;
import com.zqu.yiban.exception.UserException;
import com.zqu.yiban.service.ClassesCourseService;
import com.zqu.yiban.service.StudentCourseService;
import com.zqu.yiban.service.StudentService;

/**
 *	课程控制器
 */
@Controller
public class CourseController {
	@Autowired
	private StudentService studentSerivce;
	@Autowired
	private ClassesCourseService classesCourseService;
	@Autowired
	private StudentCourseService studentCourseService;
	
	//getter和setter方法
	public StudentService getStudentSerivce() {
		return studentSerivce;
	}
	public void setStudentSerivce(StudentService studentSerivce) {
		this.studentSerivce = studentSerivce;
	}
	public ClassesCourseService getClassesCourseService() {
		return classesCourseService;
	}
	public void setClassesCourseService(ClassesCourseService classesCourseService) {
		this.classesCourseService = classesCourseService;
	}
	public StudentCourseService getStudentCourseService() {
		return studentCourseService;
	}
	public void setStudentCourseService(StudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}
	
	/**
	 * 获取当前学生的课程
	 * @param json
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listCourse.do")
	public String listCourse(HttpServletRequest request){
		//结果对象
		Result<Course> result = new Result<>();
		try {
			//获取当前用户id和班级id
			/*HttpSession session = request.getSession();
			AssertThrowUtil.objectIfBlank(session, "用户信息已过期,请重新登录");
			Student student = (Student) session.getAttribute("user");
			AssertThrowUtil.objectIfBlank(student, "用户信息已过期,请重新登录");
			int studentId = student.getId();
			int classesId = student.getClassesId();
			if(studentId <= 0) {
				throw new UserException("用户 id不合法");
			}
			if(classesId <= 0) {
				throw new UserException("班级id不合法");
			}*/
			int studentId = 1;
			int classesId = 1;
			//要传到前端的课程集合
			List<Course> datas = new ArrayList<>();
			//获取班级课程
			List<ClassesCourse> classesCourseList = classesCourseService.listClassesCourse(classesId);
			if(classesCourseList.size() <= 0) {
				throw new UserException("班级课程为空");
			}
			//获取学生课程
			List<StudentCourse> studentCourseList = studentCourseService.listStudentCourse(studentId);
			if(studentCourseList.size() > 0) {	//学生课程不为空
				List<Integer> coverClassesCourseIdList = new ArrayList<>();	//定义一个集合用于存储被学生课程覆盖的班级课程的id
				for (StudentCourse studentCourse : studentCourseList) {	//遍历学生课程集合
					//将学生课程对象转换为普通课程对象
					Course course = new Course();
					course.setId(studentCourse.getId());
					course.setContent(studentCourse.getContent());
					course.setX(studentCourse.getX());
					course.setY(studentCourse.getY());
					course.setLen(studentCourse.getLen());
					course.setWeeks(studentCourse.getWeeks());
					datas.add(course);	//将课程对象添加到datas集合中
					coverClassesCourseIdList.add(studentCourse.getClassesCourseId());	//存储被学生课程覆盖的班级课程的id
				}
				for (ClassesCourse classesCourse : classesCourseList) {	//遍历班级课程集合
					if(coverClassesCourseIdList.indexOf(classesCourse.getId()) != -1) {	//该课程已被覆盖
						continue;
					}
					//将班级课程对象转换为普通课程对象
					Course course = new Course();
					course.setId(classesCourse.getId());
					course.setContent(classesCourse.getContent());
					course.setX(classesCourse.getX());
					course.setY(classesCourse.getY());
					course.setLen(classesCourse.getLen());
					course.setWeeks(classesCourse.getWeeks());
					datas.add(course);
				}
			}else {	//学生课程为空
				for (ClassesCourse classesCourse : classesCourseList) {	//遍历班级课程集合
					//将班级课程对象转换为普通课程对象
					Course course = new Course();
					course.setId(classesCourse.getId());
					course.setContent(classesCourse.getContent());
					course.setX(classesCourse.getX());
					course.setY(classesCourse.getY());
					course.setLen(classesCourse.getLen());
					course.setWeeks(classesCourse.getWeeks());
					datas.add(course);
				}
			}
			//构建返回对象
			result.setCode(0);
			result.setDatas(datas);
			result.setMsg("成功返回");
			return JSONObject.toJSONString(result);
		}catch(UserException e) {	//用户异常
			//构建返回对象
			result.setCode(-1);
			result.setMsg(e.getMessage());
			return JSONObject.toJSONString(result);
		}catch(Exception e) {		//系统异常
			e.printStackTrace();
			//构建返回对象
			result.setCode(-1);
			result.setMsg("服务器繁忙");
			return JSONObject.toJSONString(result);
		}
	}
	
	@RequestMapping("/addCourse.do")
	public String addCourse(@RequestParam("courseData") String courseData) {
		
		List<StudentCourse> studentCourses= JSON.parseArray(courseData, StudentCourse.class);
		
		if(studentCourses != null && studentCourses.size() > 0) {
			//从studentCourses中获取当前用户的ID
			Integer studentId = studentCourses.get(0).getStudentId();
			//把学生添加的课程全部删除了
			if(studentCourseService.delStudentCourse(studentId) == null)
				return "redirect:/listCourse.do";
			
			//增加学生课程
			for(StudentCourse studentCourse: studentCourses) {
				//添加学生课程到数据库
				Integer num = studentCourseService.addStudentCourse(studentCourse);
			}
		}
		return "redirect:/listCourse.do";
	}
}





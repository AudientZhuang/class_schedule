package com.zqu.yiban.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zqu.yiban.common.AbstractDao;
import com.zqu.yiban.entity.Student;
/**
 *	学生信息DAO
 */
@Mapper
public interface StudentMapper extends AbstractDao<Student>{

}

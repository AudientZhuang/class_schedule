package com.zqu.yiban.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 *	dao抽象类
 * @param <T>
 */
public interface AbstractDao<T> {
	/**
	 * 添加记录
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int insert(T t) throws Exception;
	/**
	 * 通过唯一字段删除记录
	 * @param ukfield	
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public int delete(@Param("key")String ukfield, @Param("value")Object value) throws Exception;
	/**
	 * 修改记录
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int update(T t) throws Exception;
	/**
	 * 通过唯一字段获取单个对象
	 * @param ukfield
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public T get(@Param("key")String ukfield, @Param("value")Object value) throws Exception;
	/**
	 * 通过指定值获取对象集合
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public List<T> list(@Param("key")String key, @Param("value")Object value) throws Exception;
	
	
}

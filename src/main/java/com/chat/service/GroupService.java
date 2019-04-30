package com.chat.service;
import java.util.List;
import com.chat.pojo.TbGroup;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GroupService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbGroup> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbGroup group);
	
	
	/**
	 * 修改
	 */
	public void update(TbGroup group);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbGroup findOne(Integer id);
	
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbGroup group, int pageNum,int pageSize);
	
}

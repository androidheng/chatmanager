package com.chat.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.chat.mapper.TbGroupMapper;
import com.chat.pojo.TbGroup;
import com.chat.pojo.TbGroupExample;
import com.chat.pojo.TbGroupExample.Criteria;
import com.chat.service.GroupService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private TbGroupMapper groupMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbGroup> findAll() {
		return groupMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbGroup> page=   (Page<TbGroup>) groupMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbGroup group) {
		groupMapper.insert(group);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbGroup group){
		groupMapper.updateByPrimaryKeySelective(group);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbGroup findOne(Integer id){
		return groupMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		groupMapper.deleteByPrimaryKey(id);
			
	}
	
	
		@Override
	public PageResult findPage(TbGroup group, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbGroupExample example=new TbGroupExample();
		Criteria criteria = example.createCriteria();
		
		if(group!=null){			
			if(!StringUtils.isEmpty(group.getGroupname())) {
				criteria.andGroupnameLike("%"+group.getGroupname()+"%");
			}	
		}
		
		Page<TbGroup> page= (Page<TbGroup>)groupMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}

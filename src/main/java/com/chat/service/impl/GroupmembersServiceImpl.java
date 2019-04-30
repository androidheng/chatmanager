package com.chat.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.chat.mapper.TbGroupmembersMapper;
import com.chat.pojo.TbGroupmembers;
import com.chat.pojo.TbGroupmembersExample;
import com.chat.pojo.TbGroupmembersExample.Criteria;
import com.chat.service.GroupmembersService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GroupmembersServiceImpl implements GroupmembersService {

	@Autowired
	private TbGroupmembersMapper groupmembersMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbGroupmembers> findAll() {
		return groupmembersMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbGroupmembers> page=   (Page<TbGroupmembers>) groupmembersMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbGroupmembers groupmembers) {
		groupmembersMapper.insert(groupmembers);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbGroupmembers groupmembers){
		groupmembersMapper.updateByPrimaryKeySelective(groupmembers);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbGroupmembers findOne(Integer id){
		return groupmembersMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		
		groupmembersMapper.deleteByPrimaryKey(id);
			
	}
	
	
		@Override
	public PageResult findPage(TbGroupmembers groupmembers, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbGroupmembersExample example=new TbGroupmembersExample();
		Criteria criteria = example.createCriteria();
		
		if(groupmembers!=null){			
				
		}
		
		Page<TbGroupmembers> page= (Page<TbGroupmembers>)groupmembersMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public PageResult findAllByGroupId(String groupid) {
			TbGroupmembersExample example=new TbGroupmembersExample();
			Criteria criteria = example.createCriteria();
			criteria.andGroupidEqualTo(groupid);
			
			 List<TbGroupmembers> list = groupmembersMapper.selectByExample(example);
			return new PageResult(0,"",Long.parseLong(list.size()+""), list);
		}
	
}

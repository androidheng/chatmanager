package com.chat.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.chat.pojo.TbUser;
import com.chat.service.IMUserAPI;
import com.chat.service.UserService;
import com.chat.test.UserTest;
import com.chat.utils.DateUtils;
import com.chat.vo.RegisterBean;
import com.google.gson.Gson;

import entity.PageResult;
import entity.Result;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
/**
 * controller
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private IMUserAPI imUserAPI;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbUser> findAll(){			
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return userService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/register",produces = "application/json;charset=UTF-8")
	public Result add(String username,String password){
		try {
			TbUser haveUser=userService.findByUserName(username);
			if(haveUser!=null) {
				return new Result(false, "已经存在此用户,请重新注册");
			}else {
				TbUser tbUser=new TbUser();
				tbUser.setUsername(username);
				tbUser.setPassword(password);
				RegisterUsers users = new RegisterUsers();
				User user = new User();
				BeanUtils.copyProperties(tbUser, user);
				users.add(user);
				 String result = (String) imUserAPI.createNewIMUserSingle(users);
				 logger.info(result);
				 Gson gson=new Gson();
				 RegisterBean registerBean = gson.fromJson(result, RegisterBean.class);
				 if(registerBean!=null) {
					 tbUser.setRegistertime(DateUtils.getCurrent());
					 tbUser.setUuid(registerBean.getEntities().get(0).getUuid());
					 userService.add(tbUser);
				 }
			}
			
			// 
			//userService.add(tbUser);
			return new Result(true, "注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "注册失败！");
		}
	}
	@ResponseBody
	@RequestMapping(value="/delete",produces = "application/json;charset=UTF-8")
	public Result delete(@RequestBody TbUser tbUser){
		try {
				TbUser haveUser=userService.findOne(tbUser.getId());
				String result = (String) imUserAPI.deleteIMUserByUserName(haveUser.getUsername());
				logger.info(result);
				Gson gson=new Gson();
				RegisterBean registerBean = gson.fromJson(result, RegisterBean.class);
				if(registerBean!=null) {
					
					userService.delete(tbUser.getId());
				}
			
			// 
			//userService.add(tbUser);
			return new Result(true, "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败！");
		}
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbUser user){
		try {
			userService.update(user);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbUser findOne(Integer id){
		return userService.findOne(id);		
	}
	
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbUser user=null;
		if(!StringUtils.isEmpty(key)) {
			user=new TbUser();
			user.setUsername(key);
		}
		return userService.findPage(user, page, limit);		
	}
	
}

package com.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.pojo.TbGroup;
import com.chat.pojo.TbGroupmembers;
import com.chat.pojo.TbUser;
import com.chat.service.ChatGroupAPI;
import com.chat.service.GroupService;
import com.chat.service.GroupmembersService;
import com.chat.vo.ChatGroupBean;
import com.google.gson.Gson;

import entity.PageResult;
import entity.Result;
import io.swagger.client.model.Group;
import io.swagger.client.model.UserName;
import io.swagger.client.model.UserNames;

@Controller
@RequestMapping("/chatGroup")
public class ChatGroupController {
	 private static final Logger logger = LoggerFactory.getLogger(ChatGroupController.class);
	@Autowired
	ChatGroupAPI chatGroupAPI;
	@Autowired
	GroupService groupService;
	@Autowired
	GroupmembersService groupmembersService;
	
		//新建群
		@RequestMapping("/create")
		@ResponseBody
	   public Result createGroup(@RequestBody TbGroup tbGroup) {
	        Group group = new Group();
	        group.groupname(tbGroup.getGroupname()).desc(tbGroup.getDesc())._public(true).maxusers(200).approval(false).owner(tbGroup.getOwner());
	        String result = (String) chatGroupAPI.createChatGroup(group);
	     
	        Gson gson=new Gson();
	        ChatGroupBean chatGroupBean = gson.fromJson(result, ChatGroupBean.class);
	        if(chatGroupBean!=null) {
	        	String groupid=chatGroupBean.getData().getGroupid();
	        	tbGroup.setGroupid(groupid);
	        	groupService.add(tbGroup);
	        	if(tbGroup.getMembers().size()>0) {
	        		UserNames userNames = new UserNames();
	  		        UserName userList = new UserName();
	  		        for(String mems:tbGroup.getMembers()) {
	  		        	 userList.add(mems);
	  		        }
	  		        userNames.usernames(userList);
	  		        String result2= (String) chatGroupAPI.addBatchUsersToChatGroup(groupid, userNames);
	  		      ChatGroupBean chatGroupBean2=gson.fromJson(result2, ChatGroupBean.class);
	  		        if(chatGroupBean2!=null) {
	  		        	for(String mems:tbGroup.getMembers()) {
	  		        		TbGroupmembers groupmembers=new TbGroupmembers();
	  		        		groupmembers.setGroupid(groupid);
	  		        		groupmembers.setGroupname(tbGroup.getGroupname());
	  		        		groupmembers.setUsername(mems);
							groupmembersService.add(groupmembers);
		  		        }
	  		        }
	        	}
	        	return new Result(true, "创建成功!");
	        }
	        return new Result(false, "创建失败!");
	    }
			//添加用户到群组里面
		  public void addUsers() {
		        String groupId = "11361107116036";
		        UserNames userNames = new UserNames();
		        UserName userList = new UserName();
		        userList.add("qwqwqw");
		        userList.add("qwqwqww");
		        userNames.usernames(userList);
		        Object result = chatGroupAPI.addBatchUsersToChatGroup(groupId, userNames);
		       // logger.info(result.toString());
		    }
		 
		   //T人
		  @RequestMapping("/remove")
		  @ResponseBody
		   public Result removeUsersFromGroup(@RequestBody TbGroupmembers tbGroupmembers) {
			   tbGroupmembers=groupmembersService.findOne(tbGroupmembers.getId());
			   String result = (String) chatGroupAPI.removeSingleUserFromChatGroup(tbGroupmembers.getGroupid(), tbGroupmembers.getUsername());
			   Gson gson=new Gson();
		        ChatGroupBean chatGroupBean = gson.fromJson(result, ChatGroupBean.class);
		        logger.info((chatGroupBean==null)+"");
		        if(chatGroupBean!=null) {
		        	groupmembersService.delete(tbGroupmembers.getId());
		        	return new Result(true, "移除成功!");
		        }
		        return new Result(false, "移除失败!");
		  }
		   //解散群
		  @RequestMapping("/delete")
		  @ResponseBody
		   public Result deleteChatGroup(@RequestBody TbGroup group) {
			  TbGroup tbGroup = groupService.findOne(group.getId());
			  
			   String result = (String) chatGroupAPI.deleteChatGroup(tbGroup.getGroupid());
			   Gson gson=new Gson();
			   ChatGroupBean chatGroupBean = gson.fromJson(result, ChatGroupBean.class);
		        logger.info((chatGroupBean==null)+"");
		        if(chatGroupBean!=null) {
		        	groupService.delete(group.getId());
		        	return new Result(true, "解散成功!");
		        }
		        return new Result(true, "解散失败!");
		   }
		  
			@ResponseBody
			@RequestMapping("/search")
			public PageResult search(String key , int page, int limit  ){
				TbGroup group=null;
				if(!StringUtils.isEmpty(key)) {
					group=new TbGroup();
					group.setGroupname(key);
				}
				return groupService.findPage(group, page, limit);		
			}
			
			 //获取群组里面的所有成员
			  @RequestMapping("/detail")
			  @ResponseBody
			   public PageResult getUsersFromGroup(int id, int page, int limit ) {
				   TbGroup tbGroup = groupService.findOne(id);
				   
			        return groupmembersService.findAllByGroupId(tbGroup.getGroupid());
			    }
}

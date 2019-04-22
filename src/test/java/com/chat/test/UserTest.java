package com.chat.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chat.service.impl.EasemobIMUsers;
import com.google.gson.Gson;

import io.swagger.client.model.NewPassword;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;

/**
 * Created by easemob on 2017/3/21.
 */
public class UserTest {

    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);
    private EasemobIMUsers easemobIMUsers = new EasemobIMUsers();

    @Test
    public void createUser() {
        RegisterUsers users = new RegisterUsers();
        User user = new User().username("lisi").password("123456");
        users.add(user);
        String result = (String) easemobIMUsers.createNewIMUserSingle(users);
        System.out.println(result);
        Gson gson=new Gson();
        String str=gson.toJson(result);
        //System.out.println(str);
        Assert.assertNotNull(result);
    }
    @Test
    public void deleteUser() {
    	String result = (String) easemobIMUsers.deleteIMUserByUserName("zhangsan");
    	System.out.println(result);
    	Gson gson=new Gson();
    	String str=gson.toJson(result);
    	//System.out.println(str);
    	Assert.assertNotNull(result);
    }

    @Test
    public void getUserByName() {
        String userName = "stringa";
        Object result = easemobIMUsers.getIMUserByUserName(userName);
        logger.info(result.toString());
    }

    @Test
    public void gerUsers() {
        Object result = easemobIMUsers.getIMUsersBatch(5L, null);
        logger.info(result.toString());
    }

    @Test
    public void changePassword() {
        String userName = "stringa";
        NewPassword psd = new NewPassword().newpassword("123");
        Object result = easemobIMUsers.modifyIMUserPasswordWithAdminToken(userName, psd);
        logger.info(result.toString());
    }

    @Test
    public void getFriend() {
        String userName = "stringa";
        Object result = easemobIMUsers.getFriends(userName);
        logger.info(result.toString());
    }
}

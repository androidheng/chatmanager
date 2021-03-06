package com.chat.utils;

import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.AuthenticationApi;
import io.swagger.client.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by easemob on 2017/3/14.
 */
public class TokenUtil {
    public static String GRANT_TYPE;
    private static String CLIENT_ID;
    private static String CLIENT_SECRET;
    private static Token BODY;
    private static UserToken USERBODY;
    private static AuthenticationApi API = new AuthenticationApi();
    private static String ACCESS_TOKEN;
    private static Double EXPIREDAT = -1D;
    private static Double USEREXPIREDAT = -1D;
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    private static String USER_TOKEN;
    /**
     * get token from server
     */
    static {
        InputStream inputStream = TokenUtil.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        GRANT_TYPE = prop.getProperty("GRANT_TYPE");
        CLIENT_ID = prop.getProperty("CLIENT_ID");
        CLIENT_SECRET = prop.getProperty("CLIENT_SECRET");
        BODY = new Token().clientId(CLIENT_ID).grantType(GRANT_TYPE).clientSecret(CLIENT_SECRET);
        USERBODY = (UserToken) new UserToken().clientId(CLIENT_ID).grantType("password").clientSecret(CLIENT_SECRET);
    }

    public static void initTokenByProp() {
        String resp = null;
        try {
            resp = API.orgNameAppNameTokenPost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, BODY);
        } catch (ApiException e) {
            logger.error(e.getMessage());
        }
        Gson gson = new Gson();
        Map map = gson.fromJson(resp, Map.class);
        ACCESS_TOKEN = " Bearer " + map.get("access_token");
        EXPIREDAT = System.currentTimeMillis() + (Double) map.get("expires_in");
    }
    
    public static String initTokenUserByProp(String username,String password) {
    	String resp = null;
    	try {
    		USERBODY.setUsername(username);
    		USERBODY.setPassword(password);
    		resp = API.orgNameAppNameTokenPost(OrgInfo.ORG_NAME, OrgInfo.APP_NAME, USERBODY);
    		return resp;
    	} catch (ApiException e) {
    		logger.error(e.getMessage());
    	}
    	return null;
    	/*Gson gson = new Gson();
    	Map map = gson.fromJson(resp, Map.class);
    	logger.info("返回值:"+resp);
    	USER_TOKEN = " Bearer " + map.get("access_token");
    	logger.info(USER_TOKEN);
    	USEREXPIREDAT = System.currentTimeMillis() + (Double) map.get("expires_in");*/
    }

    /**
     * get Token from memory
     *
     * @return
     */
    public static String getAccessToken() {
        if (ACCESS_TOKEN == null || isExpired()) {
            initTokenByProp();
        }
        return ACCESS_TOKEN;
    }
    public static String getUserToken(String username,String password) {
    	if (USER_TOKEN == null || isUserExpired()) {
    		initTokenUserByProp(username,password);
    	}
    	return USER_TOKEN;
    }

    private static Boolean isExpired() {
        return System.currentTimeMillis() > EXPIREDAT;
    }
    private static Boolean isUserExpired() {
    	return System.currentTimeMillis() > USEREXPIREDAT;
    }

}


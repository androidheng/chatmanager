package com.chat.service.impl;

import com.chat.service.AuthTokenAPI;
import com.chat.utils.TokenUtil;

public class EasemobAuthToken implements AuthTokenAPI{

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}

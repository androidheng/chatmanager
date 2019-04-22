package com.chat.test;

import org.junit.Assert;
import org.junit.Test;

import com.chat.service.impl.EasemobAuthToken;

import io.swagger.client.ApiException;

/**
 * Created by easemob on 2017/3/21.
 */
public class TokenGenerateTest {
    private EasemobAuthToken easemobAuthToken = new EasemobAuthToken();

    @Test
    public void testTokenGet() throws ApiException {
        System.out.println(easemobAuthToken.getAuthToken());
        Assert.assertNotNull(easemobAuthToken.getAuthToken());
    }
}

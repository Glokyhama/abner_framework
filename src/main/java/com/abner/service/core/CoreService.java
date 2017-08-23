package com.abner.service.core;

public interface CoreService {

    // 用户登录
    String login(String identifier, String identityType, String certificate);

    // 发送验证码
    String sendVerifyCode(String mobile);

    // 取得用户信息
    String getUser(String token);

    // 校验用户的TOKEN
    String checkUserToken(String token) throws Exception;

}

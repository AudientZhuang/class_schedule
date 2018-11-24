package com.zqu.yiban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zqu.yiban.common.AuthorizeUtil;

@Controller
public class UserController {
	/**
	 * 授权请求
	 * @return
	 */
	@RequestMapping(value="/authorizeRequest.do", method=RequestMethod.GET)
	public String authorizeRequest() {
		return AuthorizeUtil.authorizeRequest();
	}
	
	/**
	 * 获取授权凭证
	 * @param code	已授权的令牌
	 * @return
	 */
	@RequestMapping(value="/getAccessToken.do", method=RequestMethod.GET)
	public String getAccess_token(String code) {
		return AuthorizeUtil.getAccess_token(code);
	}
	
	/**
	 * 获取当前用户基本信息
	 * @param accessToken	用户授权凭证
	 * @return
	 */
	@RequestMapping(value="/getUserMessage.do", method=RequestMethod.GET)
	public String getUserMessage(String accessToken) {
		return AuthorizeUtil.getUserMessage(accessToken);
	}
	
	/**
	 * 获取当前用户校方认证信息
	 * @param accessToken	用户授权凭证
	 * @return
	 */
	public String getVerifyUserMessage(String accessToken) {
		return AuthorizeUtil.getVerifyUserMessage(accessToken);
	}
}

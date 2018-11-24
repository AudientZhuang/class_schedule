package com.zqu.yiban.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class AuthorizeUtil {
	public final static String APPID = "816f8f838c1ba11e";
	public final static String APPSECRET = "c51f73f4735aa57fd97e1326edf478ac";
	
	/**
	 * 授权请求
	 * @return
	 */
	//@RequestMapping(value="/authorizeRequest.do", method=RequestMethod.GET)
	public  static String authorizeRequest(){
		return "redirect:https://openapi.yiban.cn/oauth/authorize?client_id="+ APPID + "&redirect_uri=http://localhost/class_schedule&state=STATE";
	}
	
	/**
	 * 获取授权凭证
	 * @param code	已授权的令牌
	 * @return
	 */
	//@RequestMapping(value="/getAccessToken.do", method=RequestMethod.GET)
	public static String getAccess_token(String code) {
		//建立一个NameValuePair数组，用于存储欲传送的参数
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id",APPID));
		params.add(new BasicNameValuePair("client_secret",APPSECRET));
		params.add(new BasicNameValuePair("code",code));
		params.add(new BasicNameValuePair("redirect_uri","http://localhost/class_schedule"));
		String result = cn.yiban.util.HTTPSimple.POST("https://openapi.yiban.cn/oauth/access_token", params);
/*		System.out.println(result);
		JSONObject json = JSONObject.parseObject(result);
		String accessToken = json.getString("access_token");
		System.out.println(accessToken);*/
		return result;
	}
	/**
	 * 获取当前用户基本信息
	 * @param accessToken	用户授权凭证
	 * @return
	 */
	//@RequestMapping(value="/getUserMessage.do", method = RequestMethod.GET)
	public static String getUserMessage(String accessToken) {
		return "redirect:https://openapi.yiban.cn/user/me?access_token=" + accessToken;
	}
	/**
	 * 获取当前用户校方认证信息
	 * @param accessToken	用户授权凭证
	 * @return
	 */
	public static String getVerifyUserMessage(String accessToken) {
		return "redirect:https://openapi.yiban.cn/user/verify_me?access_token=" + accessToken;
	}
}

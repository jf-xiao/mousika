package com.mousika.security.service;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.DigestUtils;

public class IpTokenBasedRememberService extends TokenBasedRememberMeServices {
	
	private ThreadLocal<HttpServletRequest> requestHold = new ThreadLocal<HttpServletRequest>();
	
	private void setContext(HttpServletRequest request){
		requestHold.set(request);
	}
	
	private HttpServletRequest getContext(){
		return requestHold.get();
	}
	/**
	 * 获取当前访问的Ip地址
	 * @param request
	 * @return
	 */
	private String getIpAddress(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
	@Override
	public void onLoginSuccess(HttpServletRequest request,HttpServletResponse response,Authentication successfulAuthentication) {
		try {
			this.setContext(request);
			super.onLoginSuccess(request, response, successfulAuthentication);
		} catch (Exception e) {
			this.setContext(null);
		}
	}
	
	@Override
	protected String makeTokenSignature(long tokenExpiryTime, String username,String password) {
		String str = username+":"+tokenExpiryTime+":"+password+":"+getKey()+":"+getIpAddress(getContext());
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
	@Override
	protected void setCookie(String[] tokens, int maxAge,HttpServletRequest request, HttpServletResponse response) {
		String[] ipTokens = Arrays.copyOf(tokens, tokens.length+1);
		ipTokens[ipTokens.length-1] = getIpAddress(request);
		super.setCookie(ipTokens, maxAge, request, response);
	}
	
	@Override
	protected UserDetails processAutoLoginCookie(String[] cookieTokens,HttpServletRequest request, HttpServletResponse response) {
		
		this.setContext(request);
		String ipAddressToken = cookieTokens[cookieTokens.length - 1];
		if(!getIpAddress(getContext()).equals(ipAddressToken)){
			throw new InvalidCookieException("cookie error !!");
		}
		return super.processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length-1), request, response);
	}
}

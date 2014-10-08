package com.mousika.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.DigestUtils;

/**
 * 增加IP访问安全的Remember me功能
 * @author xiaojf 294825811@qq.com
 */
public class IpTokenBasedRememberService extends TokenBasedRememberMeServices {

    private ThreadLocal<HttpServletRequest> requestHold = new ThreadLocal<HttpServletRequest>();

    private void setContext(HttpServletRequest request) {
        //将当前的 request请求的备份到当前线程中
        requestHold.set(request);
    }
    
    /**
     * 获取当前访问的request对象
     * @return
     */
    private HttpServletRequest getContext() {
        return requestHold.get();
    }

    /**
     * 获取当前访问的Ip地址
     * 
     * @param request
     * @return 当前访问的Ip地址
     */
    private String getIpAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    @Override
    public void onLoginSuccess(HttpServletRequest request,HttpServletResponse response,Authentication successfulAuthentication) {
        try {
            //注入当前访问request对象
            this.setContext(request);
            //登陆成功操作
            super.onLoginSuccess(request, response, successfulAuthentication);
        } catch (Exception e) {
            //发生异常， 将当前访问的request对象清空
            this.setContext(null);
        }
    }
    
    /**
     * 创建cookie 标识
     */
    @Override
    protected String makeTokenSignature(long tokenExpiryTime, String username,String password) {
        //将当前访问的IP地址写入cookie中
        String str = username + ":" + tokenExpiryTime + ":" + password + ":"
                + getKey() + ":" + getIpAddress(getContext());
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 设置cookie值
     */
    @Override
    protected void setCookie(String[] tokens, int maxAge,HttpServletRequest request, HttpServletResponse response) {
        String[] ipTokens = Arrays.copyOf(tokens, tokens.length + 1);
        ipTokens[ipTokens.length - 1] = getIpAddress(request);
        super.setCookie(ipTokens, maxAge, request, response);
    }

    /**
     * cookie 校验
     */
    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens,HttpServletRequest request, HttpServletResponse response) {
        //确定当前访问请求的request对象
        this.setContext(request);
        //获取cookie中绑定的IP地址
        String ipAddressToken = cookieTokens[cookieTokens.length - 1];
        if (!getIpAddress(getContext()).equals(ipAddressToken)) {
            //ip地址校验失败
            throw new InvalidCookieException("cookie error !!");
        }
        //ip地址校验成功
        return super.processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length - 1), request,response);
    }
}

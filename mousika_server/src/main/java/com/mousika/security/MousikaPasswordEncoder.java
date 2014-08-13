package com.mousika.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * 自定义密码加密方式
 * @author xiaojf
 *
 */
public class MousikaPasswordEncoder implements PasswordEncoder {

    /**
     * 加密规则
     */
    @Override
    public String encodePassword(String rawPass, Object salt) {
        return DigestUtils.md5Hex((rawPass + "{" + salt + "}" + "StD9vdd1Pws8KWye").toUpperCase().getBytes()).toString();
    }

    /**
     * 是否检验成功
     */
    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String pass = encodePassword(rawPass, salt);
        //密码匹配
        if (encPass.trim().equals(pass.trim())) {
            //校验成功
            return true;
        }
        //校验失败
        return false;
    }

}

package com.mousika.security.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MousikaPasswordEncoder implements PasswordEncoder {

    @Override
    public String encodePassword(String rawPass, Object salt) {
        return DigestUtils.md5Hex(
                (rawPass + "{" + salt + "}" + "StD9vdd1Pws8KWye").toUpperCase()
                        .getBytes()).toString();
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String pass = encodePassword(rawPass, salt);
        if (encPass.trim().equals(pass.trim())) {
            return true;
        }

        return false;
    }

}

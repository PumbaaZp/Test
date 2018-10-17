package com.pro.MD5;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class encode {
    
    static String username="丽水市";
    static String password="111111";
    
    public static void main(String args[]){
        Md5PasswordEncoder pswEncoder = new Md5PasswordEncoder();
        System.out.println(pswEncoder.encodePassword(password,username));
    }

}

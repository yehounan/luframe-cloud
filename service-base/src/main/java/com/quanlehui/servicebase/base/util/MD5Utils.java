package com.quanlehui.servicebase.base.util;

import java.security.MessageDigest;

/**
 * Desc    : MD5加密工具类
 * Author  : yxy
 * Date    : 2018-03-07
 */
public class MD5Utils {

    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

//    public static void main(String[] args) {
//        String str = "123456ljcz";
//        System.out.println(MD5Utils.MD5(str));
//        System.out.println(MD5Utils.MD5(MD5Utils.MD5(str)));
//        String str2 = "8B9FBBC0505C110AF2A9DB02B84C5710";
//        //14e1b600b1fd579f47433b88e8d85291
//        //14e1b600b1fd579f47433b88e8d85291
//        //ba15adcd44ea2dd2fb01b4b744411652
//        System.out.println(MD5Utils.MD5(str2));
//    }
}

package com.quanlehui.servicebase.base.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Desc    : AES加密解密工具类
 * Date    : 2018-03-05
 */
public class AESUtils {

    /**
     * AES 加密
     *
     * @param content 需要加密的内容
     * @param aesKey  加密密钥
     * @return
     */
    public static String AESEncrypt(String content, String aesKey) {
         try {
             KeyGenerator kgen = KeyGenerator.getInstance("AES");
             SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
             random.setSeed(aesKey.getBytes());
             kgen.init(128, random);
             SecretKey secretKey = kgen.generateKey();
             byte[] enCodeFormat = secretKey.getEncoded();
             SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
             Cipher cipher = Cipher.getInstance("AES");// 创建密码器
             byte[] byteContent = content.getBytes("utf-8");
             cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
             byte[] result = cipher.doFinal(byteContent);
             String res = parseByte2HexStr(result);
             return res; // 加密
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         } catch (NoSuchPaddingException e) {
             e.printStackTrace();
         } catch (InvalidKeyException e) {
             e.printStackTrace();
         } catch (UnsupportedEncodingException e) {
             e.printStackTrace();
         } catch (IllegalBlockSizeException e) {
             e.printStackTrace();
         } catch (BadPaddingException e) {
             e.printStackTrace();
         }
         return null;
     }

     /**
      * 解密
      *
      * @param content 待解密内容
      * @param aesKey  解密密钥 秘miyao
      * @return
      */
     public static String AESDecrypt(String content, String aesKey) {
         try {
             KeyGenerator kgen = KeyGenerator.getInstance("AES");
             SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
             random.setSeed(aesKey.getBytes());
             kgen.init(128, random);
             SecretKey secretKey = kgen.generateKey();
             byte[] enCodeFormat = secretKey.getEncoded();
             SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
             Cipher cipher = Cipher.getInstance("AES");// 创建密码器
             cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
             byte[] result = cipher.doFinal(parseHexStr2Byte(content));
             String res = new String(result);
             return res; // 解密
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         } catch (NoSuchPaddingException e) {
             e.printStackTrace();
         } catch (InvalidKeyException e) {
             e.printStackTrace();
         } catch (IllegalBlockSizeException e) {
             e.printStackTrace();
         } catch (BadPaddingException e) {
             e.printStackTrace();
         }
         return null;
     }

     /**
      * 将二进制转换成16进制
      */
     private static String parseByte2HexStr(byte[] buf) {
         StringBuffer sb = new StringBuffer();
         for (int i = 0; i < buf.length; i++) {
             String hex = Integer.toHexString(buf[i] & 0xFF);
             if (hex.length() == 1) {
                 hex = '0' + hex;
             }
             sb.append(hex.toUpperCase());
         }
         return sb.toString();
     }

     /**
      * 将16进制转换为二进制
      */
     private static byte[] parseHexStr2Byte(String hexStr) {
         if (hexStr.length() < 1)
             return null;
         byte[] result = new byte[hexStr.length() / 2];
         for (int i = 0; i < hexStr.length() / 2; i++) {
             int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
             int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
             result[i] = (byte) (high * 16 + low);
         }
         return result;
     }

//    public static void main(String[] args) {
//        String content = "admin";
//        String aesKey = "seksdfsde";
//        String p = AESEncrypt(content,aesKey);
//        System.out.println(p);
//        String o = AESDecrypt("1BF677137BFC8DD9732D0C15A1AE69D9",aesKey);
//        System.out.println(o);
//    }

}

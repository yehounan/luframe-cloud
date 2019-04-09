package com.quanlehui.adminservice.util;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.util.Map;

/**
 * @Desscription 格式化工具类
 * @Author DongChangSha
 * @Date 2018/1/11 9:26
 */
public class FormatUtil {


    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance();

    private static final int NUBER_LENGTH=8;

    static {
        NUMBER_FORMAT.setMaximumFractionDigits(2);
    }

    /**
     * 格式化手机号，供界面显示
     *
     * @param phoneNumber
     * @return
     */
    public static String formatPhoneNumber(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return phoneNumber;
        }
        if (phoneNumber.length() < NUBER_LENGTH) {
            return new StringBuilder(phoneNumber).insert(phoneNumber.length() / 2, "****").toString();
        }
        return phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(phoneNumber.length() - 4);
    }

    /**
     * 格式化银行卡号，供界面显示
     *
     * @param bankCardNo
     * @return
     */
    public static String formatBankCardNo(String bankCardNo) {
        if (StringUtils.isEmpty(bankCardNo)) {
            return bankCardNo;
        }
        if (bankCardNo.length() < NUBER_LENGTH) {
            return new StringBuilder(bankCardNo).insert(bankCardNo.length() / 2, " **** **** ").toString();
        }
        return bankCardNo.substring(0, 4) + " **** **** " + bankCardNo.substring(bankCardNo.length() - 4);
    }

    /**
     * 格式化敏感信息
     *
     * @param sensitive
     * @return
     */
    public static String formatSensitive(String sensitive) {
        if (StringUtils.isEmpty(sensitive)) {
            return "";
        }
        return sensitive.substring(0, 1) + "****";
    }

    /**
     * 用户注册时检查密码格式是否正确
     * 密码格式要求:由数字和字母组成，并且要同时含有数字和字母，且长度要在6-20位之间
     *
     * @param password
     * @return
     */
    public static Boolean isPasswordFormatOK(String password) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        if (StringUtils.isBlank(password)) {
            return false;
        }
        return password.matches(regex);
    }

    /**
     * 银行卡号格式：数字，10-25位。
     *
     * @param bankCardNo
     * @return
     */
    public static Boolean isBankCardNoFormatOK(String bankCardNo) {
        String regex = "^[1-9][0-9]{9,24}$";
        if (StringUtils.isBlank(bankCardNo)) {
            return false;
        }
        return bankCardNo.matches(regex);
    }

    /**
     * 手机号只能输入6-15位数字
     *
     * @param phoneNo
     * @return
     */
    public static Boolean isPhoneNumberFormatOK(String phoneNo) {
        String regex = "^[1-9][0-9]{5,14}$";
        if (StringUtils.isBlank(phoneNo)) {
            return false;
        }
        return phoneNo.matches(regex);
    }

    /**
     * 是否正确的邮箱格式
     *
     * @param email
     * @return
     */
    public static Boolean isEmailFormatOK(String email) {
        String regex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        if (StringUtils.isBlank(email)) {
            return false;
        }
        return email.matches(regex);
    }

    /**
     * 根据模板构造短信内容
     *
     * @param param
     * @param templetContent
     * @return
     */
    public static String buildContent(Map<String, String> param, String templetContent) {
        // 替换变量内容
        StringBuilder content = new StringBuilder(templetContent);
        for (Map.Entry<String, String> entry : param.entrySet()) {
            String key = "${" + entry.getKey() + "}";
            String value = entry.getValue();
            int index = content.indexOf(key);
            while (index >= 0) {
                content.replace(index, index + key.length(), value != null ? value : "");
                index = content.indexOf(key);
            }
        }
        return content.toString();
    }

    /**
     * 数字格式化
     *
     * @param number
     * @return
     */
    public static String formatNumber(double number) {
        return NUMBER_FORMAT.format(number);
    }

    public static void main(String[] args) {
        System.out.println(isPhoneNumberFormatOK(""));
        System.out.println(formatNumber(2154651.64654546567));
        System.out.println(isEmailFormatOK("dongcs015@udduo.com"));
    }

}

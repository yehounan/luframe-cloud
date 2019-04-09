package com.quanlehui.servicebase.base.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Desc    : 十进制格式化工具类
 * Date    : 2018-04-18
 */
public class DecimalUtils {

    /**
     * Double格式化
     *
     * @param original
     * @param newScale
     * @return
     */
    public static Double getFormatDoubleValue(Double original, int newScale) {
        BigDecimal originalBigDecimal = new BigDecimal(original);
        return originalBigDecimal.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Double默认格式化
     *
     * @param original
     * @return
     */
    public static Double getFormatDoubleValue(Double original) {
        BigDecimal originalBigDecimal = new BigDecimal(original);
        return originalBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static BigDecimal formatDecimal(BigDecimal original) {
        if (original == null) {
            return BigDecimal.ZERO;
        }
        return original.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal formatString(String original) {
        if (StringUtils.isEmpty(original)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(original).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 赔率格式化方法
     *
     * @param original
     * @return
     */
    public static Double getOddsFormatDoubleValue(Double original) {
        BigDecimal originalBigDecimal = new BigDecimal(original);
        return originalBigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

//    public static void main(String[] args) {
//        Double t = 1.119999999D;
//        System.out.println(getFormatDoubleValue(t, 3));
//    }

}

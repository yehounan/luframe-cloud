package com.quanlehui.servicebase.base.util;

import java.math.BigDecimal;

/**
 * Desc    : 算术工具类
 * Date    : 2018-01-22
 *
 * @author : yxy
 */
public class MathUtils {

    public static double getApproximate(double x, double[] src) {
     if (src == null) {
             return -1;
     }
     if (src.length == 1) {
             return src[0];
     }
     double minDifference = Math.abs(src[0] - x);
     int minIndex = 0;
     for (int i = 1; i < src.length; i++) {
         double temp = Math.abs(src[i] - x);
             if (temp < minDifference) {
                     minIndex = i;
                     minDifference = temp;
             }
     }
     return src[minIndex];
    }

    /**
     * 保留两位小数
     * @param dd
     * @return
     */
    public static double  doubleRetainTwo(double dd){
        Double d=dd;
        if (d.equals(Double.NaN) || d.equals(Double.POSITIVE_INFINITY) || d.equals(Double.NEGATIVE_INFINITY)){
            return 0d;
        }
        BigDecimal b = new BigDecimal(d);
        double df = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return df;
    }

}

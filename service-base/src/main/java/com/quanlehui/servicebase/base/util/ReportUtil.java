package com.quanlehui.servicebase.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/3/8.
 */
public class ReportUtil {


    public static Map getMap(String date, List<Map> list,String key){
        for(int i=0;i<list.size();i++){
            Map map=list.get(i);
            if(date.equals(map.get(key).toString())){
                return   map;
            }
        }
        return null;
    }

    public static   String getMax(Double [] arr){
        Double max=arr[0]; // 把数据中的第1个元素存max
        Double min=arr[0]; // 把数据中的第1个元素存min
        for(int i=1;i<arr.length;i++){ // 从第二个元素开始遍历数组
            if(arr[i]>max){  // 假如元素大于max 就把当前值赋值给max
                max=arr[i];
            }
            if(arr[i]<min){  // 假如元素小于min 就把当前值赋值给min
                min=arr[i];
            }
        }
        return  max.toString();
    }




    /**
     * 获取两个日期之间的所有日期列表
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("all")
    public static  String [] findDates(String start, String end) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dBegin = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            List<String> lDate = new ArrayList();
            lDate.add(start);
            Calendar calBegin = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calBegin.setTime(dBegin);
            Calendar calEnd = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            calEnd.setTime(dEnd);
            // 测试此日期是否在指定日期之后
            while (dEnd.after(calBegin.getTime()))
            {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                lDate.add(sdf.format(calBegin.getTime()) );
            }



            //拼装折线图时间
            String [] time=new String[lDate.size()];
            for(int i=0;i<lDate.size();i++){
                time[i]=lDate.get(i).toString();
            }

            return time;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

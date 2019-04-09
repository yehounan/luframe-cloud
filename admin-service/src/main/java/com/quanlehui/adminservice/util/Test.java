package com.quanlehui.adminservice.util;

import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/8 22:00
 */
public class Test {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost",6379);
        jedis.append("dasd","1511");


    }
}

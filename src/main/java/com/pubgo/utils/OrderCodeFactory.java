package com.pubgo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 描述：     生成单号No工具类
 *
 */
public class OrderCodeFactory {

	
    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    private static int getRandom(long digit) {
        Random random = new Random();
        // 获取n位随机数
        return (int) (random.nextDouble() * Math.pow(10, digit)+ Math.pow(10, digit));
    }

    /**
     * 	返回单号No
     * @param code   单号前缀
     * @return
     */
    public static String getOrderCode(String code) {
        return code + getDateTime() + getRandom(3);
    }
    
    /**
     * 	返回单号No
     * @param code 单号前缀
     * @param digit  获取n位随机数
     * @return
     */
    public static String getOrderCode(String code, long digit ) {
        return code + getDateTime() + getRandom(digit);
    }
}

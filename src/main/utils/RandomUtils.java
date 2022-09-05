package main.utils;

import java.util.Random;

/**
 * @Author: wenzf
 * @Date: 2022/09/05/10:47
 * @Description: 随机数值生成方法
 */
public class RandomUtils {
    /***
     * @Description: 随机生成小于等于val的随机数
     * @Param: [val]
     * @return: int
     */
    public static int Random(int val) {
        Random random = new Random();
        return random.nextInt(val);
    }
    /***
    * @Description: 随机生成某个范围的随机
    * @Param: [val]
    * @return: int
    */
    public static int RandomMath(int val) {
        int value = 0;
        if (val <= 10) {
           value =  (int)(Math.random()*val);
        }else {
            value =  (int)(Math.random()*val)+val;
        }
        return value;
    }
}

package com.java8.edu.java_interview.exam1;

/**
 * 数字反转，比如：123456 转换完数字是 654321
 */
public class TestExam1 {
    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        Long bi = 123456L;
        //反转
        Long l = reverse(bi);
        System.out.println(l);
    }

    /**
     * 反转
     * 思路：通过 %取余 获取到末端数,通过 /除法 进行降位
     * @param n
     * @return
     */
    public static Long reverse(Long n) {
        Long temp = 0L;
        Long num = 0L;
        //循环
        while(n.intValue() != 0) {
            //通过 %取余 获取到末端数
            num = num * 10 + n % 10;
            //通过 /除法 进行降位
            if(temp != num/10) {
                return 0L;
            }
            temp = num;
            n = n/10;
        }
        return num;
    }
}

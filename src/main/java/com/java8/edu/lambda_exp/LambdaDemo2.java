package com.java8.edu.lambda_exp;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by garychen on 2017/11/7.
 */
public class LambdaDemo2 {
    @Test
    public void test01() {
        //before
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        ts.add("af343");
        ts.add("sdf");
        ts.add("sdfsssssssss");

        System.out.println(ts);
        //1.8

        TreeSet<String> ts2 = new TreeSet<>((o1, o2) -> Integer.compare(o1.length(),o2.length()));
        ts2.add("aa111111");
        ts2.add("vvv");
        ts2.add("ccces");
        //左侧：指定了Lambda 表达式需要的所有参数
        //右侧：指定了Lambda 体，即Lambda 表达式要执行的功能。

        System.out.println(ts2);
    }
}

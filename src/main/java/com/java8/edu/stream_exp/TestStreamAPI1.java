package com.java8.edu.stream_exp;

import com.java8.edu.lambda_exp.edu_lambda1.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. Stream的三个操作步骤:
 * a. 创建Stream
 * b. 中间操作
 * c. 终止操作
 * Created by garychen on 2017/11/8.
 */
public class TestStreamAPI1 {

    //创建Stream的四种方式
    @Test
    public void test01(){
        //1.通过Conllection系列集合提供的stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays 中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream 中的静态方法获取流
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        //stream4.forEach(System.out::println);//无限
        stream4.limit(10).forEach(System.out::println);//产生10个

        //生成
        Stream.generate(()-> Math.random()).limit(5)
                .forEach(System.out::println);
    }

}

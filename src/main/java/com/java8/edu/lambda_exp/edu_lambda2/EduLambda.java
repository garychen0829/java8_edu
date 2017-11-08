package com.java8.edu.lambda_exp.edu_lambda2;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * 一: Lambda 表达式的基本语法. Java8中引入 "->" 箭头操作符,或者叫Lambda操作符
 *                             操作符把Lambda表达式拆分为2个部分
 *
 * 左侧:表达式的参数列表                    接口中的参数列表.
 * 右侧:表达式中所需要执行的功能, Lambda体.  接口中对应方法的实现
 *
 * 语法格式一: 无参数,无返回值
 *            () -> System.out.println("hello Lambda.")
 * 语法方式二: 有一个参数,无返回值
 *            (x) -> System.out.println(x);
 * 语法方式三: 若只有一个参数,参数的小括号可以省略不写 (通常用第二种方式,带小括号的)
 *            x -> System.out.println(x);
 * 语法方式四: 有两个以上的参数,有返回值,并且Lambda体中有多条语句
 *            Comparator<Integer> com = (x,y) -> {
 *              System.out.println("函数式");
 *              return Integer.compare(x, y);
 *             };
 * 语法方式五: 若Lambda体中只有一条语句,return 和大括号都可以省略不写
 *            (x,y) -> Integer.compare(x, y);
 * 语法方式六: Lambda表达式的参数数据类型可以省略不写,因为jvm编译器通过上下文可以推断出,数据类型
 *
 *
 * 二: Lambda 表达式需要"函数式接口"的支持
 * 函数式接口: 接口中只有一个抽象方法的接口,称为函数式接口. 可以使用注解 @FunctionalInterface 修饰
 *              可以检查是否是函数式接口
 */
public class EduLambda {


    /**
     * 语法格式一: 无参数,无返回值
     *            () -> System.out.println("hello Lambda.")
     */
    @Test
    public void test01(){
        int num = 0;//jdk 1.7之前,必须是final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world, " + num);
            }
        };
        r.run();
        System.out.println("================================");

        Runnable r1 = () -> System.out.println("hello Lambda, " + num);
        r1.run();
    }

    @Test
    public void test02(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("有一个参数,无返回值");
    }

    @Test
    public void test03(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式");
            return Integer.compare(x, y);
        };
        com.compare(9,10);
        System.out.println(com.compare(9,10));
    }

    @Test
    public void test04(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
        System.out.println(com.compare(111,10));
    }


    public void test05(){

        String[] strs = {"a","b","c"};

        List<String> list = new ArrayList<>();

        testMap(new HashMap<>());//java8 可以不写<>中的数据类型, java8 通过jvm的上下问

    }

    public void testMap(Map<String,Integer> map){

    }

    //对一个数进行运算.
    @Test
    public void test06(){
        Integer num = operation(100, (x) -> x*x);
        System.out.println(num);

        Integer num1 = operation(200, (x) -> x + 22);
        System.out.println(num1);
    }
    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }
}

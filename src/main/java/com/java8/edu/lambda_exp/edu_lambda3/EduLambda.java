package com.java8.edu.lambda_exp.edu_lambda3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 * Consumer<T> : 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *      T get();
 *
 * Function<T, R> : 函数型接口
 *      R apply(T t);
 *
 * Predicate<T> : 断言型接口
 *      boolean test(T t);
 */
public class EduLambda {

    /**
     * Predicate<T> : 断言型接口
     *      boolean test(T t);
     */
    @Test
    public void test04() {
        List<String> list = Arrays.asList("java","c","c++","vb");
        List<String> strList = filterStr(list, (s) -> s.length() > 2);
        for (String str : strList) {
            System.out.println(str);
        }

    }

    //将满足条件的字符传,放入集合中去.
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    /**
     * Function<T, R> : 函数型接口
     *      R apply(T t);
     */
    @Test
    public void test03(){
        String str = strHandler("abcdefg", (x) -> x.toUpperCase());
        System.out.println(str);
    }

    //用于处理字符串
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);

    }

    /**
     * Supplier<T> : 供给型接口
     *      T get();
     */
    @Test
    public void test02(){
        List<Integer> listnums = getNumber(100, () -> (int)(Math.random() * 100));
        for (Integer i : listnums) {
            System.out.println(i);
        }
    }

    //产生一些整数,放入集合
    public List<Integer> getNumber(int size, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Consumer<T> : 消费型接口
     *      void accept(T t);
     */
    @Test
    public void test01(){
        happy(100, (x)-> System.out.println("消费: " + x + " 元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}

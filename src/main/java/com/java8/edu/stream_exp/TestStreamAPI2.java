package com.java8.edu.stream_exp;

import com.java8.edu.lambda_exp.edu_lambda1.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 1. Stream的三个操作步骤:
 * a. 创建Stream
 * b. 中间操作
 * c. 终止操作
 * Created by garychen on 2017/11/8.
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18, 9999.99,null),
            new Employee("张三",18, 9999.99,null),
            new Employee("张三",18, 9999.99,null),
            new Employee("张三",17, 9999.99,null),
            new Employee("张三",19, 9999.99,null),
            new Employee("李四",21, 3333.33,null),
            new Employee("赵六",44, 5555.55,null),
            new Employee("陈七",44, 4444.44,null),
            new Employee("王五",31, 6666.6,null));

    //中间操作
    /*
    sorted()                产生一个新流，其中按自然顺序排序  (Comparable)
    sorted(Comparatorcomp)  产生一个新流，其中按比较器顺序排序(Comparator)
     */
    @Test
    public void test07(){
        List<String> list = Arrays.asList("aa","ee","cc","dd","bb");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------------");

        employees.stream()
                .sorted((e1,e2) -> {
                    if (e1.getAge() == e2.getAge()){//名称相同比年龄
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return -e1.getAge().compareTo(e2.getAge());  // "-" 倒序
                    }
                }).forEach(System.out::println);

    }


    /*
        映射
        map(Function f)                  接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        mapToDouble(ToDoubleFunction f)  接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的DoubleStream。
        mapToInt(ToIntFunction f)        接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的IntStream。
        mapToLong(ToLongFunction f)      接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的LongStream。
        flatMap(Function f)              接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test06(){
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("------------------------------------------");

        employees.stream()
//                .map((employees)-> employees.getName())
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");

        Stream<Stream<Character>> stream = list.stream()
                            .map(TestStreamAPI2::filterCharacter);
        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
        System.out.println("------------------------------------------");

        Stream<Character> stream1 = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);
        stream1.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    //筛选与切片start====================================================================================//
    /*
        筛选与切片
        filter   --接收Lambda, 从流中排除某些元素
        limit    --截断流, 使其元素不超过给定数量
        skip(n)  --跳过元素,返回一个扔掉了前 n 个元素的流. 若流中元素不足 n 个,则返回一个空流. 与limit(n) 互补
        distinct --筛选,通过流所生成元素的hashCode() 和 equals() 去除重复元素
     */
    @Test
    public void test05(){
        employees.stream()
                .filter((e)-> e.getSalary() > 5000)
                .skip(2)
                .distinct()//筛选,通过流所生成元素的hashCode() 和 equals() 去除重复元素
                .forEach(System.out::println);
    }

    @Test
    public void test04(){
        //从结果的流的集合中跳过前2个.再输出
        employees.stream()
                    .filter((e)-> e.getSalary() > 5000)
                    .skip(2)
                    .forEach(System.out::println);
    }

    @Test
    public void test03(){
        System.out.println("======================短路=====================");
        employees.stream()
                    .filter((e)->e.getSalary() > 5000)
                    .limit(2)
                    .forEach(System.out::println);
        System.out.println("=============================================");
        employees.stream()
                    .filter((e)->e.getSalary() > 5000)
                    .limit(5)
                    .forEach(System.out::println);
    }

    //内部迭代,有Stream API完成
    @Test
    public void test01(){
        Stream<Employee> stream = employees.stream()      //获取流
                                        .filter((e) -> e.getAge() > 35); //中间操作不输出结果
        //终止操作: 一次性执行全部内容,即"惰性求值","延迟加载"
        stream.forEach(System.out::println);
    }

    //外部迭代: 我们自己用迭代器做的
    @Test
    public void test02(){
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getName());
        }
    }
    //筛选与切片end====================================================================================//
}

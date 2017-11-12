package com.java8.edu.stream_exp;

import com.java8.edu.lambda_exp.edu_lambda1.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by garychen on 2017/11/9.
 */
public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18, 9999.99, Employee.Status.FREE),
            new Employee("李四",21, 3333.33, Employee.Status.BUSY),
            new Employee("赵六",44, 5555.55, Employee.Status.VOCATION),
            new Employee("陈七",44, 4444.44, Employee.Status.FREE),
            new Employee("王五",55, 6666.6, Employee.Status.BUSY));

    /*
        collect(Collector c) 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test10(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","<<<",">>>"));
        System.out.println(str);
    }

    @Test
    public void test09(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }

    @Test
    public void test08(){
        Map<Boolean, List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(map);
    }

    /**
     * 多级分组
     */
    @Test
    public void test07(){
        Map<Employee.Status, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (((Employee)e).getAge() <= 35) {
                        return "青年";
                    }else if (((Employee)e).getAge() <= 50) {
                        return "中年";
                    }else{
                        return "老年";
                    }
                })));
        System.out.println(map);
    }

    /**
     * 分组
     */
    @Test
    public void test06(){
        Map<Employee.Status,List<Employee>> map = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }


    @Test
    public void test05(){
        //总数
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("===================================");

        //平均值
        Double avg = employees.stream()
                    .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        //总和
        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());

    }

    @Test
    public void test04() {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("===================================");

        Set<String> sets = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        sets.forEach(System.out::println);

        System.out.println("===================================");

        HashSet<String> hashSets = employees.stream()
                    .map(Employee::getName)
                    .collect(Collectors.toCollection(HashSet::new));
        hashSets.forEach(System.out::println);

    }

    /*
        归约
        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回T
        归约
        reduce(BinaryOperator b)         可以将流中元素反复结合起来，
     */
    @Test
    public void test03(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream()
                .reduce(0,(x,y)-> x+y);
        System.out.println(sum);
        System.out.println("===================================");

        Optional<Double> op = employees.stream()
                    .map(Employee::getSalary)
                    .reduce(Double::sum);
        System.out.println(op.get());

    }

    /*
    查找与匹配
    方法描述
        allMatch(Predicate p)   检查是否匹配所有元素
        anyMatch(Predicate p)   检查是否至少匹配一个元素
        noneMatch(Predicatep)   检查是否没有匹配所有元素
        findFirst()             返回第一个元素,终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是void 。
        findAny()               返回当前流中的任意元素
        count()                 返回流中元素的总数
        max()                   返回流中最大值
        min()                   返回流中最小值
     */
    @Test
    public void test02(){
        Long count = employees.stream()
                .count();
        System.out.println(count);

        Optional<Employee> op1 = employees.stream()
                .max((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(op1.get());

        Optional<Double> op2 = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op2.get());
    }

    @Test
    public void test01(){

        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        System.out.println("========================================");

        boolean b2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        System.out.println("========================================");

        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        System.out.println("========================================");

        //避免空指针异常
        Optional<Employee> op = employees.stream()
                .sorted((e1,e2) -> -Double.compare(e1.getSalary(),e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
        //op.orElse();//如果为空用个对象代替
        System.out.println("========================================");

        Optional<Employee> op2 = employees.parallelStream()
                .filter((e)->e.getStatus().equals(Employee.Status.BUSY))
                .findAny();
        System.out.println(op2.get());

    }
}

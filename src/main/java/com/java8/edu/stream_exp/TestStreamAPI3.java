package com.java8.edu.stream_exp;

import com.java8.edu.lambda_exp.edu_lambda1.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by garychen on 2017/11/9.
 */
public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18, 9999.99, Employee.Status.FREE),
            new Employee("李四",21, 3333.33, Employee.Status.BUSY),
            new Employee("赵六",44, 5555.55, Employee.Status.VOCATION),
            new Employee("陈七",44, 4444.44, Employee.Status.FREE),
            new Employee("王五",31, 6666.6, Employee.Status.BUSY));
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

package com.java8.edu.lambda_exp.edu_lambda1;

import org.junit.Test;

import java.util.*;

/**
 * Created by garychen on 2017/11/8.
 */
public class LambdaDemo3 {
    @Test
    public void test01(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    public void test02(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //age > 20 的数据
    List<Employee> employees = Arrays.asList(new Employee("张三",18, 9999.99),
            new Employee("李四",21, 3333.33),
            new Employee("王五",31, 6666.6));
    @Test
    public void test03(){
        List<Employee> list = filterEmployees(employees);
        for (Employee emp : list) {

            System.out.println(emp.toString());
        }
    }

    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp: list) {
            if (emp.getAge() > 20) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public List<Employee> filterEmployees2(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee emp: list) {
            if (emp.getSalary() > 4000) {
                emps.add(emp);
            }
        }
        return emps;
    }


    //优化方法一 策略设计模式
    @Test
    public void test04() {
        List<Employee> list = filterEmployee(employees,new FilterEmployeeByAage());
        for (Employee e : list) {
            System.out.println(e);
        }
        System.out.println("======================================");

        List<Employee> list2 = filterEmployee(employees,new FilterEmployeeBySalary());
        for (Employee e2 : list2) {
            System.out.println(e2);
        }
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();
        for (Employee e : list) {
            if (mp.test(e)) {
                emps.add(e);
            }
        }
        return emps;
    }

    //优化方式二 : 匿名内部类
    @Test
    public void test05(){
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 5000;
            }
        });
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    //优化方式三: Lambda表达式
    @Test
    public void test06(){
        List<Employee> list = filterEmployee(employees, (employee) -> employee.getSalary() < 5000);
        list.forEach(System.out::println);
    }

    //优化方式四: Stream API
    @Test
    public void test07(){
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .forEach(System.out::println);
        System.out.println("=====================================================");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}

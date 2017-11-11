package com.java8.edu.lambda_exp.edu_lambda2.ex;

import com.java8.edu.lambda_exp.edu_lambda1.Employee;
import com.java8.edu.lambda_exp.edu_lambda2.FunStr;
import com.java8.edu.lambda_exp.edu_lambda2.FunStr2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * test01:用Collections.sort()方法,通过定制排序比较两个Employee(先按年龄比, 年龄相同按姓名比),使用Lambda表达式传参
 * Created by garychen on 2017/11/8.
 */
public class ExLambda {

    //age > 20 的数据
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18, 9999.99,null),
            new Employee("李四",21, 3333.33,null),
            new Employee("赵六",44, 5555.55,null),
            new Employee("陈七",44, 4444.44,null),
            new Employee("王五",31, 6666.6,null));

    /**
     * 用Collections.sort()方法,
     * 通过定制排序比较两个Employee(先按年龄比, 年龄相同按姓名比),使用Lambda表达式传参
     */
    @Test
    public void test01(){
        Collections.sort(employees, (e1,e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for (Employee e : employees){
            System.out.println(e);
        }
    }

    /**
     * 用于处理字符串
     */
    @Test
    public void test02(){
        String str = strHandler("abcdefghijklmn", (x) -> x.toUpperCase().substring(5,8));//1,入参 2,处理方式
        System.out.println(str);
    }

    //用于处理字符串
    public String strHandler(String str, FunStr fs){
        return fs.getValue(str);
    }

    @Test
    public void test03(){
        op(100L,200L,(x,y) -> x + y);

        op(100L,200L,(x,y) -> x * y);
    }

    //对于两个Long型的数据处理
    public void op(Long l1, Long l2, FunStr2<Long,Long> fs){
        System.out.println(fs.getValue(l1,l2));
    }


}

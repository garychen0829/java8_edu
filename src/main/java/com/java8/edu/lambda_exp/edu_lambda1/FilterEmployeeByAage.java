package com.java8.edu.lambda_exp.edu_lambda1;

/**
 * Created by garychen on 2017/11/8.
 */
public class FilterEmployeeByAage implements MyPredicate<Employee> {
    /**
     * 年龄大于30
     */
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 30 ? true : false;
    }
}

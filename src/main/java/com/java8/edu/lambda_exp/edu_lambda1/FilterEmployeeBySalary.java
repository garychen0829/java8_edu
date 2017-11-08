package com.java8.edu.lambda_exp.edu_lambda1;

/**
 * Created by garychen on 2017/11/8.
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 4000 ? true : false;
    }
}

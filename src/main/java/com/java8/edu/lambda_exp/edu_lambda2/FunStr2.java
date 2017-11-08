package com.java8.edu.lambda_exp.edu_lambda2;

/**
 * Created by garychen on 2017/11/8.
 */
@FunctionalInterface
public interface FunStr2<T, R> {

    public R getValue(T t1,T t2);
}

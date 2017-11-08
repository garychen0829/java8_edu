package com.java8.edu.lambda_exp;

/**
 * Created by garychen on 2017/11/7.
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //before 1.8
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("hello Runnable...");
            }
        };
        r1.run();

        //1.8 Lamdba
        Runnable r2 = () -> System.out.println("hello Lamdba ... ");
        r2.run();
    }
}

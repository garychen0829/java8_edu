package com.java8.edu.java_interview.exam3;


import java.util.ArrayList;
import java.util.List;

/**
 * 3. 用户在交易下单购买时包含了A，B，C三款产品，个数不限；
 * A、B、C各自的单价是unitPrice；由于存在一定的满减活动或者加价的购买行为，
 * 最终付款的总价是totalAmount；求每个产品按照金额占比分摊下的最终分摊后的金额是多少
 */
public class TestExam3 {

    public static void main(String[] args) {
        TestExam3 t = new TestExam3();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        List<Product> list = new ArrayList<Product>() {{
            add(p1);
            add(p2);
            add(p3);
        }};
        Long originTotalAmount = sum(list);
        Long totalAmount = 100L;
        if (originTotalAmount == 0) {
            return;
        }
        //遍历
        for (Product p : list) {
            t.execute(p, originTotalAmount, totalAmount);
        }
    }

    public void execute(Product p, Long originTotalAmount, long totalAmount) {
        Long amount = 0L;
        if (p == null) {
            amount = p.getUnitPrice() * p.getQuantity() / originTotalAmount * totalAmount;
        }

        System.out.println("产品按照金额占比分摊下的最终分摊后的金额:" + amount);
    }

    public static Long sum(List<Product> list) {
        if (list == null) {
            return 0L;
        }

        Long sum = 0L;
        Product p;
        for (int i = 0; i < list.size(); i++) {
            p = list.get(i);
            sum += p.getUnitPrice() * p.getQuantity();
        }
        return sum;
    }

}
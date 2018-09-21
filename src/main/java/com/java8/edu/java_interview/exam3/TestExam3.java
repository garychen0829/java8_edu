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
        Product p = new Product();
        t.execute(p);
    }

    public void execute(Product p) {
        Long totalAmount = 0L;
        List<Product> list = getAllList();
        Long amount = p.getUnitPrice() * p.getQuantity() / sum(list) * totalAmount;
        System.out.println("产品按照金额占比分摊下的最终分摊后的金额:" + amount);
    }

    private List<Product> getAllList() {
        Product pa = new Product();
        Product pb = new Product();
        Product pc = new Product();
        List<Product> list = new ArrayList<>();
        list.add(pa);
        list.add(pb);
        list.add(pc);
        return list;
    }

    public Long sum(List<Product> list) {
        Long sum = 0L;
        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);
            Long total = p.getUnitPrice() * p.getQuantity();
            sum += total;
        }
        return sum;
    }

}

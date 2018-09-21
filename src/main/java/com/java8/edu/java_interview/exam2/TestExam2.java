package com.java8.edu.java_interview.exam2;


import java.util.*;
import java.util.concurrent.*;

/**
 * 用户有多种支付方式（余额、红包、优惠券，代金券等），
 * 假如每种支付方式通过调用远程服务获取可用性。在外部资源环境不变情况下，
 * 请设计程序以最短响应时间获得尽可能多的可用支付方式列表。
 */
public class TestExam2 {
    static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("p"+i);
        }

        TestExam2 t = new TestExam2();
        List<String> resultList = t.filterDisablePayment(list);

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println("可用paymentType为 : " + resultList.get(i));
        }
        pool.shutdown();
    }


    public List<String> filterDisablePayment(List<String> allPaymentList) {
        //TODO 写出代码实现
        //计数器
        CountDownLatch latch = new CountDownLatch(allPaymentList.size());
        //返回结果list
        List<String> list = new ArrayList<>();
        try {
            //线程池submit
            List<Future> fs = new ArrayList();
            for (int i = 0; i < allPaymentList.size(); i++) {
                String paymentType = allPaymentList.get(i);
                //线程池查询
                Future future = pool.submit(new MyCallable(paymentType));
                fs.add(future);
                latch.countDown();
            }
            System.out.println("future size: " + fs.size());
            latch.await();

            for (int i = 0; i < fs.size(); i++){
                Future future = fs.get(i);

                //获取线程池返回的对象
                ThreadReturnObj threadReturnObj = (ThreadReturnObj) future.get();
                //判断 & add(s)
                ConsultResult consultResult = threadReturnObj.getConsultResult();
                if (consultResult.isEnable()) {
                    //add 可用的paymentType
                    list.add(threadReturnObj.getPaymentType());
                }
            }
        } catch (InterruptedException e) {
            //异常处理
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return list;
    }
}

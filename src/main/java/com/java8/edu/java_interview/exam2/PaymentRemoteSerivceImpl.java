package com.java8.edu.java_interview.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentRemoteSerivceImpl implements PaymentRemoteSerivce {

    List<String> list = new ArrayList();

    PaymentRemoteSerivceImpl(){
        for (int i = 0; i < 30; i++) {
            list.add("p"+i);
        }
    }

    @Override
    public ConsultResult isEnabled(String paymentType) {
        try {
            //模拟查询耗时
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i< list.size(); i++) {
            String s = list.get(i);
            if (s.equals(paymentType)) {
                ConsultResult consultResult = new ConsultResult();
                consultResult.setEnable(new Random().nextInt(3) % 2 == 1);
                consultResult.setErrorCode(String.valueOf(new Random().nextInt(100)));

                return consultResult;
            }
        }
        return null;
    }

}

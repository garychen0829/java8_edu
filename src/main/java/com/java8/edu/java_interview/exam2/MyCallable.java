package com.java8.edu.java_interview.exam2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<ThreadReturnObj> {
    //@Service 注入service
    private PaymentRemoteSerivce paymentRemoteSerivce = new PaymentRemoteSerivceImpl();

    private String paymentType;
    public MyCallable(String s) {
        this.paymentType = s;
    }

    @Override
    public ThreadReturnObj call() throws Exception {
        ThreadReturnObj threadReturnObj = new ThreadReturnObj();
        ConsultResult consultResult = paymentRemoteSerivce.isEnabled(paymentType);
        threadReturnObj.setConsultResult(consultResult);
        threadReturnObj.setPaymentType(paymentType);
        return threadReturnObj;
    }
}

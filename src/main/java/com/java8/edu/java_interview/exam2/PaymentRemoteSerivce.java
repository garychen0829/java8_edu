package com.java8.edu.java_interview.exam2;

public interface PaymentRemoteSerivce {
    //支付方式可用性咨询接口
    ConsultResult isEnabled(String paymentType);
}

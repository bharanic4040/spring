package com.bchennu.demo.exception;

public class PaymentNotProcessedException extends RuntimeException {

    public PaymentNotProcessedException(Long userId, Long orderId){
        super("Payment process failed for the user : "+userId+" and for the order : "+orderId);
    }
}

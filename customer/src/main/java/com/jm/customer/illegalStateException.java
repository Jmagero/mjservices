package com.jm.customer;

public class illegalStateException extends Throwable {
    public illegalStateException(String fraudster) {
        System.out.println(fraudster);
    }
}

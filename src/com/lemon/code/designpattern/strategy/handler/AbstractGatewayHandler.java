package com.lemon.code.designpattern.strategy.handler;

public abstract class AbstractGatewayHandler {

    /**
     * 下一关用当前抽象类来接收
     */
    protected AbstractGatewayHandler next;

    public void setNext(AbstractGatewayHandler next) {
        this.next = next;
    }

    public abstract void service();

}
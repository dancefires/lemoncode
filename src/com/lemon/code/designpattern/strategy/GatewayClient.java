package com.lemon.code.designpattern.strategy;

import com.lemon.code.designpattern.strategy.factory.GatewayHandlerFactory;
import com.lemon.code.designpattern.strategy.handler.AbstractGatewayHandler;

public class GatewayClient {

    public static void main(String[] args) {
        AbstractGatewayHandler firstAbstractGatewayHandler = GatewayHandlerFactory.getFirstGatewayHandler();
        firstAbstractGatewayHandler.service();
    }

}
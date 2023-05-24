package com.lemon.code.designpattern.strategy.factory;

import com.lemon.code.designpattern.strategy.handler.AbstractGatewayHandler;
import com.lemon.code.designpattern.strategy.init.IGateway;
import com.lemon.code.designpattern.strategy.init.impl.GatewayImpl;
import com.lemon.code.designpattern.strategy.entity.GatewayEntity;

public class GatewayHandlerFactory {

    private static final IGateway gateway = new GatewayImpl();

    // 提供静态方法，获取第一个handler
    public static AbstractGatewayHandler getFirstGatewayHandler() {
        GatewayEntity firstGatewayEntity = gateway.getFirstGatewayEntity();
        AbstractGatewayHandler firstGatewayHandler = newGatewayHandler(firstGatewayEntity);
        if (firstGatewayHandler == null) {
            return null;
        }

        GatewayEntity tempGatewayEntity = firstGatewayEntity;
        Integer nextHandlerId = null;
        AbstractGatewayHandler tempGatewayHandler = firstGatewayHandler;
        // 迭代遍历所有handler，以及将它们链接起来
        while ((nextHandlerId = tempGatewayEntity.getNextHandlerId()) != null) {
            GatewayEntity gatewayEntity = gateway.getGatewayEntity(nextHandlerId);
            AbstractGatewayHandler abstractGatewayHandler = newGatewayHandler(gatewayEntity);
            tempGatewayHandler.setNext(abstractGatewayHandler);
            tempGatewayHandler = abstractGatewayHandler;
            tempGatewayEntity = gatewayEntity;
        }
        // 返回第一个handler
        return firstGatewayHandler;
    }

    /**
     * 反射实体化具体的处理者
     * @param firstGatewayEntity
     * @return
     */
    private static AbstractGatewayHandler newGatewayHandler(GatewayEntity firstGatewayEntity) {
        // 获取全限定类名
        String className = firstGatewayEntity.getConference();
        try {
            // 根据全限定类名，加载并初始化该类，即会初始化该类的静态段
            Class<?> clazz = Class.forName(className);
            return (AbstractGatewayHandler) clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
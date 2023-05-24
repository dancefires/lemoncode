package com.lemon.code.designpattern.strategy.init;

import com.lemon.code.designpattern.strategy.entity.GatewayEntity;

public interface IGateway {

    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    GatewayEntity getGatewayEntity(Integer handlerId);

    /**
     * 获取第一个处理者
     * @return
     */
    GatewayEntity getFirstGatewayEntity();

}
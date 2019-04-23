package com.example.demo.service;


import com.aliyun.openservices.ons.api.SendResult;
import com.wpj.spring.boot.rocketmq.starter.annotation.MessageSender;
import com.wpj.spring.boot.rocketmq.starter.annotation.ProducerChannel;

import java.util.Map;

/**
 * @auther wangpejian
 * @date 19-4-1 下午4:44
 */
@ProducerChannel("p2")
public interface TestProducerOrder {

    @MessageSender
    SendResult sendTest(Map msg, String shardingKey);

}

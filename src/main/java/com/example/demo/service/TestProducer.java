package com.example.demo.service;


import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.wpj.spring.boot.rocketmq.starter.annotation.MessageSender;
import com.wpj.spring.boot.rocketmq.starter.annotation.ProducerChannel;
import com.wpj.spring.boot.rocketmq.starter.annotation.enums.MessageType;

import java.util.Map;

/**
 * 定义生产者接口，接口中的方法参数要和 @MessageSender 注解定义的方法类型，匹配
 *
 * @auther wangpejian
 * @date 19-4-22 下午4:37
 */
@ProducerChannel("p1")
public interface TestProducer {

    /**
     * 普通消息发送
     * <p>
     * 消息对象可以是任意类型
     */
    @MessageSender
    SendResult sendNormal(Map msg);

    @MessageSender(MessageType.async)
    SendResult sendAsync(Map msg, final SendCallback sendCallback);

    @MessageSender(MessageType.oneway)
    SendResult sendOneway(Object msg);


    /**
     * 消息添加延时
     * <p>
     * timeStamp = 希望消息发送的时刻的时间戳
     */
    @MessageSender
    SendResult sendNormalDelay(Map msg, long timeStamp);

    @MessageSender(MessageType.async)
    SendResult sendAsyncDelay(Map msg, final SendCallback sendCallback, long timeStamp);

    @MessageSender(MessageType.oneway)
    SendResult sendOnewayDelay(Object msg, long timeStamp);
}

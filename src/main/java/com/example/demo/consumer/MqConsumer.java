package com.example.demo.consumer;


import com.wpj.spring.boot.rocketmq.starter.annotation.MonitorEnable;
import com.wpj.spring.boot.rocketmq.starter.annotation.MonitorRocketMsg;
import com.wpj.spring.boot.rocketmq.starter.message.ResponseMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@MonitorEnable
public class MqConsumer {

    /**
     * 注册消费者
     * <p>
     * ResponseMessage<T>,为响应结果的泛型
     * 消费者中再使用生产者需要注入生产者工厂
     *
     * @param message
     * @Autowired ChannelRepertory channelRepertory;
     */

    @MonitorRocketMsg("c1")
    public void ConsumerTest(ResponseMessage<Map> message) {
        log.info("========普通消息接受: {}", message.getBody());
    }

    @MonitorRocketMsg("c2")
    public void ConsumerTest2(ResponseMessage<Map> message) {
        log.info("========顺序消息接受: {}", message.getBody());
    }

    @MonitorRocketMsg("c3")
    public void ConsumerTest3(ResponseMessage<Map> message) {
        log.info("========事务消息接受: {}", message.getBody());
    }
}

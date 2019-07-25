package com.example.demo.controller;

import com.aliyun.openservices.ons.api.transaction.TransactionStatus;
import com.example.demo.service.TestProducer;
import com.wpj.spring.boot.rocketmq.starter.channel.ChannelNormal;
import com.wpj.spring.boot.rocketmq.starter.channel.ChannelOrder;
import com.wpj.spring.boot.rocketmq.starter.channel.ChannelTransaction;
import com.wpj.spring.boot.rocketmq.starter.repertory.ChannelRepertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangpejian
 * @date 19-4-22 下午4:23
 */
@RestController()
@RequestMapping("/test")
public class TestController {

    // 使用接口方式调用
    @Autowired
    TestProducer testProducer;

    // 从生产者仓库获取
    @Autowired
    ChannelRepertory channelRepertory;

    // 直接注入仓库中的生产者
    @Autowired
    ChannelNormal p1;

    //顺序消息生产者
    @Autowired
    ChannelOrder p2;

    //事务消息生产者
    @Autowired
    ChannelTransaction p3;

    /**
     * 普通消息发送
     * <p>
     * 包含三种使用方式
     */
    @RequestMapping("/normal")
    void normal() {

        Map<String, String> msg = new HashMap<>();
        msg.put("title", "测试消息");
        msg.put("content", "其他内容");

        //三种发送方式
        testProducer.sendNormal(msg);
//        channelRepertory.getChannelNormal("p1").send(msg);
//        p1.send(msg);
    }

    /**
     * 顺序消息发送
     * <p>
     * 包含三种使用方式
     */
    @RequestMapping("/order")
    void order() {

        Map<String, String> msg = new HashMap<>();
        msg.put("title", "测试消息");
        msg.put("content", "其他内容");

        testProducer.sendOrder(msg, "test");
//        channelRepertory.getChannelOrder("p2").send(msg, "test");
//        p2.send(msg, "test");
    }

    /**
     * 事务消息发送
     * <p>
     * 包含三种使用方式
     * <p>
     * 发送事务消息需要定义checker，本项目checker在
     * package com.example.demo.checker 包中
     */
    @RequestMapping("/transaction")
    void transaction() {

        Map<String, String> msg = new HashMap<>();
        msg.put("title", "测试消息");
        msg.put("content", "其他内容");

        testProducer.sendTransaction(msg, (msg1, arg) -> TransactionStatus.Unknow, new Object());
//        channelRepertory.getChannelTransaction("p3").send(msg, (msg1, arg) -> TransactionStatus.Unknow, new Object());
//        p3.send(msg, (msg1, arg) -> TransactionStatus.Unknow, new Object());
    }
}

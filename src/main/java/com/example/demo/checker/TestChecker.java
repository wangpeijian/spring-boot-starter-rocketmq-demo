package com.example.demo.checker;


import com.aliyun.openservices.ons.api.transaction.TransactionStatus;
import com.wpj.spring.boot.rocketmq.starter.message.ResponseMessage;
import com.wpj.spring.boot.rocketmq.starter.repertory.ChannelRepertory;
import com.wpj.spring.boot.rocketmq.starter.transaction.checker.AbstractChecker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 事务消息的checker注册
 *
 * @auther wangpejian
 * @date 19-2-14 上午10:38
 */
@Slf4j
@Component
public class TestChecker extends AbstractChecker {


    final private ChannelRepertory channelRepertory;

    public TestChecker(ChannelRepertory channelRepertory) {
        this.channelRepertory = channelRepertory;
    }

    /**
     * 返回当前checker是属于哪一个消费者的
     *
     * @return
     */
    @Override
    public String getChannelName() {
        return "p3";
    }


    @Override
    public TransactionStatus check(final ResponseMessage msg) {
        log.info("========事务消息check: {}, id: {}", msg.getBody());

        log.info("channelRepertory.getChannel(p1): {}", channelRepertory.getChannelNormal("p1"));

        return TransactionStatus.CommitTransaction;
    }
}

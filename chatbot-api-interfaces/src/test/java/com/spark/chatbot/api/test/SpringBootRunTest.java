package com.spark.chatbot.api.test;

import com.alibaba.fastjson.JSON;
import com.spark.chatbot.api.domain.zsxq.IZsxqApi;
import com.spark.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.spark.chatbot.api.domain.zsxq.model.vo.Talk;
import com.spark.chatbot.api.domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger  = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Autowired
    private IZsxqApi zsxqApi;

    @Test
    public void test_query_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            Talk talk = topic.getTalk();
            String text = talk.getText();
            logger.info("topicId：{}", topicId);
            logger.info("问题：{}", text);
        }
    }
}

package org.kafka.smoke;

import org.kafka.smoke.bootstrap.KafkaConsumptionApplication;
import org.kafka.smoke.consumer.Consumer;
import org.kafka.smoke.producer.Producer;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Stepan Pogosyan
 * @since 21.12.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaConsumptionApplication.class)
public class ConsumptionTest {

    private final static String TOPIC = "source_entities_topic";

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    Producer producer;

    @Autowired
    Consumer consumer;

    @ClassRule
    public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true, TOPIC);

    @Before
    public void runBeforeTestMethod() throws Exception {
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
                .getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer,
                    kafkaEmbedded.getPartitionsPerTopic());
        }
    }

    @Test
    public void testConsumption() {
        producer.produce(TOPIC, "Hello, i am a test message!");
    }
}

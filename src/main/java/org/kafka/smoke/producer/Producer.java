package org.kafka.smoke.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Stepan Pogosyan
 * @since 21.12.2017.
 */
@Slf4j
@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String topic, String payload) {
        log.info("Produced payload: {}", payload);
        kafkaTemplate.send(topic, payload);
    }
}

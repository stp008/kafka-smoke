package org.kafka.smoke.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Stepan Pogosyan
 * @since 21.12.2017.
 */
@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(String payload) {
        log.info("Consumed payload: {}", payload);
    }
}

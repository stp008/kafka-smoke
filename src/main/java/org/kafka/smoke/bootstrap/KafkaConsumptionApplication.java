package org.kafka.smoke.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Stepan Pogosyan
 * @since 21.12.2017.
 */
@SpringBootApplication(scanBasePackages = "org.kafka.smoke")
public class KafkaConsumptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumptionApplication.class, args);
    }

}

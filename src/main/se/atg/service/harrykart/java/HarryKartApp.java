package se.atg.service.harrykart.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class HarryKartApp {
    public static void main(String... args) {
        SpringApplication.run(HarryKartApp.class, args);
    }
}

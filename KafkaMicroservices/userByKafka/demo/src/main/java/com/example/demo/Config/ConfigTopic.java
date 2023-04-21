package com.example.demo.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ConfigTopic {

    @Bean
    public NewTopic javaTaskTopic(){
        return TopicBuilder.name("order")
                .build();
    }
}





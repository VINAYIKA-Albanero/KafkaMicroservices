package com.example.demo.Config;

import com.example.demo.Model.OrderModel;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
@Configuration
public class TopicConfig {
    @Bean
        public NewTopic javaTopic(){
            return TopicBuilder.name("Bill")
                    .build();
        }
        @Bean
        public ConsumerFactory<String, OrderModel> consumerFactory()
        {

            // Creating a map of string-object type
            Map<String, Object> config = new HashMap<>();

            // Adding the Configuration
            config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                    "127.0.0.1:9092");
            config.put(ConsumerConfig.GROUP_ID_CONFIG,
                    "group_id");
            config.put(
                    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                    StringDeserializer.class);
            config.put(
                    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                    JsonDeserializer.class);

            // Returning message in JSON format
            return new DefaultKafkaConsumerFactory<>(
                    config, new StringDeserializer(),
                    new JsonDeserializer<>(OrderModel.class));
        }

        // Creating a Listener
        @Bean
        public ConcurrentKafkaListenerContainerFactory<String,
                OrderModel>
        orderListener()
        {
            ConcurrentKafkaListenerContainerFactory<
                    String, OrderModel> factory
                    = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());

            return factory;
        }
    }




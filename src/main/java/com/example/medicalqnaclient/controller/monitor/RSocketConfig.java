//package com.example.medicalqnaclient.controller.monitor;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.PropertyNamingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.codec.json.Jackson2JsonDecoder;
//import org.springframework.http.codec.json.Jackson2JsonEncoder;
//import org.springframework.messaging.rsocket.RSocketRequester;
//import org.springframework.messaging.rsocket.RSocketStrategies;
//import org.springframework.messaging.rsocket.annotation.support.RSocketMessageHandler;
//
//@Configuration
//public class RSocketConfig {
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//        return mapper;
//    }
//
//    @Bean
//    public RSocketStrategies rSocketStrategies(ObjectMapper objectMapper) {
//        return RSocketStrategies.builder()
//                .decoder(new Jackson2JsonDecoder(objectMapper))
//                .encoder(new Jackson2JsonEncoder(objectMapper))
//                .build();
//    }
//
//    @Bean
//    public RSocketMessageHandler messageHandler(RSocketStrategies rSocketStrategies) {
//        RSocketMessageHandler handler = new RSocketMessageHandler();
//        handler.setRSocketStrategies(rSocketStrategies);
//        return handler;
//    }
//
//    @Bean
//    public RSocketRequester.Builder rSocketRequesterBuilder(RSocketStrategies rSocketStrategies) {
//        return RSocketRequester.builder().rsocketStrategies(rSocketStrategies);
//    }
//}
module com.example.medicalqnaclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires rsocket.core;
    requires rsocket.transport.netty;
    requires reactor.core;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;
    requires spring.messaging;

    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires spring.web;
    requires com.example.medicalqnaclient.page.core;

    // spring 빈 생성하기 위해서 exports와 opens 설정하기
    requires com.example.medicalqnaclient.domain.application;
    requires com.example.medicalqnaclient.domain.log;
    requires com.example.medicalqnaclient.domain.resource;
    requires com.example.medicalqnaclient.domain.test;

    // 루트 패키지
    exports com.example.medicalqnaclient;
    opens com.example.medicalqnaclient to spring.core;
}
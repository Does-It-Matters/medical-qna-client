module com.example.medicalqnaclient.domain.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

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

    // test 도메인
    // - page
    exports com.example.medicalqnaclient.domain.test.page.navigator;
    exports com.example.medicalqnaclient.domain.test.page.pages;
    exports com.example.medicalqnaclient.domain.test.page.pages.start;
    exports com.example.medicalqnaclient.domain.test.page.pages.start.basic;
}
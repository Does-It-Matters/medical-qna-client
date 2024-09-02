module com.example.medicalqnaclient.domain.log {
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

    requires com.example.medicalqnaclient.utils;
    requires com.example.medicalqnaclient.page.core;

    // log 도메인
    // - page
    exports com.example.medicalqnaclient.domain.log.page.event;
    exports com.example.medicalqnaclient.domain.log.page.navigator;
    exports com.example.medicalqnaclient.domain.log.page.pages.home;
    exports com.example.medicalqnaclient.domain.log.page.pages.home.temp;
    opens com.example.medicalqnaclient.domain.log.page.pages.home.temp to spring.core;
    exports com.example.medicalqnaclient.domain.log.page.pages.start;
    exports com.example.medicalqnaclient.domain.log.page.pages.start.basic;
}
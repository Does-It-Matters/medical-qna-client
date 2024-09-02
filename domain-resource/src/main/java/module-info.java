module com.example.medicalqnaclient.domain.resource {
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

    // resource 도메인
    // - page
    exports com.example.medicalqnaclient.domain.resource.page.navigator;
    exports com.example.medicalqnaclient.domain.resource.page.pages.start;
    exports com.example.medicalqnaclient.domain.resource.page.pages.start.basic;
}
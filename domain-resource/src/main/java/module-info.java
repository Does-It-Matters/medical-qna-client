module com.example.medicalqnaclient.domain.resource {
    requires javafx.controls;

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

    exports com.example.medicalqnaclient.domain.resource.page.event;
    exports com.example.medicalqnaclient.domain.resource.page.navigator;

    exports com.example.medicalqnaclient.domain.resource.page.pages.start;
    exports com.example.medicalqnaclient.domain.resource.page.pages.start.basic;
    exports com.example.medicalqnaclient.domain.resource.page.pages.home;
    exports com.example.medicalqnaclient.domain.resource.page.pages.home.cpu;
    opens com.example.medicalqnaclient.domain.resource.page.pages.home.cpu to spring.core;
}
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

    // log 도메인
    // - page
    exports com.example.medicalqnaclient.domain.log.page.event;
    exports com.example.medicalqnaclient.domain.log.page.navigator;
    exports com.example.medicalqnaclient.domain.log.page.pages.home;
    exports com.example.medicalqnaclient.domain.log.page.pages.home.temp;
    opens com.example.medicalqnaclient.domain.log.page.pages.home.temp to spring.core;
    exports com.example.medicalqnaclient.domain.log.page.pages.start;
    exports com.example.medicalqnaclient.domain.log.page.pages.start.basic;

    // resource 도메인
    // - page
    exports com.example.medicalqnaclient.domain.resource.page.navigator;
    exports com.example.medicalqnaclient.domain.resource.page.pages.start;
    exports com.example.medicalqnaclient.domain.resource.page.pages.start.basic;

    // test 도메인
    // - page
    exports com.example.medicalqnaclient.domain.test.page.navigator;
    exports com.example.medicalqnaclient.domain.test.page.pages;
    exports com.example.medicalqnaclient.domain.test.page.pages.start;
    exports com.example.medicalqnaclient.domain.test.page.pages.start.basic;

    // 루트 패키지
    exports com.example.medicalqnaclient;
    opens com.example.medicalqnaclient to spring.core;
}
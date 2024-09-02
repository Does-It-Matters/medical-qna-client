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
    requires com.example.medicalqnaclient.utils;
    requires com.example.medicalqnaclient.page.core;

    // spring 빈 생성하기 위해서 exports와 opens 설정하기

    // application 도메인
    // - mediator
    exports com.example.medicalqnaclient.domain.application.mediator.state.factory;
    opens com.example.medicalqnaclient.domain.application.mediator.state.factory to spring.core;
    exports com.example.medicalqnaclient.domain.application.mediator;

    // - network
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.question.delete to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.question.edit to com.fasterxml.jackson.databind;
    opens com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.question.read to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.signup.common to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.signup.patient to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.signup.doctor to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.tasks.user.login to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.domain.application.network.server.url;
    exports com.example.medicalqnaclient.domain.application.network.server;

    // - page
    exports com.example.medicalqnaclient.domain.application.page.event;
    exports com.example.medicalqnaclient.domain.application.page.navigator;
    exports com.example.medicalqnaclient.domain.application.page.pages.home;
    exports com.example.medicalqnaclient.domain.application.page.pages.home.log.in;
    exports com.example.medicalqnaclient.domain.application.page.pages.home.log.out;
    exports com.example.medicalqnaclient.domain.application.page.pages.login;
    exports com.example.medicalqnaclient.domain.application.page.pages.login.basic;
    exports com.example.medicalqnaclient.domain.application.page.pages.profile;
    exports com.example.medicalqnaclient.domain.application.page.pages.profile.basic;
    exports com.example.medicalqnaclient.domain.application.page.pages.question;
    exports com.example.medicalqnaclient.domain.application.page.pages.question.basic;
    exports com.example.medicalqnaclient.domain.application.page.pages.signup.doctor;
    exports com.example.medicalqnaclient.domain.application.page.pages.signup.doctor.basic;
    exports com.example.medicalqnaclient.domain.application.page.pages.signup.patient;
    exports com.example.medicalqnaclient.domain.application.page.pages.signup.patient.basic;
    exports com.example.medicalqnaclient.domain.application.page.pages.start;
    exports com.example.medicalqnaclient.domain.application.page.pages.start.basic;

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
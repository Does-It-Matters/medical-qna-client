module com.example.medicalqnaclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
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

    // spring 빈 생성하기 위해서 exports와 opens 둘 다 설정하기

    // 페이지 계층 시작
    // page.application 계층
    exports com.example.medicalqnaclient.page.application;
    exports com.example.medicalqnaclient.page.application.event;
    exports com.example.medicalqnaclient.page.application.pages.home;
    exports com.example.medicalqnaclient.page.application.pages.home.log.in;
    exports com.example.medicalqnaclient.page.application.pages.home.log.out;
    exports com.example.medicalqnaclient.page.application.pages.login;
    exports com.example.medicalqnaclient.page.application.pages.login.basic;
    exports com.example.medicalqnaclient.page.application.pages.profile;
    exports com.example.medicalqnaclient.page.application.pages.profile.basic;
    exports com.example.medicalqnaclient.page.application.pages.question;
    exports com.example.medicalqnaclient.page.application.pages.question.basic;
    exports com.example.medicalqnaclient.page.application.pages.signup.doctor;
    exports com.example.medicalqnaclient.page.application.pages.signup.doctor.basic;
    exports com.example.medicalqnaclient.page.application.pages.signup.patient;
    exports com.example.medicalqnaclient.page.application.pages.signup.patient.basic;
    exports com.example.medicalqnaclient.page.application.pages.start;
    exports com.example.medicalqnaclient.page.application.pages.start.basic;
    // page.log 계층
    exports com.example.medicalqnaclient.page.log;
    exports com.example.medicalqnaclient.page.log.event;
    exports com.example.medicalqnaclient.page.log.pages;
    exports com.example.medicalqnaclient.page.log.pages.home;
    exports com.example.medicalqnaclient.page.log.pages.home.temp;
    opens com.example.medicalqnaclient.page.log.pages.home.temp to spring.core;
    exports com.example.medicalqnaclient.page.log.pages.start;
    exports com.example.medicalqnaclient.page.log.pages.start.basic;
    // page.resource 계층
    exports com.example.medicalqnaclient.page.resource;
    exports com.example.medicalqnaclient.page.resource.pages.start;
    exports com.example.medicalqnaclient.page.resource.pages.start.basic;
    // page.test 계층
    exports com.example.medicalqnaclient.page.test;
    exports com.example.medicalqnaclient.page.test.pages.start;
    exports com.example.medicalqnaclient.page.test.pages.start.basic;
    // page.util 계층
    exports com.example.medicalqnaclient.page.util;
    //  페이지 계층 끝

    // 서버 계층 시작
    exports com.example.medicalqnaclient.server.application.tasks.question.delete to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.question.edit to com.fasterxml.jackson.databind;
    opens com.example.medicalqnaclient.server.application.tasks.question.enroll to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.question.read to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.questionlist to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.signup.common to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.signup.patient to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.signup.doctor to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.application.tasks.user.login to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.utils.url;
    exports com.example.medicalqnaclient.server.application;
    // 서버 계층 끝

    // 유저 계층 시작
    exports com.example.medicalqnaclient.user.mediator;
    exports com.example.medicalqnaclient.user.state.factory;
    opens com.example.medicalqnaclient.user.state.factory to spring.core;
    // 유저 계층 끝

    exports com.example.medicalqnaclient;
    opens com.example.medicalqnaclient to spring.core;
}
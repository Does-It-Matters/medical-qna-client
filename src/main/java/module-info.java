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
//    exports com.example.medicalqnaclient.server.facade.tasks.question.read;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.enroll;
//    exports com.example.medicalqnaclient.server.facade.tasks.questionlist to com.fasterxml.jackson.databind;
//    opens com.example.medicalqnaclient.server.facade.tasks.question.enroll to com.fasterxml.jackson.databind;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.edit;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.delete;

    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.server.facade;

    exports com.example.medicalqnaclient.server.facade.tasks.user.login;

    exports com.example.medicalqnaclient.server.facade.tasks.signup.common to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.facade.tasks.signup.patient to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.facade.tasks.signup.doctor to com.fasterxml.jackson.databind;

    opens com.example.medicalqnaclient.user.mediator to spring.core;
    opens com.example.medicalqnaclient to javafx.fxml, spring.core;

    // spring 빈 생성하기 위해서 exports와 opens 둘 다 설정하기
    exports com.example.medicalqnaclient.page.pages.start;
    opens com.example.medicalqnaclient.page.pages.start to spring.core;

    exports com.example.medicalqnaclient.page.pages.home;
    opens com.example.medicalqnaclient.page.pages.home to spring.core;

    exports com.example.medicalqnaclient.page.pages.login;
    opens com.example.medicalqnaclient.page.pages.login to spring.core;

    exports com.example.medicalqnaclient.page.pages.login.basic;
    opens com.example.medicalqnaclient.page.pages.login.basic to spring.core;

    exports com.example.medicalqnaclient.page.pages.sign.up.doctor;
    opens com.example.medicalqnaclient.page.pages.sign.up.doctor to spring.core;
    exports com.example.medicalqnaclient.page.pages.sign.up.doctor.basic;
    opens com.example.medicalqnaclient.page.pages.sign.up.doctor.basic to spring.core;

    exports com.example.medicalqnaclient.page.pages.sign.up.patient;
    opens com.example.medicalqnaclient.page.pages.sign.up.patient to spring.core;
    exports com.example.medicalqnaclient.page.pages.sign.up.patient.basic;
    opens com.example.medicalqnaclient.page.pages.sign.up.patient.basic to spring.core;

    exports com.example.medicalqnaclient.page.pages.profile;
    opens com.example.medicalqnaclient.page.pages.profile to spring.core;
    exports com.example.medicalqnaclient.page.pages.profile.basic;
    opens com.example.medicalqnaclient.page.pages.profile.basic to spring.core;

    exports com.example.medicalqnaclient.page.pages.question;
    opens com.example.medicalqnaclient.page.pages.question to spring.core;
    exports com.example.medicalqnaclient.page.pages.question.basic;
    opens com.example.medicalqnaclient.page.pages.question.basic to spring.core;

    exports com.example.medicalqnaclient.user.state;
    opens com.example.medicalqnaclient.user.state to spring.core;

    exports com.example.medicalqnaclient.user.state.factory;
    opens com.example.medicalqnaclient.user.state.factory to spring.core;
    exports com.example.medicalqnaclient.page.pages.home.log.in;
    opens com.example.medicalqnaclient.page.pages.home.log.in to spring.core;
    exports com.example.medicalqnaclient.page.pages.home.log.out;
    opens com.example.medicalqnaclient.page.pages.home.log.out to spring.core;
    exports com.example.medicalqnaclient.page.pages.start.basic;
    opens com.example.medicalqnaclient.page.pages.start.basic to spring.core;
    exports com.example.medicalqnaclient.page.core;
    opens com.example.medicalqnaclient.page.core to spring.core;
    exports com.example.medicalqnaclient.page.manager.application.qna;
    opens com.example.medicalqnaclient.page.manager.application.qna to spring.core;
    exports com.example.medicalqnaclient.page.manager.monitor.log;
    opens com.example.medicalqnaclient.page.manager.monitor.log to spring.core;
    exports com.example.medicalqnaclient.page.manager.monitor.system;
    opens com.example.medicalqnaclient.page.manager.monitor.system to spring.core;
    exports com.example.medicalqnaclient.page.event.events;
    opens com.example.medicalqnaclient.page.event.events to spring.core;
    exports com.example.medicalqnaclient.page.event.listeners;
    opens com.example.medicalqnaclient.page.event.listeners to spring.core;
    exports com.example.medicalqnaclient.page.event.publishers;
    opens com.example.medicalqnaclient.page.event.publishers to spring.core;

//    opens com.example.medicalqnaclient.controller.monitor to spring.core;
//    exports com.example.medicalqnaclient.controller.monitor;
//    exports com.example.medicalqnaclient.controller.qna;

    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires spring.web;
}
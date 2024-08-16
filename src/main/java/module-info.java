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
//    exports com.example.medicalqnaclient.server.facade.tasks.user.login;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.read;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.enroll;
//    exports com.example.medicalqnaclient.server.facade.tasks.questionlist to com.fasterxml.jackson.databind;
//    opens com.example.medicalqnaclient.server.facade.tasks.question.enroll to com.fasterxml.jackson.databind;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.edit;
//    exports com.example.medicalqnaclient.server.facade.tasks.question.delete;

    exports com.example.medicalqnaclient.page;
    exports com.example.medicalqnaclient;
//    exports com.example.medicalqnaclient.controller;
//    exports com.example.medicalqnaclient.server.facade.tasks.signup.common to com.fasterxml.jackson.databind;
//    exports com.example.medicalqnaclient.server.facade.tasks.signup.patient to com.fasterxml.jackson.databind;
//    exports com.example.medicalqnaclient.server.facade.tasks.signup.doctor to com.fasterxml.jackson.databind;
    opens com.example.medicalqnaclient.user.mediator to spring.core;
    opens com.example.medicalqnaclient to javafx.fxml, spring.core;
    opens com.example.medicalqnaclient.page to spring.core;

    // spring 빈 생성하기 위해서 exports와 opens 둘 다 설정하기
    exports com.example.medicalqnaclient.page.start;
    opens com.example.medicalqnaclient.page.start to spring.core;

    exports com.example.medicalqnaclient.page.qna;
    opens com.example.medicalqnaclient.page.qna to spring.core;

    exports com.example.medicalqnaclient.user.state;
    opens com.example.medicalqnaclient.user.state to spring.core;

    exports com.example.medicalqnaclient.user.state.factory;
    opens com.example.medicalqnaclient.user.state.factory to spring.core;

//    opens com.example.medicalqnaclient.controller.monitor to spring.core;
//    exports com.example.medicalqnaclient.controller.monitor;
//    exports com.example.medicalqnaclient.controller.qna;

    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires spring.web;
}
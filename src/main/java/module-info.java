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
    exports com.example.medicalqnaclient.server.facade.tasks.user.login;
    exports com.example.medicalqnaclient.server.facade.tasks.question.read;
    exports com.example.medicalqnaclient.server.facade.tasks.question.enroll;
    exports com.example.medicalqnaclient.server.facade.tasks.questionlist to com.fasterxml.jackson.databind;
    opens com.example.medicalqnaclient.server.facade.tasks.question.enroll to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.facade.tasks.question.edit;
    exports com.example.medicalqnaclient.server.facade.tasks.question.delete;

    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.controller;
    opens com.example.medicalqnaclient.controller to javafx.fxml;
    exports com.example.medicalqnaclient.server.facade.tasks.signup.common to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.facade.tasks.signup.patient to com.fasterxml.jackson.databind;
    exports com.example.medicalqnaclient.server.facade.tasks.signup.doctor to com.fasterxml.jackson.databind;
    opens com.example.medicalqnaclient.user.state to spring.core;
    opens com.example.medicalqnaclient.user.meditator to spring.core;
    opens com.example.medicalqnaclient to javafx.fxml, spring.core;

    requires org.slf4j;
    requires ch.qos.logback.classic;
}
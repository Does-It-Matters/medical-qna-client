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
    exports com.example.medicalqnaclient.v1.out.network.user.requests.responses;
    exports com.example.medicalqnaclient.v1.businesslogic.user;
    exports com.example.medicalqnaclient.v1.businesslogic.question;

//    opens com.example.medicalqnaclient to javafx.fxml;
    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.controller;
//    opens com.example.medicalqnaclient.controller to javafx.fxml;
    opens com.example.medicalqnaclient.user.state to spring.core;
    opens com.example.medicalqnaclient.user.meditator to spring.core;
    opens com.example.medicalqnaclient to javafx.fxml, spring.core;
    opens com.example.medicalqnaclient.controller to javafx.fxml, spring.core;

    requires org.slf4j;
    requires ch.qos.logback.classic;
}
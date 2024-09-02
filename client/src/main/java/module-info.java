module com.example.medicalqnaclient {
    requires javafx.controls;

    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;

    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires com.example.medicalqnaclient.page.core;
    requires com.example.medicalqnaclient.domain.application;
    requires com.example.medicalqnaclient.domain.log;
    requires com.example.medicalqnaclient.domain.resource;
    requires com.example.medicalqnaclient.domain.test;

    // 루트 패키지
    exports com.example.medicalqnaclient;
    opens com.example.medicalqnaclient to spring.core;
}
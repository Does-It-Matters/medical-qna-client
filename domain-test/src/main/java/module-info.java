module com.example.medicalqnaclient.domain.test {
    requires javafx.controls;

    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;

    requires org.slf4j;
    requires ch.qos.logback.classic;

    requires com.example.medicalqnaclient.page.core;
    requires java.net.http;

    exports com.example.medicalqnaclient.domain.test.page.event;
    exports com.example.medicalqnaclient.domain.test.page.navigator;

    exports com.example.medicalqnaclient.domain.test.page.pages;
    exports com.example.medicalqnaclient.domain.test.page.pages.start;
    exports com.example.medicalqnaclient.domain.test.page.pages.start.basic;
    exports com.example.medicalqnaclient.domain.test.page.pages.home;
    exports com.example.medicalqnaclient.domain.test.page.pages.home.load.test;
}
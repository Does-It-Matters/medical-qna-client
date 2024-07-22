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
    exports com.example.medicalqnaclient.v1.out.network.user.requests.responses;
    exports com.example.medicalqnaclient.v1.businesslogic.user;
    exports com.example.medicalqnaclient.v1.businesslogic.question;

    opens com.example.medicalqnaclient to javafx.fxml;
    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.controller;
    opens com.example.medicalqnaclient.controller to javafx.fxml;
}
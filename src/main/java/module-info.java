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
    exports com.example.medicalqnaclient.v1.controllers;
    opens com.example.medicalqnaclient.v1.controllers to javafx.fxml;
    exports com.example.medicalqnaclient.v1.controllers.user.login;
    opens com.example.medicalqnaclient.v1.controllers.user.login to javafx.fxml;
    exports com.example.medicalqnaclient.v1.controllers.post;
    opens com.example.medicalqnaclient.v1.controllers.post to javafx.fxml;
    exports com.example.medicalqnaclient.v1.controllers.admin;
    opens com.example.medicalqnaclient.v1.controllers.admin to javafx.fxml;
    exports com.example.medicalqnaclient.v1.controllers.board;
    opens com.example.medicalqnaclient.v1.controllers.board to javafx.fxml;
    exports com.example.medicalqnaclient.v1.controllers.user.signup;
    opens com.example.medicalqnaclient.v1.controllers.user.signup to javafx.fxml;
    exports com.example.medicalqnaclient.v1.controllers.user.mydata;
    opens com.example.medicalqnaclient.v1.controllers.user.mydata to javafx.fxml;
}
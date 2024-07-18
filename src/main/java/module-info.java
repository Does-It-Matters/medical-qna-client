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
    exports com.example.medicalqnaclient.out.network.user.requests.responses;
    exports com.example.medicalqnaclient.businesslogic.user;

    opens com.example.medicalqnaclient to javafx.fxml;
    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.controllers;
    opens com.example.medicalqnaclient.controllers to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.user.login;
    opens com.example.medicalqnaclient.controllers.user.login to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.post;
    opens com.example.medicalqnaclient.controllers.post to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.admin;
    opens com.example.medicalqnaclient.controllers.admin to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.board;
    opens com.example.medicalqnaclient.controllers.board to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.user.signup;
    opens com.example.medicalqnaclient.controllers.user.signup to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.user.mydata;
    opens com.example.medicalqnaclient.controllers.user.mydata to javafx.fxml;
}
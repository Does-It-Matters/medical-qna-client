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
    exports com.example.medicalqnaclient.utils.out.network.user.requests.responses;
    exports com.example.medicalqnaclient.utils.businesslogic.user;
    exports com.example.medicalqnaclient.utils.businesslogic.question;

    opens com.example.medicalqnaclient to javafx.fxml;
    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.utils.controllers;
    opens com.example.medicalqnaclient.utils.controllers to javafx.fxml;
    exports com.example.medicalqnaclient.utils.controllers.user.login;
    opens com.example.medicalqnaclient.utils.controllers.user.login to javafx.fxml;
    exports com.example.medicalqnaclient.utils.controllers.post;
    opens com.example.medicalqnaclient.utils.controllers.post to javafx.fxml;
    exports com.example.medicalqnaclient.utils.controllers.admin;
    opens com.example.medicalqnaclient.utils.controllers.admin to javafx.fxml;
    exports com.example.medicalqnaclient.utils.controllers.board;
    opens com.example.medicalqnaclient.utils.controllers.board to javafx.fxml;
    exports com.example.medicalqnaclient.utils.controllers.user.signup;
    opens com.example.medicalqnaclient.utils.controllers.user.signup to javafx.fxml;
    exports com.example.medicalqnaclient.utils.controllers.user.mydata;
    opens com.example.medicalqnaclient.utils.controllers.user.mydata to javafx.fxml;
}
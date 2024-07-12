module com.example.medicalqnaclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.example.medicalqnaclient to javafx.fxml;
    exports com.example.medicalqnaclient;
    exports com.example.medicalqnaclient.controllers;
    opens com.example.medicalqnaclient.controllers to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.all;
    opens com.example.medicalqnaclient.controllers.all to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.user;
    opens com.example.medicalqnaclient.controllers.user to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.patient;
    opens com.example.medicalqnaclient.controllers.patient to javafx.fxml;
    exports com.example.medicalqnaclient.controllers.admin;
    opens com.example.medicalqnaclient.controllers.admin to javafx.fxml;
}
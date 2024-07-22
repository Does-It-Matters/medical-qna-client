package com.example.medicalqnaclient;

import com.example.medicalqnaclient.user.state.Start;
import com.example.medicalqnaclient.user.state.UserContainer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        final String TITLE = "My Health Block";
        final Start application = new UserContainer(stage, TITLE);
        application.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
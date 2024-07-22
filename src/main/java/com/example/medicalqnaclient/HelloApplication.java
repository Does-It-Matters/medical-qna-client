package com.example.medicalqnaclient;

import com.example.medicalqnaclient.user.meditator.Start;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        final Start application = UserMeditatorImpl.getInstance();
        application.start(stage, "My Health Block", 900, 600);
    }

    public static void main(String[] args) {
        launch();
    }
}
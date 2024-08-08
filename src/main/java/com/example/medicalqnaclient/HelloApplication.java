package com.example.medicalqnaclient;

import com.example.medicalqnaclient.user.mediator.Start;
import com.example.medicalqnaclient.user.state.UserMediatorImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HelloApplication extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        try {
            context = new SpringApplicationBuilder(HelloApplication.class).run();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Spring context", e);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
//        UserMediatorImpl mediator = context.getBean(UserMediatorImpl.class);
        final Start application = UserMediatorImpl.getInstance();
        application.start(stage, "My Health Block", 900, 600);
    }


    @Override
    public void stop() throws Exception {
        context.close();
    }

    public static void main(String[] args) {

        launch();
    }
}
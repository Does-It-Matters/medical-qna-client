package com.example.medicalqnaclient;

import com.example.medicalqnaclient.user.meditator.Start;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

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
//        UserMeditatorImpl userMeditator = context.getBean(UserMeditatorImpl.class);
        final Start application = UserMeditatorImpl.getInstance();
        application.start(stage, "My Health Block", 900, 600);
    }


    @Override
    public void stop() throws Exception {
        context.close();
    }

    public static void main(String[] args) {
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "default");
        System.setProperty("spring.rsocket.server.enabled", "false");

        launch();
    }
}
package com.example.medicalqnaclient;

import com.example.medicalqnaclient.page.application.ApplicationPageManager;
import com.example.medicalqnaclient.page.core.Start;
import com.example.medicalqnaclient.page.log.LogPageManager;
import com.example.medicalqnaclient.page.resource.SystemResourcePageManager;
import com.example.medicalqnaclient.page.test.TestPageManager;
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
        final Start application = context.getBean(ApplicationPageManager.class);
        final Start log = context.getBean(LogPageManager.class);
        final Start resource = context.getBean(SystemResourcePageManager.class);
        final Start test = context.getBean(TestPageManager.class);

        application.start(stage, 800, 900);
        log.start(new Stage(), 800, 800);
        resource.start(new Stage(), 800, 700);
        test.start(new Stage(), 800, 600);
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

    public static void main(String[] args) {

        launch();
    }
}
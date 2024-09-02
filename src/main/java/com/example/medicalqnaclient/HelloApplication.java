package com.example.medicalqnaclient;

import com.example.medicalqnaclient.domain.application.page.navigator.ApplicationPageNavigator;
import com.example.medicalqnaclient.page.core.Start;
import com.example.medicalqnaclient.domain.log.page.navigator.LogPageNavigator;
import com.example.medicalqnaclient.domain.resource.page.navigator.ResourcePageNavigator;
import com.example.medicalqnaclient.domain.test.page.navigator.TestPageNavigator;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
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
        initializeStages(stage);
    }

    private void initializeStages(Stage primaryStage) throws IOException {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        int unitWidth = (int) screenBounds.getWidth() / 8;
        int unitHeight = (int) screenBounds.getHeight() / 8;

        int width = unitWidth * 3, height = unitHeight * 3;
        int right = width + 10, down = height + 50;

        initializeStage(ApplicationPageNavigator.class, primaryStage, unitWidth, unitHeight, width, height);
        initializeStage(LogPageNavigator.class, new Stage(), unitWidth + right, unitHeight, width, height);
        initializeStage(ResourcePageNavigator.class, new Stage(), unitWidth + right, unitHeight + down, width, height);
        initializeStage(TestPageNavigator.class, new Stage(), unitWidth, unitHeight + down, width, height);
    }

    private void initializeStage(Class<? extends Start> pageManagerClass, Stage stage, int startX, int startY, int width, int height) throws IOException {
        Start pageManager = context.getBean(pageManagerClass);
        pageManager.start(stage, width, height);
        stage.setY(startY);
        stage.setX(startX);
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }

    public static void main(String[] args) {

        launch();
    }
}
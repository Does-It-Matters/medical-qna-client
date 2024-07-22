package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.controller.Fxml;
import com.example.medicalqnaclient.user.meditator.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.factory.UserType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserContainer implements User, Start {
    private static final Map<UserType, User> users = new HashMap<>();

    private final Stage primaryStage;
    private User state;

    static {
        for (UserType userType: UserType.values()) {
            users.put(userType, UserFactory.getInstance(userType));
        }
    }

    public UserContainer(Stage primaryStage, String title) throws IOException {
        this.primaryStage = primaryStage;
        setupScene(Fxml.START.getFxml(), title, 900, 600);
        state = UserFactory.getInstance(UserType.ALL);
    }

    private void setRoot(String fxml) throws IOException {
        primaryStage.getScene().setRoot(loadFXML(fxml));
    }

    private void setupScene(String fxml, String title, int width, int height) throws IOException {
        Scene scene = new Scene(loadFXML(fxml), width, height);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        return fxmlLoader.load();
    }

    @Override
    public void start() {
        primaryStage.show();
    }

    @Override
    public void goHome() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void signUpAsPatient() {

    }

    @Override
    public void signUpAsDoctor() {

    }

    @Override
    public void getMyProfile() {

    }

    @Override
    public void postQuestion() {

    }

    @Override
    public void readQuestion() {

    }

    @Override
    public void editQuestion() {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public void search() {

    }
}

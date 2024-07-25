package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.controller.Fxml;
import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.factory.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.factory.UserType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@Component
public class UserMeditatorImpl implements UserMeditator {
    private static final Map<UserType, User> users = new HashMap<>();
    private static final UserMeditator meditator = new UserMeditatorImpl();

    private Stage primaryStage;
    private User user;

//    @Autowired
//    private ConfigurableApplicationContext context;
    static {
        for (UserType userType: UserType.values()) {
            users.put(userType, UserFactory.getInstance(userType));
        }
    }

//    @Autowired
    private UserMeditatorImpl() {
        user = UserFactory.getInstance(UserType.ALL);
    }

    private Parent loadFXML(Fxml fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml.getFxml()));
            // FXMLLoader는 컨트롤러를 기본 생성자로 인스턴스화
            // Spring으로 통합 시, ApplicationContext로 컨트롤러 인스턴스화
            // fxmlLoader.setControllerFactory(context::getBean);
            System.out.println("Loading FXML: " + fxml.getFxml());
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load scene: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void start(Stage primaryStage, String title, int width, int height) {
        this.primaryStage = primaryStage;
        Scene scene = new Scene((loadFXML(Fxml.START)), width, height);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void goHome() {
        Parent root;
        if (user.isLoggedIn()) {
            root = loadFXML(Fxml.QUESTIONS_LOGGED_IN_USERS);
        } else {
            root = loadFXML(Fxml.QUESTIONS_LOGGED_OUT_USERS);
        }

        if (root != null) {
            primaryStage.getScene().setRoot(root);
        } else {
            System.err.println("Failed to load new scene");
        }
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {
        user = UserFactory.getInstance(UserType.ALL);
        goHome();
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

    public static UserMeditator getInstance() {
        return meditator;
    }
}

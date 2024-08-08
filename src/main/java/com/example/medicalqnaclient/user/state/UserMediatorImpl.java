package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.controller.Fxml;
import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.server.facade.ServiceServer;
import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import com.example.medicalqnaclient.user.state.factory.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.factory.UserType;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.user.state.factory.exception.UnauthorizedAccessException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class UserMediatorImpl implements UserMediator {
    private static final Map<UserType, User> users = new HashMap<>();
    private static final UserMediator mediator = new UserMediatorImpl();

    private Stage primaryStage;
    private User user;
    private Server server;
    private int readingQuestionId;

//    @Autowired
//    private ConfigurableApplicationContext context;
    static {
        for (UserType userType: UserType.values()) {
            users.put(userType, UserFactory.getInstance(userType));
        }
    }

//    @Autowired
    private UserMediatorImpl() {
        user = UserFactory.getInstance(UserType.ALL);
        server = new ServiceServer();
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
        if (user.isLoggedIn()) {
            setScene(loadFXML(Fxml.QUESTIONS_LOGGED_IN_USERS));
        } else {
            setScene(loadFXML(Fxml.QUESTIONS_LOGGED_OUT_USERS));
        }
    }

    private void setScene(Parent root) {
        if (root != null) {
            primaryStage.getScene().setRoot(root);
        } else {
            System.err.println("Failed to load new scene");
        }
    }

    @Override
    public void login(String id, String pw) throws AlreadyLoggedInException {
        LoginResponse response = user.login(server, id, pw);
        if(response.getStatusCode() == 200) {
            if (response.getRole().getRole().equals("patient")) { // UserType, Role 유지보수 필요
                user = UserFactory.getInstance(UserType.PATIENT);
            } else if (response.getRole().getRole().equals("doctor")) {
                user = UserFactory.getInstance(UserType.DOCTOR);
            } else if (response.getRole().getRole().equals("admin")) {
                user = UserFactory.getInstance(UserType.ADMIN);
            }
            user.setId(id);
        }
        goHome();
    }

    @Override
    public void logout() {
        user = UserFactory.getInstance(UserType.ALL);
        goHome();
    }

    @Override
    public void getPatientSignUpView() {
        setScene(loadFXML(Fxml.PATIENT_SIGN_UP));
    }

    @Override
    public void getDoctorSignUpView() {
        setScene(loadFXML(Fxml.DOCTOR_SIGN_UP));
    }

    @Override
    public void signUpAsPatient(String id, String pw) {
        user.signUpAsPatient(server, id, pw);
        setScene(loadFXML(Fxml.LOGIN));
    }

    @Override
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        user.signUpAsDoctor(server, id, pw, name, field, hospital, introduction);
        setScene(loadFXML(Fxml.LOGIN));
    }

    @Override
    public void getMyProfile() {
        setScene(loadFXML(Fxml.MY_PROFILE));
    }

    @Override
    public void postQuestion(String title, String symptom, String content) {
        user.postQuestion(server, title, symptom, content);
        goHome();
    }

    @Override
    public void readQuestion(int questionId) {
        readingQuestionId = questionId;
        setScene(loadFXML(Fxml.QUESTION));
    }

    @Override
    public QuestionResponse readQuestion() {
        return user.readQuestion(server, readingQuestionId);
    }

    @Override
    public void editQuestion(String title, String symptom, String content) {
        user.editQuestion(server, readingQuestionId, title, symptom, content);
        setScene(loadFXML(Fxml.QUESTION));
    }

    @Override
    public void deleteQuestion() {
        user.deleteQuestion(server, readingQuestionId);
        goHome();
    }

    @Override
    public List<QuestionTitle> search(String query) {
        return user.search(server, query);
    }

    @Override
    public void getLoginView() {
        setScene(loadFXML(Fxml.LOGIN));
    }

    @Override
    public List<QuestionTitle> getQuestionList() {
        return user.getQuestionList(server);
    }

    @Override
    public void getPostQuestionView() {
        if (user.canPostQuestion()) {
            setScene(loadFXML(Fxml.QUESTION_POST));
        } else {
            throw new UnauthorizedAccessException("질문은 환자만 등록할 수 있습니다");
        }
    }

    @Override
    public void getEditQuestionView() {
        setScene(loadFXML(Fxml.QUESTION_EDIT));
    }

    @Override
    public void getMonitorView() {
        setScene(loadFXML(Fxml.SYSTEM_MONITORING));
    }

    @Override
    public void getRSocketTestView() {
        setScene(loadFXML(Fxml.RSOCKET_TEST));
    }

    @Override
    public void getLoadTestView() {
        setScene(loadFXML(Fxml.LOAD_TEST));
    }

    public static UserMediator getInstance() {
        return mediator;
    }
}

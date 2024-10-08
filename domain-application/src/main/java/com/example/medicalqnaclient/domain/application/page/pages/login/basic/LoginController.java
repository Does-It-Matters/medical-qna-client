package com.example.medicalqnaclient.domain.application.page.pages.login.basic;

import com.example.medicalqnaclient.domain.application.page.event.ApplicationPublisher;
import com.example.medicalqnaclient.domain.application.mediator.ReadWriteUserMediator;
import com.example.medicalqnaclient.domain.application.mediator.state.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.domain.application.page.pages.ApplicationController;
import com.example.medicalqnaclient.page.core.PageNavigator;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 로그인 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 로그인 ui로 사용자 입력을 처리 <br>
 * 2. 서버로 로그인 요청 <br>
 * 3. 로그인 요청 수행 후 {@link PageNavigator}에 다음 페이지 요청 <br>
 * </p>
 */
@Component
public class LoginController extends ApplicationController {
    private TextField userIdField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button homeButton;
    private Button patientSignUpButton;
    private Button doctorSignUpButton;

    @Autowired
    public LoginController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    /**
     * <b> 역할: 로그인 ui 메소드 </b>
     * <p>
     * 1. ui 구성 <br>
     * 2. 버튼에 대한 핸들러 세팅 <br>
     * </p>
     *
     * @return 보여줄 화면 ui
     */
    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        userIdField = new TextField();
        userIdField.setPromptText("User ID");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        loginButton = new Button("Login");
        homeButton = new Button("Home");
        patientSignUpButton = new Button("Sign Up as Patient");
        doctorSignUpButton = new Button("Sign Up as Doctor");

        loginButton.setOnAction(e -> onLoginButtonClick());
        homeButton.setOnAction(e -> onHomeButtonClick());
        patientSignUpButton.setOnAction(e -> onPatientSignUpButtonClick());
        doctorSignUpButton.setOnAction(e -> onDoctorSignUpButtonClick());

        layout.getChildren().addAll(userIdField, passwordField, loginButton, homeButton, patientSignUpButton, doctorSignUpButton);

        return layout;
    }

    /**
     * <b> 역할: 로그인 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 사용자가 입력한 ID와 비밀번호로 로그인 시도 <br>
     * </p>
     */
    protected void onLoginButtonClick() {
        String id = userIdField.getText();
        String password = passwordField.getText();
        try {
            mediator.login(id, password);
            publisher.publishGoHomeEvent();
        } catch (AlreadyLoggedInException e) {
            // 이미 로그인된 상태를 알림
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("You are already logged in!");
            alert.showAndWait();
        }
    }

    /**
     * <b> 역할: 홈 버튼 클릭 시 호출 </b>
     * <p>
     * - 홈 화면으로 이동 <br>
     * </p>
     */
    protected void onHomeButtonClick() {
        publisher.publishGoHomeEvent();
    }

    /**
     * <b> 역할: 환자 회원가입 버튼 클릭 시 호출 </b>
     * <p>
     * - 환자 회원가입 화면으로 이동 <br>
     * </p>
     */
    protected void onPatientSignUpButtonClick() {
        publisher.publishPatientSignUpEvent();
    }

    /**
     * <b> 역할: 의료진 회원가입 버튼 클릭 시 호출 </b>
     * <p>
     * - 의료진 회원가입 화면으로 이동 <br>
     * </p>
     */
    protected void onDoctorSignUpButtonClick() {
        publisher.publishDoctorSignUpEvent();
    }
}

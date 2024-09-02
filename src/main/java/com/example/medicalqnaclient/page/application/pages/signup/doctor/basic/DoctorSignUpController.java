package com.example.medicalqnaclient.page.application.pages.signup.doctor.basic;

import com.example.medicalqnaclient.page.application.event.ApplicationPublisher;
import com.example.medicalqnaclient.page.application.pages.ApplicationController;
import com.example.medicalqnaclient.page.application.mediator.ReadWriteUserMediator;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 의료진 회원 가입 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 의료진 회원가입 UI로 사용자 입력을 처리 <br>
 * 2. 서버로 회원가입 요청 <br>
 * 3. 회원가입 요청 수행 후 {@link com.example.medicalqnaclient.page.core.PageManager}에 다음 페이지 요청 <br>
 * </p>
 */
@Component
public class DoctorSignUpController extends ApplicationController {
    private TextField idField;
    private TextField passwordField;
    private TextField nameField;
    private TextField fieldField;
    private TextField hospitalField;
    private TextField introductionField;
    private Button signUpButton;
    private Button homeButton;

    @Autowired
    public DoctorSignUpController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    /**
     * <b> 역할: 의료진 회원가입 UI 메소드 </b>
     * <p>
     * 1. UI 구성 <br>
     * 2. 버튼에 대한 핸들러 세팅 <br>
     * </p>
     *
     * @return 보여줄 화면 UI
     */
    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        idField = new TextField();
        idField.setPromptText("ID");

        passwordField = new TextField();
        passwordField.setPromptText("Password");

        nameField = new TextField();
        nameField.setPromptText("Name");

        fieldField = new TextField();
        fieldField.setPromptText("Field");

        hospitalField = new TextField();
        hospitalField.setPromptText("Hospital");

        introductionField = new TextField();
        introductionField.setPromptText("Introduction");

        signUpButton = new Button("Sign Up");
        homeButton = new Button("Home");

        signUpButton.setOnAction(e -> onSignUpButtonClick());
        homeButton.setOnAction(e -> onHomeButtonClick());

        layout.getChildren().addAll(idField, passwordField, nameField, fieldField, hospitalField, introductionField, signUpButton, homeButton);

        return layout;
    }

    /**
     * <b> 역할: 의료진 회원가입 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 사용자가 입력한 정보로 회원가입 시도 <br>
     * </p>
     */
    protected void onSignUpButtonClick() {
        String id = idField.getText();
        String password = passwordField.getText();
        String name = nameField.getText();
        String field = fieldField.getText();
        String hospital = hospitalField.getText();
        String introduction = introductionField.getText();

        if (id.isEmpty() || password.isEmpty() || name.isEmpty() || field.isEmpty() || hospital.isEmpty() || introduction.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Sign Up Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all fields.");
            alert.showAndWait();
        } else {
            mediator.signUpAsDoctor(id, password, name, field, hospital, introduction);
            publisher.publishLoginEvent();
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
}
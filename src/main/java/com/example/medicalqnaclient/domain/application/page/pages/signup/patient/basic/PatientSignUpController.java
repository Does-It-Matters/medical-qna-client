package com.example.medicalqnaclient.domain.application.page.pages.signup.patient.basic;

import com.example.medicalqnaclient.domain.application.page.event.ApplicationPublisher;
import com.example.medicalqnaclient.domain.application.mediator.ReadWriteUserMediator;
import com.example.medicalqnaclient.domain.application.page.pages.ApplicationController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 환자 회원 가입 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 환자 회원가입 UI로 사용자 입력을 처리 <br>
 * 2. 서버로 회원가입 요청 <br>
 * 3. 홈 화면 요청 <br>
 * </p>
 */
@Component
public class PatientSignUpController extends ApplicationController {
    private TextField idField;
    private TextField passwordField;
    private Button signUpButton;
    private Button homeButton;

    @Autowired
    public PatientSignUpController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        idField = new TextField();
        idField.setPromptText("ID");

        passwordField = new TextField();
        passwordField.setPromptText("Password");

        signUpButton = new Button("Sign Up");
        homeButton = new Button("Home");

        signUpButton.setOnAction(e -> onSignUpButtonClick());
        homeButton.setOnAction(e -> onHomeButtonClick());

        layout.getChildren().addAll(idField, passwordField, signUpButton, homeButton);

        return layout;
    }

    /**
     * <b> 역할: 환자 회원가입 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 사용자가 입력한 정보로 회원가입 시도 <br>
     * </p>
     */
    protected void onSignUpButtonClick() {
        String id = idField.getText();
        String password = passwordField.getText();
        mediator.signUpAsPatient(id, password);
        publisher.publishLoginEvent();
    }

    /**
     * <b> 역할: 홈 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 홈 화면으로 이동 <br>
     * </p>
     */
    protected void onHomeButtonClick() {
        publisher.publishGoHomeEvent();
    }
}
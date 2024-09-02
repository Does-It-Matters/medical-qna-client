package com.example.medicalqnaclient.domain.application.page.pages.question.basic;

import com.example.medicalqnaclient.domain.application.page.event.ApplicationPublisher;
import com.example.medicalqnaclient.domain.application.mediator.ReadWriteUserMediator;
import com.example.medicalqnaclient.domain.application.page.pages.ApplicationController;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 수정 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 질문 수정 UI로 사용자 입력을 처리 <br>
 * 2. 서버로 수정된 질문 요청 <br>
 * 3. 홈 화면 요청 <br>
 * </p>
 */
@Component
public class QuestionEditController extends ApplicationController {
    private TextField titleTextField;
    private TextArea symptomTextArea;
    private TextArea questionTextArea;
    private Button editButton;
    private Button homeButton;

    @Autowired
    public QuestionEditController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        titleTextField = new TextField();
        titleTextField.setPromptText("Title");

        symptomTextArea = new TextArea();
        symptomTextArea.setPromptText("Symptom");

        questionTextArea = new TextArea();
        questionTextArea.setPromptText("Question");

        editButton = new Button("Edit");
        homeButton = new Button("Home");

        editButton.setOnAction(e -> onEditButtonClick());
        homeButton.setOnAction(e -> onHomeButtonClick());

        layout.getChildren().addAll(titleTextField, symptomTextArea, questionTextArea, editButton, homeButton);

        return layout;
    }

    /**
     * <b> 역할: 질문 수정 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 사용자가 입력한 내용으로 질문 수정 요청 <br>
     * </p>
     */
    protected void onEditButtonClick() {
        mediator.editQuestion(titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
        publisher.publishGoHomeEvent();
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
package com.example.medicalqnaclient.page.pages.application.question.basic;

import com.example.medicalqnaclient.page.core.ApplicationController;
import com.example.medicalqnaclient.page.event.publishers.QnAPublisher;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 등록 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 질문 등록 UI로 사용자 입력을 처리 <br>
 * 2. 서버로 새로운 질문 요청 <br>
 * 3. 홈 화면 요청 <br>
 * </p>
 */
@Component
public class QuestionPostController extends ApplicationController {
    private TextField titleTextField;
    private TextArea symptomTextArea;
    private TextArea questionTextArea;
    private Button writeButton;
    private Button homeButton;

    @Autowired
    public QuestionPostController(QnAPublisher publisher, ReadWriteUserMediator mediator) {
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

        writeButton = new Button("Write");
        homeButton = new Button("Home");

        writeButton.setOnAction(e -> onWriteButtonClick());
        homeButton.setOnAction(e -> onHomeButtonClick());

        layout.getChildren().addAll(titleTextField, symptomTextArea, questionTextArea, writeButton, homeButton);

        return layout;
    }

    /**
     * <b> 역할: 질문 등록 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 사용자가 입력한 정보로 새로운 질문을 서버에 등록 <br>
     * </p>
     */
    protected void onWriteButtonClick() {
        mediator.postQuestion(titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
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
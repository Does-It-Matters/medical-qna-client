package com.example.medicalqnaclient.page.pages.question.basic;

import com.example.medicalqnaclient.page.core.ViewController;
import com.example.medicalqnaclient.page.event.publishers.QnAPublisher;
import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 조회 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 질문 조회 UI로 질문 내용을 표시 <br>
 * 2. 질문 수정 및 삭제 요청 <br>
 * 3. 홈 화면 요청 <br>
 * </p>
 */
@Component
public class QuestionViewController extends ViewController {
    private Label titleLabel;
    private Label idLabel;
    private Label symptomLabel;
    private Label contentLabel;
    private Button homeButton;
    private Button editButton;
    private Button deleteButton;

    @Autowired
    public QuestionViewController(QnAPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        titleLabel = new Label();
        idLabel = new Label();
        symptomLabel = new Label();
        contentLabel = new Label();

        homeButton = new Button("Home");
        editButton = new Button("Edit");
        deleteButton = new Button("Delete");

        homeButton.setOnAction(e -> onHomeButtonClick());
        editButton.setOnAction(e -> onEditButtonClick());
        deleteButton.setOnAction(e -> onDeleteButtonClick());

        layout.getChildren().addAll(titleLabel, idLabel, symptomLabel, contentLabel, editButton, deleteButton, homeButton);

        initialize();

        return layout;
    }

    /**
     * <b> 역할: 화면 초기화 메소드 </b>
     * <p>
     * - 질문 내용을 서버에서 가져와서 UI에 표시 <br>
     * </p>
     */
    protected void initialize() {
        QuestionResponse response = mediator.readQuestion();
        titleLabel.setText("Title: " + response.getQuestionDetail().getTitle());
        idLabel.setText("User ID: " + response.getQuestionDetail().getUid());
        symptomLabel.setText("Symptom: " + response.getQuestionDetail().getSymptom());
        contentLabel.setText("Content: " + response.getQuestionDetail().getContent());
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

    /**
     * <b> 역할: 질문 수정 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 질문 수정 화면으로 이동 <br>
     * </p>
     */
    protected void onEditButtonClick() {
        publisher.publishQuestionEditEvent();
    }

    /**
     * <b> 역할: 질문 삭제 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 질문 삭제 요청 <br>
     * </p>
     */
    protected void onDeleteButtonClick() {
        mediator.deleteQuestion();
        publisher.publishGoHomeEvent();
    }
}
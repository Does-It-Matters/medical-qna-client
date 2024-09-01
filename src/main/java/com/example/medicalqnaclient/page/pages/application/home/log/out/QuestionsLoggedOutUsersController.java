package com.example.medicalqnaclient.page.pages.application.home.log.out;

import com.example.medicalqnaclient.page.pages.application.ApplicationController;
import com.example.medicalqnaclient.page.event.publishers.QnAPublisher;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <b> 역할: 로그아웃된 상태에서 질문 목록 조회 컨트롤러 클래스 </b>
 */
@Component
public class QuestionsLoggedOutUsersController extends ApplicationController {
    private ComboBox<String> categoryComboBox;
    private ListView<QuestionTitle> listView;
    private TextArea userQueryTextArea;
    private Button loginButton;
    private Button searchButton;

    @Autowired
    public QuestionsLoggedOutUsersController(QnAPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    /**
     * <b> 역할: ui 메소드 </b>
     * <p>
     * - 화면 ui 구성
     * - 핸들러 설정
     * </p>
     *
     * @return 화면 ui
     */
    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        categoryComboBox = new ComboBox<>();
        listView = new ListView<>();
        userQueryTextArea = new TextArea();
        loginButton = new Button("Login");
        searchButton = new Button("Search");

        loginButton.setOnAction(e -> onLoginButtonClick());
//        searchButton.setOnAction(e -> onSearchButtonClick());

        layout.getChildren().addAll(categoryComboBox, listView, userQueryTextArea, searchButton, loginButton);
        setList(mediator.getQuestionList());

        return layout;
    }

    /**
     * <b> 역할: 로그인 버튼 클릭에 대한 메소드 </b>
     * <p>
     * - 로그인 이벤트 발행
     * </p>
     */
    protected void onLoginButtonClick() {
        publisher.publishLoginEvent();
    }

    protected void onSearchButtonClick() {
        setList(mediator.search(userQueryTextArea.getText()));
    }

    private void setList(List<QuestionTitle> list) {
        ObservableList<QuestionTitle> items = FXCollections.observableArrayList(list);
        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                handleSelectedQuestion(newValue);
            }
        });
    }

    private void handleSelectedQuestion(QuestionTitle questionTitle) {
        mediator.setReadingQuestionId(questionTitle.getQuestionId());
        publisher.publishQuestionViewEvent();
    }
}

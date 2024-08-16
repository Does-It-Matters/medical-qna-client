package com.example.medicalqnaclient.page.home.log.out;

import com.example.medicalqnaclient.page.ViewController;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class QuestionsLoggedOutUsersController extends ViewController {
    private final UserMediator mediator;
    private ComboBox<String> categoryComboBox;
    private ListView<String> listView;
//    private ListView<QuestionTitle> listView;
    private TextArea userQueryTextArea;
    private Button loginButton;
    private Button searchButton;

    @Autowired
    public QuestionsLoggedOutUsersController(UserMediator mediator, ApplicationEventPublisher applicationEventPublisher) {
        super(applicationEventPublisher);
        this.mediator = mediator;
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        categoryComboBox = new ComboBox<>();
        listView = new ListView<>();
        userQueryTextArea = new TextArea();
        loginButton = new Button("Login");
        searchButton = new Button("Search");

//        loginButton.setOnAction(e -> onLoginButtonClick());
//        searchButton.setOnAction(e -> onSearchButtonClick());

        layout.getChildren().addAll(categoryComboBox, listView, userQueryTextArea, searchButton, loginButton);
//        setList(mediator.getQuestionList());

        return layout;
    }

//    private void handleSelectedQuestion(QuestionTitle questionTitle) {
//        mediator.readQuestion(questionTitle.getQuestionId());
//    }
//
//    protected void onLoginButtonClick() {
//        mediator.getLoginView();
//    }
//
//    protected void onSearchButtonClick() {
//        setList(mediator.search(userQueryTextArea.getText()));
//    }
//
//    private void setList(List<QuestionTitle> list) {
//        ObservableList<QuestionTitle> items = FXCollections.observableArrayList(list);
//        listView.setItems(items);
//
//        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                handleSelectedQuestion(newValue);
//            }
//        });
//    }
}

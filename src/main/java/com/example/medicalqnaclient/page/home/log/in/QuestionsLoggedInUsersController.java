package com.example.medicalqnaclient.page.home.log.in;

import com.example.medicalqnaclient.page.ViewController;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class QuestionsLoggedInUsersController extends ViewController {
    private final UserMediator mediator;
    private ComboBox<String> categoryComboBox;
    private ListView<String> listView;
//    private ListView<QuestionTitle> listView;
    private MenuButton userNameMenuButton;
    private TextArea userQueryTextArea;
    private Button logoutButton;
    private Button searchButton;
    private Button postButton;

    @Autowired
    public QuestionsLoggedInUsersController(UserMediator mediator, ApplicationEventPublisher eventPublisher) {
        super(eventPublisher);
        this.mediator = mediator;
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        categoryComboBox = new ComboBox<>();
        listView = new ListView<>();
        userNameMenuButton = new MenuButton("User");
        userQueryTextArea = new TextArea();
        logoutButton = new Button("Logout");
        searchButton = new Button("Search");
        postButton = new Button("Post");

//        logoutButton.setOnAction(e -> onLogoutButtonClick());
//        searchButton.setOnAction(e -> onSearchButtonClick());
//        postButton.setOnAction(e -> onPostButtonClick());

        layout.getChildren().addAll(userNameMenuButton, categoryComboBox, listView, userQueryTextArea, searchButton, postButton, logoutButton);
//        setList(mediator.getQuestionList());

        return layout;
    }

//    private void handleSelectedQuestion(QuestionTitle questionTitle) {
//        mediator.readQuestion(questionTitle.getQuestionId());
//    }
//
//    protected void onLogoutButtonClick() {
//        mediator.logout();
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
//
//    protected void onPostButtonClick() {
//        try {
//            mediator.getPostQuestionView();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

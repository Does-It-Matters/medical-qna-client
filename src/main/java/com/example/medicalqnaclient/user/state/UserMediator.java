package com.example.medicalqnaclient.user.state;

//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import com.example.medicalqnaclient.user.state.factory.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.factory.UserType;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserMediator implements ReadWriteUserMediator {
    private final Map<UserType, User> users = new HashMap<>();
    private final UserFactory userFactory;

    private User user;

    @Autowired
    public UserMediator(UserFactory userFactory) {
        this.userFactory = userFactory;
        for (UserType userType: UserType.values()) {
            users.put(userType, this.userFactory.getInstance(userType));
        }

        user = this.userFactory.getInstance(UserType.ALL);
    }

    @Override
    public boolean isLoggedIn() {
        return user.isLoggedIn();
    }

    @Override
    public void login(String id, String pw) throws AlreadyLoggedInException {
        LoginResponse response = user.login(id, pw);
        if (response.getStatusCode() == 200) {
            UserType type = UserType.getUserType(response.getRole().getRole());
            user = users.get(type);
            user.setId(id);
        }
    }

    @Override
    public void logout() {
        user = users.get(UserType.ALL);
    }

    @Override
    public void signUpAsPatient(String id, String pw) {
        user.signUpAsPatient(id, pw);
    }

    @Override
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        user.signUpAsDoctor(id, pw, name, field, hospital, introduction);
    }

//
//    @Override
//    public void getMyProfile() {
//        setScene(loadFXML(Fxml.MY_PROFILE));
//    }

    @Override
    public void postQuestion(String title, String symptom, String content) {
        user.postQuestion(title, symptom, content);
    }
//
//    @Override
//    public void readQuestion(int questionId) {
//        readingQuestionId = questionId;
//        setScene(loadFXML(Fxml.QUESTION));
//    }
//
//    @Override
//    public QuestionResponse readQuestion() {
//        return user.readQuestion(server, readingQuestionId);
//    }
//
//    @Override
//    public void editQuestion(String title, String symptom, String content) {
//        user.editQuestion(server, readingQuestionId, title, symptom, content);
//        setScene(loadFXML(Fxml.QUESTION));
//    }
//
//    @Override
//    public void deleteQuestion() {
//        user.deleteQuestion(server, readingQuestionId);
//        goHome();
//    }
//
//    @Override
//    public List<QuestionTitle> search(String query) {
//        return user.search(server, query);
//    }
//
//    @Override
//    public void getLoginView() {
//        setScene(loadFXML(Fxml.LOGIN));
//    }
//
//    @Override
//    public List<QuestionTitle> getQuestionList() {
//        return user.getQuestionList(server);
//    }
//
//    @Override
//    public void getPostQuestionView() {
//        if (user.canPostQuestion()) {
//            setScene(loadFXML(Fxml.QUESTION_POST));
//        } else {
//            throw new UnauthorizedAccessException("질문은 환자만 등록할 수 있습니다");
//        }
//    }
//
//    @Override
//    public void getEditQuestionView() {
//        setScene(loadFXML(Fxml.QUESTION_EDIT));
//    }
//
//    @Override
//    public void getMonitorView() {
//        setScene(loadFXML(Fxml.SYSTEM_MONITORING));
//    }
//
//    @Override
//    public void getRSocketTestView() {
//        setScene(loadFXML(Fxml.RSOCKET_TEST));
//    }
//
//    @Override
//    public void getLoadTestView() {
//        setScene(loadFXML(Fxml.LOAD_TEST));
//    }
}

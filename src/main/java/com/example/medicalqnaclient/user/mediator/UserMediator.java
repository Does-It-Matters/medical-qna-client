package com.example.medicalqnaclient.user.mediator;

import com.example.medicalqnaclient.server.application.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.application.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.application.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.state.core.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.core.UserType;
import com.example.medicalqnaclient.user.state.exception.AlreadyLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserMediator implements ReadWriteUserMediator {
    private final Map<UserType, User> users = new HashMap<>();
    private final UserFactory userFactory;

    private User user;
    private int readingQuestionId;

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

    @Override
    public void getMyProfile() {
    }

    @Override
    public void postQuestion(String title, String symptom, String content) {
        user.postQuestion(title, symptom, content);
    }

    @Override
    public void setReadingQuestionId(int questionId) {
        readingQuestionId = questionId;
    }

    @Override
    public QuestionResponse readQuestion() {
        return user.readQuestion(readingQuestionId);
    }

    @Override
    public void editQuestion(String title, String symptom, String content) {
        user.editQuestion(readingQuestionId, title, symptom, content);
    }

    @Override
    public void deleteQuestion() {
        user.deleteQuestion(readingQuestionId);
    }

    @Override
    public List<QuestionTitle> search(String query) {
        return user.search(query);
    }

    @Override
    public List<QuestionTitle> getQuestionList() {
        return user.getQuestionList();
    }
}

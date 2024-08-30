package com.example.medicalqnaclient.user.state;

//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
//import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import com.example.medicalqnaclient.user.state.factory.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.factory.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserMediator implements ReadWriteUserMediator {
    private final Map<UserType, User> users = new HashMap<>();
    private final User user;
    private final UserFactory userFactory;
//    private int readingQuestionId;

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
        return false;
    }

//    @Override
//    public void goHome() {
//        if (user.isLoggedIn()) {
//            setScene(loadFXML(Fxml.QUESTIONS_LOGGED_IN_USERS));
//        } else {
//            setScene(loadFXML(Fxml.QUESTIONS_LOGGED_OUT_USERS));
//        }
//    }
//
//    private void setScene(Parent root) {
//        if (root != null) {
//            primaryStage.getScene().setRoot(root);
//        } else {
//            System.err.println("Failed to load new scene");
//        }
//    }
//
//    @Override
//    public void login(String id, String pw) throws AlreadyLoggedInException {
//        LoginResponse response = user.login(server, id, pw);
//        if(response.getStatusCode() == 200) {
//            if (response.getRole().getRole().equals("patient")) { // UserType, Role 유지보수 필요
//                user = UserFactory.getInstance(UserType.PATIENT);
//            } else if (response.getRole().getRole().equals("doctor")) {
//                user = UserFactory.getInstance(UserType.DOCTOR);
//            } else if (response.getRole().getRole().equals("admin")) {
//                user = UserFactory.getInstance(UserType.ADMIN);
//            }
//            user.setId(id);
//        }
//        goHome();
//    }
//
//    @Override
//    public void logout() {
//        user = UserFactory.getInstance(UserType.ALL);
//        goHome();
//    }
//
//    @Override
//    public void getPatientSignUpView() {
//        setScene(loadFXML(Fxml.PATIENT_SIGN_UP));
//    }
//
//    @Override
//    public void getDoctorSignUpView() {
//        setScene(loadFXML(Fxml.DOCTOR_SIGN_UP));
//    }
//
//    @Override
//    public void signUpAsPatient(String id, String pw) {
//        user.signUpAsPatient(server, id, pw);
//        setScene(loadFXML(Fxml.LOGIN));
//    }
//
//    @Override
//    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
//        user.signUpAsDoctor(server, id, pw, name, field, hospital, introduction);
//        setScene(loadFXML(Fxml.LOGIN));
//    }
//
//    @Override
//    public void getMyProfile() {
//        setScene(loadFXML(Fxml.MY_PROFILE));
//    }
//
//    @Override
//    public void postQuestion(String title, String symptom, String content) {
//        user.postQuestion(server, title, symptom, content);
//        goHome();
//    }
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

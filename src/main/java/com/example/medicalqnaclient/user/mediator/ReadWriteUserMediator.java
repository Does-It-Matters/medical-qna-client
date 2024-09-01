package com.example.medicalqnaclient.user.mediator;

import com.example.medicalqnaclient.server.application.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.application.tasks.questionlist.QuestionTitle;

import java.util.List;

/**
 * <b> 역할: controller 객체와 비즈니스 로직을 처리하는 상태 객체 간의 상호작용을 중재 </b>
 * <p>
 * - 결합도와 의존도 줄이기 <br>
 * - ISP로 controller에서 접근할 필요없는 메소드 노출하지 않기 <br>
 * </p>
 */
public interface ReadWriteUserMediator extends ReadUserMediator {

    public void login(String id, String pw);
    public void logout();
    public void signUpAsPatient(String id, String pw);
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction);
    public void getMyProfile();
    public void postQuestion(String title, String symptom, String content);
    public void setReadingQuestionId(int questionId);
    public QuestionResponse readQuestion();
    public void editQuestion(String title, String symptom, String content);
    public void deleteQuestion();
    public List<QuestionTitle> search(String query);
    public List<QuestionTitle> getQuestionList();
}

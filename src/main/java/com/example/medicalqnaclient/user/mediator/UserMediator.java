package com.example.medicalqnaclient.user.mediator;

//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;

import java.util.List;

public interface UserMediator {
    public boolean isLoggedIn();

//    // 1. 홈 화면 요청
//    public void goHome();
//
//    // 2. 로그인 요청
//    public void login(String id, String pw);
//
//    // 3. 로그아웃 요청
//    public void logout();
//
//    // 4. 환자 회원 가입 요청
//    public void signUpAsPatient(String id, String pw);
//
//    // 5. 의료진 회원 가입 요청
//    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction);
//
//    // 6. 본인 프로필 조회
//    public void getMyProfile();
//
//    // 7. 질문 등록 요청
//    public void postQuestion(String title, String symptom, String content);
//
//    // 8. 질문 조회 요청
//    public void readQuestion(int questionId);
//
//    // 9. 질문 수정 요청
//    public void editQuestion(String title, String symptom, String content);
//
//    // 10. 질문 삭제 요청
//    public void deleteQuestion();
//
//    // 11. 검색 요청
//    public List<QuestionTitle> search(String query);
//
//    public void getLoginView();
//
//    public List<QuestionTitle> getQuestionList();
//
//    public QuestionResponse readQuestion();
//
//    public void getPatientSignUpView();
//
//    public void getDoctorSignUpView();
//
//    public void getPostQuestionView();
//
//    public void getEditQuestionView();
//
//    public void getMonitorView();
//
//    public void getRSocketTestView();
//
//    public void getLoadTestView();
//    public void monitorSystemResources();
//
//    public void monitorLogs();
}

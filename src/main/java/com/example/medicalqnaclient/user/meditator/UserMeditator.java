package com.example.medicalqnaclient.user.meditator;

public interface UserMeditator extends Start {
    // 1. 홈 화면 요청
    public void goHome();

    // 2. 로그인 요청
    public void login();

    // 3. 로그아웃 요청
    public void logout();

    // 4. 환자 회원 가입 요청
    public void signUpAsPatient();

    // 5. 의료진 회원 가입 요청
    public void signUpAsDoctor();

    // 6. 본인 프로필 조회
    public void getMyProfile();

    // 7. 질문 등록 요청
    public void postQuestion();

    // 8. 질문 조회 요청
    public void readQuestion();

    // 9. 질문 수정 요청
    public void editQuestion();

    // 10. 질문 삭제 요청
    public void deleteQuestion();

    // 11. 검색 요청
    public void search();

//    public void monitorSystemResources();
//
//    public void monitorLogs();
}

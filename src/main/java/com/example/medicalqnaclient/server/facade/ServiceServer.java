package com.example.medicalqnaclient.server.facade;

import com.example.medicalqnaclient.server.facade.config.ServerConfig;
import com.example.medicalqnaclient.server.facade.tasks.question.delete.QuestionDeleteRequest;
import com.example.medicalqnaclient.server.facade.tasks.question.delete.QuestionDeleteResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditRequest;
import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollRequest;
import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionGetRequest;
import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionsGetRequest;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.tasks.signup.common.SignUpResponse;
import com.example.medicalqnaclient.server.facade.tasks.signup.doctor.DoctorSignUpRequest;
import com.example.medicalqnaclient.server.facade.tasks.signup.patient.PatientSignUpRequest;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginRequest;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;

import java.util.List;

public class ServiceServer implements Server {
    private final ServerConfig config = ServerConfig.LOCALHOST;
    private final UrlProvider urlProvider = new UrlProvider(config);
    private final LoginRequest loginRequest = new LoginRequest();
    private final QuestionsGetRequest questionsGetRequest = new QuestionsGetRequest();
    private final QuestionGetRequest questionGetRequest = new QuestionGetRequest();
    private final PatientSignUpRequest patientSignUpRequest = new PatientSignUpRequest();
    private final DoctorSignUpRequest doctorSignUpRequest = new DoctorSignUpRequest();
    private final QuestionEnrollRequest questionEnrollRequest = new QuestionEnrollRequest();
    private final QuestionEditRequest questionEditRequest = new QuestionEditRequest();
    private final QuestionDeleteRequest questionDeleteRequest = new QuestionDeleteRequest();

    @Override
    public LoginResponse login(String id, String password) throws Exception {
        String url = config.getBaseUrl() + "/api/v2/sign-in";
        return loginRequest.post(url, id, password);
    }

    @Override
    public List<QuestionTitle> getQuestionList() {
//        String encodedQueryString = URLEncoder.encode(queryString, StandardCharsets.UTF_8); 안전하게 url 인코딩 처리하기
        String url = config.getBaseUrl() + "/api/v2/question/list";
        return questionsGetRequest.getQuestionListAll(url);
    }

    @Override
    public List<QuestionTitle> search(String query) {
        return questionsGetRequest.search(query);
    }

    @Override
    public QuestionResponse readQuestion(int questionId) {
        String url = config.getBaseUrl() + "/api/v2/question/";
        return questionGetRequest.getQuestion(url, questionId);
    }

    @Override
    public SignUpResponse signUpAsPatient(String id, String pw) {
        String url = config.getBaseUrl() + "/api/v2/patient/sign-up";
        return patientSignUpRequest.post(url, id, pw);
    }

    @Override
    public SignUpResponse signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        String url = config.getBaseUrl() + "/api/v2/doctor/sign-up";
        return doctorSignUpRequest.post(url, id, pw, name, field, hospital, introduction);
    }

    @Override
    public QuestionEnrollResponse enrollQuestion(String id, String title, String symptom, String content) {
        String url = config.getBaseUrl() + "/api/v2/question/enroll";
        return questionEnrollRequest.post(url, id, title, symptom, content);
    }

    @Override
    public QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content) {
        String url = config.getBaseUrl() + "/api/v2/question";
        return questionEditRequest.patch(url, questionId, title, symptom, content);
    }

    @Override
    public QuestionDeleteResponse deleteQuestion(int questionId) {
        String url = config.getBaseUrl() + "/api/v2/question/";
        return questionDeleteRequest.delete(url, questionId);
    }
}

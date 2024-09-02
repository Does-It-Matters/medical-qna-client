package com.example.medicalqnaclient.domain.application.network.server;

import com.example.medicalqnaclient.domain.application.network.server.config.ServerConfig;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.delete.QuestionDeleteRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.edit.QuestionEditRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll.QuestionEnrollRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.read.QuestionGetRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist.QuestionsGetRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.signup.common.SignUpResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.signup.doctor.DoctorSignUpRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.signup.patient.PatientSignUpRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.user.login.LoginRequest;
import com.example.medicalqnaclient.domain.application.network.server.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.domain.application.network.server.url.ApplicationUrlProvider;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.delete.QuestionDeleteResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.read.QuestionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationServerImpl implements ApplicationServer {
    private final ServerConfig config = ServerConfig.LOCALHOST;
    private final ApplicationUrlProvider applicationUrlProvider = new ApplicationUrlProvider(config);

//    /**
//     * 각 요청 클래스를 인스턴스화하여 테스트 용이하도록 진행
//     */
    private final LoginRequest loginRequest = new LoginRequest();
    private final PatientSignUpRequest patientSignUpRequest = new PatientSignUpRequest();
    private final DoctorSignUpRequest doctorSignUpRequest = new DoctorSignUpRequest();
    private final QuestionsGetRequest questionsGetRequest = new QuestionsGetRequest();
    private final QuestionGetRequest questionGetRequest = new QuestionGetRequest();
    private final QuestionEnrollRequest questionEnrollRequest = new QuestionEnrollRequest();
    private final QuestionEditRequest questionEditRequest = new QuestionEditRequest();
    private final QuestionDeleteRequest questionDeleteRequest = new QuestionDeleteRequest();

    @Override
    public LoginResponse login(String id, String password) throws Exception {
        String url = applicationUrlProvider.getLoginUrl();
        return loginRequest.post(url, id, password);
    }

    @Override
    public SignUpResponse signUpAsPatient(String id, String pw) {
        String url = applicationUrlProvider.getSignUpAsPatientUrl();
        return patientSignUpRequest.post(url, id, pw);
    }

    @Override
    public SignUpResponse signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        String url = applicationUrlProvider.getSignUpAsDoctorUrl();
        return doctorSignUpRequest.post(url, id, pw, name, field, hospital, introduction);
    }

    @Override
    public List<QuestionTitle> getQuestionList() {
//        String encodedQueryString = URLEncoder.encode(queryString, StandardCharsets.UTF_8); 안전하게 url 인코딩 처리하기
        String url = applicationUrlProvider.getQuestionListUrl();
        return questionsGetRequest.getQuestionListAll(url);
    }

    @Override
    public List<QuestionTitle> search(String query) {
        String url = applicationUrlProvider.getSearchUrl();
        return questionsGetRequest.search(query);
    }

    @Override
    public QuestionResponse readQuestion(int questionId) {
        String url = applicationUrlProvider.getQuestionUrl();
        return questionGetRequest.getQuestion(url, questionId);
    }

    @Override
    public QuestionEnrollResponse enrollQuestion(String id, String title, String symptom, String content) {
        String url = applicationUrlProvider.getEnrollQuestionUrl();
        return questionEnrollRequest.post(url, id, title, symptom, content);
    }

    @Override
    public QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content) {
        String url = applicationUrlProvider.getEditQuestionUrl();
        return questionEditRequest.patch(url, questionId, title, symptom, content);
    }

    @Override
    public QuestionDeleteResponse deleteQuestion(int questionId) {
        String url = applicationUrlProvider.getDeleteQuestionUrl();
        return questionDeleteRequest.delete(url, questionId);
    }
}

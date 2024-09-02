package com.example.medicalqnaclient.domain.application.network.server;

import com.example.medicalqnaclient.domain.application.network.server.tasks.signup.common.SignUpResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.user.login.LoginResponse;

public interface AuthService {
    LoginResponse login(String id, String password) throws Exception;
    SignUpResponse signUpAsPatient(String id, String pw);
    SignUpResponse signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction);
}

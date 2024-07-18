package com.example.medicalqnaclient.out.network.user.requests;

import com.example.medicalqnaclient.businesslogic.user.Role;
import com.example.medicalqnaclient.out.network.config.ServerConfig;
import com.example.medicalqnaclient.out.network.user.requests.responses.Response;
import com.example.medicalqnaclient.out.network.user.requests.responses.SignUpResponse;
import com.example.medicalqnaclient.out.network.utils.Post;
import com.example.medicalqnaclient.utils.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class PatientSignUpRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static SignUpResponse post(String id, String password, Role role) throws Exception {
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/patient/sign-up";
        String requestBody = getRequestBody(id, password, role);

        Response response = Post.getResponse(url, requestBody);
//        if (response.getStatusCode() == 404) {} 기타 예외 상황 처리 필요
        SignUpResponse signUpResponse = objectMapper.readValue(response.getBody(), SignUpResponse.class);
        signUpResponse.setStatusCode(response.getStatusCode());

        return signUpResponse;
    }

    private static String getRequestBody(String id, String password, Role role) {
        Map<String, String> data = new HashMap<>();
        data.put("id", id);
        data.put("pw", password);
        data.put("role", role.toString());
        return JsonFormatter.formatJson(data);
    }
}

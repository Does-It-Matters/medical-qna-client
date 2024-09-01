package com.example.medicalqnaclient.server.facade.tasks.signup.patient;

import com.example.medicalqnaclient.server.facade.tasks.signup.common.SignUpResponse;
import com.example.medicalqnaclient.server.facade.utils.Response;
import com.example.medicalqnaclient.server.facade.utils.Post;
import com.example.medicalqnaclient.server.facade.utils.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PatientSignUpRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static SignUpResponse post(String url, String id, String password) {
        try {
            Response response = Post.getResponse(url, getRequestBody(new Patient(id, password)));
            return getSignUpResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getRequestBody(Patient patient) {
        return JsonFormatter.formatJson(patient);
    }

    private static SignUpResponse getSignUpResponse(Response response) throws Exception {
        SignUpResponse signUpResponse = objectMapper.readValue(response.getBody(), SignUpResponse.class);
        signUpResponse.setStatusCode(response.getStatusCode());
        return signUpResponse;
    }
}

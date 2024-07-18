package com.example.medicalqnaclient.out.network.user.requests;

import com.example.medicalqnaclient.out.network.config.ServerConfig;
import com.example.medicalqnaclient.out.network.user.requests.responses.LoginResponse;
import com.example.medicalqnaclient.out.network.user.requests.responses.Response;
import com.example.medicalqnaclient.out.network.utils.Post;
import com.example.medicalqnaclient.utils.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static LoginResponse post(String id, String password) throws Exception {
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/sign-in";
        String requestBody = getRequestBody(id, password);

        Response response = Post.getResponse(url, requestBody);
        LoginResponse loginResponse = objectMapper.readValue(response.getBody(), LoginResponse.class);
        loginResponse.setStatusCode(response.getStatusCode());

        return loginResponse;
    }

    private static String getRequestBody(String id, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("id", id);
        data.put("pw", password);
        return JsonFormatter.formatJson(data);
    }
}

//package com.example.medicalqnaclient.server.facade.tasks.user.login;
//
//import com.example.medicalqnaclient.server.facade.utils.Response;
//import com.example.medicalqnaclient.server.facade.utils.Post;
//import com.example.medicalqnaclient.server.facade.utils.JsonFormatter;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class LoginRequest {
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    public static LoginResponse post(String url, String id, String pw) throws Exception {
//        Response response = Post.getResponse(url, getRequestBody(new LoginEntity(id, pw)));
//        return getLoginResponse(response);
//    }
//
//    private static String getRequestBody(LoginEntity loginEntity) {
//        return JsonFormatter.formatJson(loginEntity);
//    }
//
//    private static LoginResponse getLoginResponse(Response response) throws Exception {
//        LoginResponse loginResponse = objectMapper.readValue(response.getBody(), LoginResponse.class);
//        loginResponse.setStatusCode(response.getStatusCode());
//        return loginResponse;
//    }
//}

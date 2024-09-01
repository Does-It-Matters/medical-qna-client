package com.example.medicalqnaclient.server.application;

/**
 * 역할: 서버와의 통신 과정 속 복잡한 객체들의 상호작용을 추상화
 * <p>
 * - 설계를 간단히 하면서, 의존도와 결합도 약화 <br>
 * - ISP 적용하여 접근할 필요없는 메소드 접근 제한 <br>
 * </p>
 */
public interface ApplicationServer extends AuthService, QuestionService {
}

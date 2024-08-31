package com.example.medicalqnaclient.page.pages.question.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.page.pages.profile.basic.MyProfileController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 조회 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 질문 조회 화면을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class QuestionViewStrategy extends PageStrategy {

    @Autowired
    public QuestionViewStrategy(QuestionViewController questionViewController) {
        super(questionViewController);
    }
}

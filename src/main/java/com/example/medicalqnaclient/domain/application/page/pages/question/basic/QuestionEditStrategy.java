package com.example.medicalqnaclient.domain.application.page.pages.question.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 수정 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 질문 수정을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class QuestionEditStrategy extends PageStrategy {

    @Autowired
    public QuestionEditStrategy(QuestionEditController questionEditController) {
        super(questionEditController);
    }
}

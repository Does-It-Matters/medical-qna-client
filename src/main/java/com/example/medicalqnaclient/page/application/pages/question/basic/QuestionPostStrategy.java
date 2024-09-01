package com.example.medicalqnaclient.page.application.pages.question.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 등록 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 질문 등록 화면을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class QuestionPostStrategy extends PageStrategy {

    @Autowired
    public QuestionPostStrategy(QuestionPostController questionPostController) {
        super(questionPostController);
    }
}

package com.example.medicalqnaclient.domain.application.page.pages.question;

import com.example.medicalqnaclient.domain.application.page.pages.question.basic.QuestionEditStrategy;
import com.example.medicalqnaclient.domain.application.page.pages.ApplicationPage;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.domain.application.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 수정 페이지 클래스 </b>
 * <p>
 * - 전략 패턴을 활용하여 화면 구성 <br>
 * </p>
 */
@Component
public class QuestionEditPage extends ApplicationPage {
    private final PageStrategy questionEditStrategy;

    @Autowired
    public QuestionEditPage(ReadUserMediator userMediator, QuestionEditStrategy questionEditStrategy) {
        super("Question Edit Page", userMediator, questionEditStrategy);
        this.questionEditStrategy = questionEditStrategy;
    }

    /**
     * <b> 역할: 전략 갱신 메소드 </b>
     * <p>
     * - 전략 선택 <br>
     * </p>
     */
    @Override
    protected void updateStrategy() {
        strategy = questionEditStrategy;
    }
}

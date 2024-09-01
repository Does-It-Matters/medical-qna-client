package com.example.medicalqnaclient.page.application.pages.question;

import com.example.medicalqnaclient.page.application.pages.ApplicationPage;
import com.example.medicalqnaclient.page.application.pages.question.basic.QuestionPostStrategy;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 질문 등록 페이지 클래스 </b>
 * <p>
 * - 전략 패턴을 활용하여 화면 구성 <br>
 * </p>
 */
@Component
public class QuestionPostPage extends ApplicationPage {
    private final PageStrategy questionPostStrategy;

    @Autowired
    public QuestionPostPage(ReadUserMediator userMediator, QuestionPostStrategy questionPostStrategy) {
        super("Question Post Page", userMediator, questionPostStrategy);
        this.questionPostStrategy = questionPostStrategy;
    }

    /**
     * <b> 역할: 전략 갱신 메소드 </b>
     * <p>
     * - 전략 선택 <br>
     * </p>
     */
    @Override
    protected void updateStrategy() {
        strategy = questionPostStrategy;
    }
}

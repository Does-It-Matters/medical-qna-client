package com.example.medicalqnaclient.domain.application.page.navigator;

import com.example.medicalqnaclient.domain.application.page.event.ApplicationListener;
import com.example.medicalqnaclient.page.core.PageNavigator;
import com.example.medicalqnaclient.page.core.Start;
import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageType;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.example.medicalqnaclient.domain.application.page.navigator.ApplicationPageType.START_PAGE;

/**
 * <b> 역할: 페이지 관리자 클래스 </b>
 * <p>
 * - 특정 화면을 보여주는 역할 <br>
 * - {@link ApplicationListener}에 의해 호출되는 객체 <br>
 *   <br>
 * - 컨트롤러와의 의존성을 이벤트로 유연하게 설정 <br>
 *   ex) 이벤트 수신 -> 페이지 관리자 -> 페이지 -> 전략 -> 컨트롤러 -> 이벤트 발행 <br>
 *   <br>
 * - 이벤트 없이는 컨트롤러와 순환 참조 발생 <br>
 *   ex) 페이지 관리자 -> 페이지 -> 전략 -> 컨트롤러 -> 페이지 관리자: 순환 참조 발생 <br>
 * </p>
 */
@Component
public class ApplicationPageNavigator implements PageNavigator, Start {
    private final Map<PageType, Page> pages;
    private Stage stage;
    private int width;
    private int height;

    /**
     * <b> 역할: 생성자 </b>
     * <p>
     * - 페이지 객체를 맵에 저장 <br>
     * </p>
     */
    @Autowired
    public ApplicationPageNavigator(ApplicationPageRegistry applicationPageRegistry) {
        pages = applicationPageRegistry.getPages();
    }

    @Override
    public void start(Stage primaryStage, int width, int height) {
        this.stage = primaryStage;
        this.width = width;
        this.height = height;

        show(START_PAGE);
    }

    @Override
    public void show(PageType type) {
        Page page = pages.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}

package com.example.medicalqnaclient.domain.application.page.pages.profile.basic;

import com.example.medicalqnaclient.domain.application.page.event.ApplicationPublisher;
import com.example.medicalqnaclient.domain.application.mediator.ReadWriteUserMediator;
import com.example.medicalqnaclient.domain.application.page.pages.ApplicationController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 본인 프로필 조회 화면 컨트롤러 클래스 </b>
 * <p>
 * 1. 본인 프로필 조회 UI로 사용자 정보를 표시 <br>
 * 2. 홈 화면 요청 <br>
 * </p>
 */
@Component
public class MyProfileController extends ApplicationController {
    private Label idLabel;
    private Label roleLabel;
    private Button homeButton;

    @Autowired
    public MyProfileController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        idLabel = new Label();
        roleLabel = new Label();
        homeButton = new Button("Home");

        homeButton.setOnAction(e -> onHomeButtonClick());

        layout.getChildren().addAll(idLabel, roleLabel, homeButton);

        initialize();

        return layout;
    }

    /**
     * <b> 역할: 화면 초기화 메소드 </b>
     * <p>
     * - 본인 프로필 정보를 설정 <br>
     * </p>
     */
    protected void initialize() {
//        idLabel.setText("User ID: " + mediator.getCurrentUser().getId());
//        roleLabel.setText("Role: " + mediator.getCurrentUser().getRole());
    }

    /**
     * <b> 역할: 홈 버튼 클릭 시 호출 메소드 </b>
     * <p>
     * - 홈 화면으로 이동 <br>
     * </p>
     */
    protected void onHomeButtonClick() {
        publisher.publishGoHomeEvent();
    }
}
package com.example.medicalqnaclient.page.start.basic;

import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.page.ViewController;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicStartStrategy implements PageStrategy {
    private final ViewController basicStartController;

    @Autowired
    public BasicStartStrategy(BasicStartController basicStartController) {
        this.basicStartController = basicStartController;
    }

    @Override
    public Pane createLayout() {
        return basicStartController.getLayout();
    }
}
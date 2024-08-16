package com.example.medicalqnaclient.page.manager.monitor.system;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.core.PageType;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SystemResourcePageManager implements PageManager {
    private final Map<PageType, Page> PAGES = new HashMap<>();
    private Stage stage;
    private int width;
    private int height;

    @Autowired
    public SystemResourcePageManager() {
    }

    @Override
    public void show(PageType type) {
        Page page = PAGES.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}

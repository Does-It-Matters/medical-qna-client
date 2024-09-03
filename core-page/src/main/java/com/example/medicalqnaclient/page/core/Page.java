package com.example.medicalqnaclient.page.core;

import javafx.scene.Scene;

public interface Page {
    Scene getScene(int width, int height);
    String getTitle();
}

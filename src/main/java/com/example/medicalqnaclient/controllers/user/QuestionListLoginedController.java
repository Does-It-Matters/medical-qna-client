package com.example.medicalqnaclient.controllers.user;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.login.Role;
import com.example.medicalqnaclient.login.Session;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionListLoginedController {

    @FXML
    private MenuButton userNameMenuButton;

    @FXML
    protected void initialize() {
        setUsername();
        setRoleMenu();
    }

    private void setUsername() {
        String username = Session.getUsername();

        if (username != null) {
            userNameMenuButton.setText(username);
            System.out.println(username);
        }
    }

    private void setRoleMenu() {
        Role role = Session.getRole();

        switch (role) {
            case PATIENT -> setPatientMenu();
            case DOCTOR -> setDoctorMenu();
            case ADMIN -> setAdminMenu();
            default -> setPatientMenu();
        };
    }

    private void setPatientMenu() {
        List<MenuItem> items = new ArrayList<>();

        items.add(createMenuItem("Write post", "write-post.fxml"));
        items.add(createMenuItem("My Posts", "my-posts.fxml"));
        items.add(createMenuItem("My Comments", "my-comments.fxml"));

        updateMenuButtonItems(items);
    }

    private void setDoctorMenu() {
        List<MenuItem> items = new ArrayList<>();
        items.add(createMenuItem("My Comments", "my-comments.fxml"));

        updateMenuButtonItems(items);
    }

    private void setAdminMenu() {
        List<MenuItem> items = new ArrayList<>();
        items.add(createMenuItem("System Monitoring", "system-monitoring.fxml"));

        updateMenuButtonItems(items);
    }

    private MenuItem createMenuItem(String text, String view) {
        MenuItem item = new MenuItem(text);
        item.setOnAction(event -> {
            try {
                HelloApplication.setRoot(view);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return item;
    }

    private void updateMenuButtonItems(List<MenuItem> items) {
        ObservableList<MenuItem> existingItems = userNameMenuButton.getItems();
        existingItems.clear();
        existingItems.addAll(items);
    }

    @FXML
    protected void onLogoutButtonClick() {
        try {
            HelloApplication.setRoot("question-list-view.fxml");
            Session.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

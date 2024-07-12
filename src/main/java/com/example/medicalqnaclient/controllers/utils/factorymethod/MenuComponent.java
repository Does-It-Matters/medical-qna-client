package com.example.medicalqnaclient.controllers.utils.factorymethod;

import com.example.medicalqnaclient.HelloApplication;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {
    private MenuButton userNameMenuButton;
    protected List<MenuItem> items;

    public MenuComponent(MenuButton userNameMenuButton) {
        items = new ArrayList<>();
        items.add(createMenuItem("My Profile", "my-profile.fxml"));

        this.userNameMenuButton = userNameMenuButton;

        setMenuItem();
        updateMenuButtonItems();
    }

    abstract protected void setMenuItem();


    private void updateMenuButtonItems() {
        ObservableList<MenuItem> existingItems = userNameMenuButton.getItems();
        existingItems.clear();
        existingItems.addAll(items);
    }

    public void setUsername(String username) {
        userNameMenuButton.setText(username);
    }

    protected final MenuItem createMenuItem(String text, String view) {
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
}

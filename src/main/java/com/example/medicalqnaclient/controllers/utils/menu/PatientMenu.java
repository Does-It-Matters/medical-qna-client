package com.example.medicalqnaclient.controllers.utils.menu;

import com.example.medicalqnaclient.controllers.utils.factorymethod.MenuComponent;
import javafx.scene.control.MenuButton;

public class PatientMenu extends MenuComponent {
    public PatientMenu(MenuButton userNameMenuButton) {
        super(userNameMenuButton);
    }

    @Override
    protected void setMenuItem() {
        items.add(createMenuItem("Write post", "write-post.fxml"));
        items.add(createMenuItem("My Posts", "my-posts.fxml"));
        items.add(createMenuItem("My Comments", "my-comments.fxml"));
    }
}

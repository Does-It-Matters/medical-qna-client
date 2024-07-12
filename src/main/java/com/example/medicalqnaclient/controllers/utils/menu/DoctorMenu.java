package com.example.medicalqnaclient.controllers.utils.menu;

import com.example.medicalqnaclient.controllers.utils.factorymethod.MenuComponent;
import javafx.scene.control.MenuButton;

public class DoctorMenu extends MenuComponent {
    public DoctorMenu(MenuButton userNameMenuButton) {
        super(userNameMenuButton);
    }

    @Override
    protected void setMenuItem() {
        items.add(createMenuItem("My Comments", "my-comments.fxml"));
    }
}

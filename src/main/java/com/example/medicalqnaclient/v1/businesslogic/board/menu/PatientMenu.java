package com.example.medicalqnaclient.v1.businesslogic.board.menu;

import com.example.medicalqnaclient.v1.businesslogic.board.menu.factorymethod.MenuComponent;
import javafx.scene.control.MenuButton;

public class PatientMenu extends MenuComponent {
    public PatientMenu(MenuButton userNameMenuButton) {
        super(userNameMenuButton);
    }

    @Override
    protected void setMenuItem() {
        items.add(createMenuItem("Write post", "write-post.fxml"));
    }
}

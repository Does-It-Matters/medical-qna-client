package com.example.medicalqnaclient.v1.businesslogic.board.menu;

import com.example.medicalqnaclient.v1.businesslogic.board.menu.factorymethod.MenuComponent;
import javafx.scene.control.MenuButton;

public class AdminMenu extends MenuComponent {
    public AdminMenu(MenuButton userNameMenuButton) {
        super(userNameMenuButton);
    }

    @Override
    protected void setMenuItem() {
        items.add(createMenuItem("System Monitoring", "system-monitoring.fxml"));
    }
}

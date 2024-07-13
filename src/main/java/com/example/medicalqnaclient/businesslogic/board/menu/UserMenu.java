package com.example.medicalqnaclient.businesslogic.board.menu;

import com.example.medicalqnaclient.businesslogic.board.menu.factorymethod.MenuComponent;
import com.example.medicalqnaclient.businesslogic.board.menu.factorymethod.MenuFactory;
import com.example.medicalqnaclient.businesslogic.user.Role;
import javafx.scene.control.MenuButton;

public class UserMenu {
    private MenuComponent menu;

    public UserMenu(MenuButton userNameMenuButton, Role role) {
        menu = MenuFactory.getInstance(userNameMenuButton, role);
    }

    public void setUsername(String username) {
        menu.setUsername(username);
    }
}

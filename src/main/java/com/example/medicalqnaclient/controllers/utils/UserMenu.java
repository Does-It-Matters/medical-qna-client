package com.example.medicalqnaclient.controllers.utils;

import com.example.medicalqnaclient.controllers.utils.factorymethod.MenuComponent;
import com.example.medicalqnaclient.controllers.utils.factorymethod.MenuFactory;
import com.example.medicalqnaclient.login.Role;
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

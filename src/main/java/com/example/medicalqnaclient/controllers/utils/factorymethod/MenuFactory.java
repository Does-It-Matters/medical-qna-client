package com.example.medicalqnaclient.controllers.utils.factorymethod;

import com.example.medicalqnaclient.controllers.utils.menu.AdminMenu;
import com.example.medicalqnaclient.controllers.utils.menu.DoctorMenu;
import com.example.medicalqnaclient.controllers.utils.menu.PatientMenu;
import com.example.medicalqnaclient.login.Role;
import javafx.scene.control.MenuButton;

public interface MenuFactory {
    static MenuComponent getInstance(MenuButton userNameMenuButton, Role role) {
        return switch (role) {
            case PATIENT -> new PatientMenu(userNameMenuButton);
            case DOCTOR -> new DoctorMenu(userNameMenuButton);
            case ADMIN -> new AdminMenu(userNameMenuButton);
            default -> new PatientMenu(userNameMenuButton);
        };
    }
}

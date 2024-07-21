package com.example.medicalqnaclient.utils.businesslogic.board.menu.factorymethod;

import com.example.medicalqnaclient.utils.businesslogic.board.menu.AdminMenu;
import com.example.medicalqnaclient.utils.businesslogic.board.menu.DoctorMenu;
import com.example.medicalqnaclient.utils.businesslogic.board.menu.PatientMenu;
import com.example.medicalqnaclient.utils.businesslogic.user.Role;
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

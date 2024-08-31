package com.example.medicalqnaclient.page.manager.core;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.pages.application.home.HomePage;
import com.example.medicalqnaclient.page.pages.application.login.LoginPage;
import com.example.medicalqnaclient.page.pages.application.profile.MyProfilePage;
import com.example.medicalqnaclient.page.pages.application.question.QuestionEditPage;
import com.example.medicalqnaclient.page.pages.application.question.QuestionPostPage;
import com.example.medicalqnaclient.page.pages.application.question.QuestionViewPage;
import com.example.medicalqnaclient.page.pages.application.up.doctor.DoctorSignUpPage;
import com.example.medicalqnaclient.page.pages.application.up.patient.PatientSignUpPage;
import com.example.medicalqnaclient.page.pages.application.start.StartPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PageRegistry {
    private final Map<PageType, Page> applicationPages = new HashMap<>();
    private final Map<PageType, Page> testPages = new HashMap<>();
    private final Map<PageType, Page> systemResourcePages = new HashMap<>();
    private final Map<PageType, Page> logPages = new HashMap<>();

    @Autowired
    public PageRegistry(
            StartPage startPage,
            HomePage homePage,
            LoginPage loginPage,
            DoctorSignUpPage doctorSignUpPage,
            PatientSignUpPage patientSignUpPage,
            MyProfilePage myProfilePage,
            QuestionViewPage questionViewPage,
            QuestionPostPage questionPostPage,
            QuestionEditPage questionEditPage
    ) {
        applicationPages.put(PageType.START_PAGE, startPage);
        applicationPages.put(PageType.HOME_PAGE, homePage);
        applicationPages.put(PageType.LOGIN_PAGE, loginPage);
        applicationPages.put(PageType.DOCTOR_SIGN_UP_PAGE, doctorSignUpPage);
        applicationPages.put(PageType.PATIENT_SIGN_UP_PAGE, patientSignUpPage);
        applicationPages.put(PageType.MY_PROFILE_PAGE, myProfilePage);
        applicationPages.put(PageType.QUESTION_VIEW_PAGE, questionViewPage);
        applicationPages.put(PageType.QUESTION_POST_PAGE, questionPostPage);
        applicationPages.put(PageType.QUESTION_EDIT_PAGE, questionEditPage);
    }

    public Map<PageType, Page> getApplicationPages() {
        return applicationPages;
    }

    public Map<PageType, Page> getTestPages() {
        return testPages;
    }

    public Map<PageType, Page> getSystemResourcePages() {
        return systemResourcePages;
    }

    public Map<PageType, Page> getLogPages() {
        return logPages;
    }
}
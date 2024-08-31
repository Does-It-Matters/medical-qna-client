package com.example.medicalqnaclient.page.manager.core;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.pages.home.HomePage;
import com.example.medicalqnaclient.page.pages.login.LoginPage;
import com.example.medicalqnaclient.page.pages.profile.MyProfilePage;
import com.example.medicalqnaclient.page.pages.question.QuestionEditPage;
import com.example.medicalqnaclient.page.pages.question.QuestionPostPage;
import com.example.medicalqnaclient.page.pages.question.QuestionViewPage;
import com.example.medicalqnaclient.page.pages.sign.up.doctor.DoctorSignUpPage;
import com.example.medicalqnaclient.page.pages.sign.up.patient.PatientSignUpPage;
import com.example.medicalqnaclient.page.pages.start.StartPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PageRegistry {
    private final Map<PageType, Page> applicationPages = new HashMap<>();

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
}
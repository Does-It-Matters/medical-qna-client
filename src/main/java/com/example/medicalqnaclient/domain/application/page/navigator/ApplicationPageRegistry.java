package com.example.medicalqnaclient.domain.application.page.navigator;

import com.example.medicalqnaclient.domain.application.page.pages.home.HomePage;
import com.example.medicalqnaclient.domain.application.page.pages.login.LoginPage;
import com.example.medicalqnaclient.domain.application.page.pages.profile.MyProfilePage;
import com.example.medicalqnaclient.domain.application.page.pages.question.QuestionEditPage;
import com.example.medicalqnaclient.domain.application.page.pages.question.QuestionPostPage;
import com.example.medicalqnaclient.domain.application.page.pages.question.QuestionViewPage;
import com.example.medicalqnaclient.domain.application.page.pages.signup.doctor.DoctorSignUpPage;
import com.example.medicalqnaclient.domain.application.page.pages.signup.patient.PatientSignUpPage;
import com.example.medicalqnaclient.domain.application.page.pages.start.ApplicationStartPage;
import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageRegistry;
import com.example.medicalqnaclient.page.core.PageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.domain.application.page.navigator.ApplicationPageType.*;

@Component
public class ApplicationPageRegistry implements PageRegistry {
    private final Map<PageType, Page> applicationPages = new HashMap<>();

    @Autowired
    public ApplicationPageRegistry(
            ApplicationStartPage applicationStartPage,
            HomePage homePage,
            LoginPage loginPage,
            DoctorSignUpPage doctorSignUpPage,
            PatientSignUpPage patientSignUpPage,
            MyProfilePage myProfilePage,
            QuestionViewPage questionViewPage,
            QuestionPostPage questionPostPage,
            QuestionEditPage questionEditPage
    ) {
        applicationPages.put(START_PAGE, applicationStartPage);
        applicationPages.put(HOME_PAGE, homePage);
        applicationPages.put(LOGIN_PAGE, loginPage);
        applicationPages.put(DOCTOR_SIGN_UP_PAGE, doctorSignUpPage);
        applicationPages.put(PATIENT_SIGN_UP_PAGE, patientSignUpPage);
        applicationPages.put(MY_PROFILE_PAGE, myProfilePage);
        applicationPages.put(QUESTION_VIEW_PAGE, questionViewPage);
        applicationPages.put(QUESTION_POST_PAGE, questionPostPage);
        applicationPages.put(QUESTION_EDIT_PAGE, questionEditPage);
    }

    @Override
    public Map<PageType, Page> getPages() {
        return applicationPages;
    }
}
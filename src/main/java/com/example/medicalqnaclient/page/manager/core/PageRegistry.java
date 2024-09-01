package com.example.medicalqnaclient.page.manager.core;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.pages.application.home.HomePage;
import com.example.medicalqnaclient.page.pages.application.login.LoginPage;
import com.example.medicalqnaclient.page.pages.application.profile.MyProfilePage;
import com.example.medicalqnaclient.page.pages.application.question.QuestionEditPage;
import com.example.medicalqnaclient.page.pages.application.question.QuestionPostPage;
import com.example.medicalqnaclient.page.pages.application.question.QuestionViewPage;
import com.example.medicalqnaclient.page.pages.application.signup.doctor.DoctorSignUpPage;
import com.example.medicalqnaclient.page.pages.application.signup.patient.PatientSignUpPage;
import com.example.medicalqnaclient.page.pages.application.start.ApplicationStartPage;
import com.example.medicalqnaclient.page.pages.log.start.LogStartPage;
import com.example.medicalqnaclient.page.pages.resource.start.ResourceStartPage;
import com.example.medicalqnaclient.page.pages.test.start.TestStartPage;
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
            ApplicationStartPage applicationStartPage,
            HomePage homePage,
            LoginPage loginPage,
            DoctorSignUpPage doctorSignUpPage,
            PatientSignUpPage patientSignUpPage,
            MyProfilePage myProfilePage,
            QuestionViewPage questionViewPage,
            QuestionPostPage questionPostPage,
            QuestionEditPage questionEditPage,
            TestStartPage testStartPage,
            ResourceStartPage resourceStartPage,
            LogStartPage logStartPage
    ) {
        applicationPages.put(PageType.START_PAGE, applicationStartPage);
        applicationPages.put(PageType.HOME_PAGE, homePage);
        applicationPages.put(PageType.LOGIN_PAGE, loginPage);
        applicationPages.put(PageType.DOCTOR_SIGN_UP_PAGE, doctorSignUpPage);
        applicationPages.put(PageType.PATIENT_SIGN_UP_PAGE, patientSignUpPage);
        applicationPages.put(PageType.MY_PROFILE_PAGE, myProfilePage);
        applicationPages.put(PageType.QUESTION_VIEW_PAGE, questionViewPage);
        applicationPages.put(PageType.QUESTION_POST_PAGE, questionPostPage);
        applicationPages.put(PageType.QUESTION_EDIT_PAGE, questionEditPage);

        testPages.put(PageType.TEST_START_PAGE, testStartPage);

        systemResourcePages.put(PageType.RESOURCE_START_PAGE, resourceStartPage);

        logPages.put(PageType.LOG_START_PAGE, logStartPage);
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
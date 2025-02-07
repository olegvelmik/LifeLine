package com.scenario_projects.lifeline_front_stage.tests;

import com.scenario_projects.lifeline_front_stage.actionHelpers.LoginHelper;
import com.scenario_projects.lifeline_front_stage.dataProvider.LoginDataProvider;
import com.scenario_projects.lifeline_front_stage.pages.MessagesPage;
import com.scenario_projects.lifeline_front_stage.pages.SideBarPanel;
import com.scenario_projects.lifeline_front_stage.utils.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class N_0012_RefreshMessagesPageTest extends BaseTest {
    private final String nameMenu = "Messages";

    @BeforeMethod
    public void login() {
        driver.get(baseUrl);

        LoginHelper login = new LoginHelper(driver);
        login.login(LoginDataProvider.email, LoginDataProvider.password);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void refreshMessagesPage() {

        //Go to Messages page
        SideBarPanel sideBarPanel = new SideBarPanel(driver);
        sideBarPanel.chooseMenuItem(nameMenu);

        //Verify that tabs buttons are present on messages page
        MessagesPage messagesPage = new MessagesPage(driver);
        Assert.assertTrue(messagesPage.tabsButtonsArePresent(), "Failed! Messages page is not loaded!");

        messagesPage.clickRefreshButton();

        Assert.assertTrue(messagesPage.tabsButtonsArePresent(), "Failed! Messages page is not loaded!");
    }
}

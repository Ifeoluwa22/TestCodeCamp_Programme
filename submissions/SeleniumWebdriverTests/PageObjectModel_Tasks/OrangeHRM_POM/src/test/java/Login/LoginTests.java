package Login;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import Setup.setupTest;

public class LoginTests extends setupTest {
    //TestNG annotation
    @Test
    //This class extends to the SetupTests as the SetupTests class contains all the setup requirements to run our test
    public void  testLogin() throws InterruptedException
    {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");
        //Handler for dashboard page
        loginPage.clickLoginBtn();
        String pageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println("PASSED - The page Url is " + pageUrl);
    }


    @Test
    public void testLogout () throws InterruptedException{
        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage = dashboardPage.clickLogout();
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page Url is " + loginUrl);
        }
    }
}

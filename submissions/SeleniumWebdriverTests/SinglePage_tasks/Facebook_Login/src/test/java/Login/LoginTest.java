package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://web.facebook.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                //locate the username field. Use your own valid username
        driver.findElement(By.id("email")).sendKeys("07068550074");               //locate the email field. Use your own valid password
        driver.findElement(By.id("pass")).sendKeys("Oseyemi@10");               //click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();                              //wait to see users logged in page
        Thread.sleep(5000);                                                                         //Test to confirm user logged in
        if (driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("PASSED - User has successfully logged in");
        } else {
            System.out.println("FAILED- The User was unable to login");
        }

        Thread.sleep(5000);
        //Waiting to see logged in page
    }

    @Test
    public void logoutTest() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]")).click();       //click on the arrow button that has the logout menu on the list
        Thread.sleep(5000);             //wait to ensure the dropdown list is displayed
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div")).click();         //Click on the logout button
        //test to confirm if user logged out
        if (driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("PASSED - User has successfully logged out");
        } else {
            System.out.println("FAILED - The user is still logged in");
        }
        Thread.sleep(5000);
        //Waiting to see logged out page
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }                 //quit the browser session


    //Initiate the test run command
    public static void main(String args[]) throws InterruptedException {
        LoginTest test = new LoginTest();
        test.setUp();
    }
}

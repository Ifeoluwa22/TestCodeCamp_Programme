package Konga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KongaTests {
    private WebDriver driver;


    @BeforeClass
    public void setUp () throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");        //This enables selenium to know which browser to use to run the test
        // We'll be using chrome to run this test, if we were using firefox or another browser there would be a different line of code
        driver = new ChromeDriver();        //Instantiate webdriver object
        driver.get("https://www.konga.com/");               //Open the given Url
        Thread.sleep(1000);
        driver.manage().window().maximize();                //To maximize the window size of the web browser
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void mainTest() throws InterruptedException {

        //Click the login/signup button on the homepage
        driver.findElement(By.linkText("Login / Signup")).click();
        Thread.sleep(4000);

        //input the login details
        driver.findElement(By.id("username")).sendKeys("adeboyeifeoluwa1@gmail.com");   //Enter Username
        driver.findElement(By.id("password")).sendKeys("T$G4#ZRzZYjvWDR");             //Enter password

        //Click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //CLick on the Computers option in the Accessories bar
        driver.findElement(By.linkText("Computers and Accessories")).click();
        Thread.sleep(15000);

        //Click on the Laptops Category
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(5000);

        //Click on the Apple Macbook Category
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a")).click();
        Thread.sleep(6000);

        //Add an item to Cart by clicking on the add to cart button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[4]/button")).click();
        Thread.sleep(5000);

        //Click on your cart that should now contain what you added
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div/div/a[2]")).click();
        Thread.sleep(5000);

        //Click on the checkout button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);

        //On the check out page click on Select Delivery Address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/div/div")).click();
        Thread.sleep(10000);

        // Select the address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();

        //Click on the use this address button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div")).click();
        Thread.sleep(5000);

        //Click on PAY NOW
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/form/div/section/div/div[4]/form/ul/li[1]/div/button")).click();
        Thread.sleep(5000);

        //Click on Continue to Payment
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/form/div/section/div/div[9]/div/button")).click();
        Thread.sleep(15000);

        //Select the iFrame that pops up for payment
        WebElement iframe = driver.findElement(By.xpath("/html/body/div[8]/iframe"));
        driver.switchTo().frame(iframe);

        // Click on the Card Payment method
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div[1]/div[2]/div/div[2]")).click();

        //Input Card details
        driver.findElement(By.id("card-number")).sendKeys("5399272926302778");      //input card number
        driver.findElement(By.id("expiry")).sendKeys("0923");                       //input expiry date
        driver.findElement(By.id("cvv")).sendKeys("420");                           //input CVV number

        //Click on the input box for Pin
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[4]/div[2]/input")).click();
        //click on the pin numbers
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[4]/div[3]/button[3]")).click();
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[4]/div[3]/button[10]")).click();
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[4]/div[3]/button[4]")).click();
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[4]/div[3]/button[5]")).click();

        //Print the error message gotten
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        String errorMessage = error.getText();
        System.out.println(errorMessage);
        Thread.sleep(10000);

        //Close the iFrame that displays the input card modal
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("kpg-frame-component-container")));
        driver.findElement(By.className("data-card__close")).click() ;
        Thread.sleep(4000);

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}

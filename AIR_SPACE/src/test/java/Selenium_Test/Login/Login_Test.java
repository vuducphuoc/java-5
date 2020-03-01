package Selenium_Test.Login;

import Selenium_Test.Contant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_Test {
    private String baseUrl = "http://localhost:8080/vn.airspace.com/login";

    private WebDriver driver;
    private WebElement btnLogin;
    private WebElement txtEmail;
    private WebElement pwfPassword;

    @BeforeTest(groups = {"email", "password", "all"})
    public void launchBrowser() {
        System.out.println("Launch chrome browser");
        System.setProperty("webdriver.chrome.driver", Contant.CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.get(baseUrl);

        btnLogin = driver.findElement(By.id("btnLogin"));
        txtEmail = driver.findElement(By.id("email"));
        pwfPassword = driver.findElement(By.id("password"));
    }

    @AfterTest(groups = {"email", "password", "all"})
    public void closeBrowser() {
        System.out.println("Close chrome browser");
        driver.close();
    }

    @AfterMethod
    private void afterMethod() {
        driver.navigate().refresh();
    }

    @Parameters({"email", "visible"})
    @Test(groups = "email")
    public void Test_Email(String email, boolean visible) {
        txtEmail.sendKeys(email);

        btnLogin.click();

        WebElement errorEmail = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/form/div[1]/div"));

        Assert.assertEquals(errorEmail.isDisplayed(), visible);
    }

    @Parameters({"password", "visible"})
    @Test(groups = "password")
    public void Test_Password(String password, boolean visible) {
        pwfPassword.sendKeys(password);

        btnLogin.click();

        WebElement errorPassword = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/form/div[2]/div"));

        Assert.assertEquals(errorPassword.isDisplayed(), visible);
    }

    @Parameters({"email", "password", "url"})
    @Test(groups = "all")
    public void Test_All(String email, String password, String url) {
        txtEmail.sendKeys(email);
        pwfPassword.sendKeys(password);

        btnLogin.click();

        String actual = driver.getCurrentUrl();

        Assert.assertEquals(actual, url);
    }
}

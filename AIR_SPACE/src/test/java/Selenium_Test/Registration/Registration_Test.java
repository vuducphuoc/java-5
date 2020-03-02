package Selenium_Test.Registration;

import Selenium_Test.Contant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Registration_Test {

    private String URL = "http://localhost:8080/vn.airspace.com/register";

    private WebDriver webDriver;
    private WebElement btnSignUp;
    private WebElement txtEmail;
    private WebElement txtName;
    private WebElement pwfPassword;
    private WebElement pwfRe_Password;

    @BeforeTest(groups = {"all", "name", "email", "password", "repassword"})
    public void launchBrowser() {
        System.out.println("Launch chrome browser");
        System.setProperty("webdriver.chrome.driver", Contant.CHROME_DRIVER);
        webDriver = new ChromeDriver();
        webDriver.get(URL);

        txtName = webDriver.findElement(By.id("name"));
        txtEmail = webDriver.findElement(By.id("email"));
        pwfPassword = webDriver.findElement(By.id("password"));
        pwfRe_Password = webDriver.findElement(By.id("repassword"));
        btnSignUp = webDriver.findElement(By.id("btn-register"));
    }

    @AfterTest(groups = {"all", "name", "email", "password", "repassword"})
    public void closeBrowser() {
        System.out.println("Close chrome browser");
        webDriver.close();
    }

    @AfterMethod
    private void afterMethod() {
        webDriver.navigate().refresh();
    }

    @Parameters({"name", "visible"})
    @Test(groups = "name")
    public void Test_Name(String name, boolean visible) {
        txtName.sendKeys(name);
        btnSignUp.click();

        WebElement error = webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/form/div[1]/div"));

        Assert.assertEquals(error.isDisplayed(), visible);
    }

    @Parameters({"email", "visible"})
    @Test(groups = "email")
    public void Test_Email(String email, boolean visible) {
        txtEmail.sendKeys(email);
        btnSignUp.click();

        WebElement error = webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/form/div[2]/div"));

        Assert.assertEquals(error.isDisplayed(), visible);
    }

    @Parameters({"password", "visible"})
    @Test(groups = "password")
    public void Test_Password(String password, boolean visible) {
        pwfPassword.sendKeys(password);
        btnSignUp.click();

        WebElement error = webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/form/div[3]/div"));

        Assert.assertEquals(error.isDisplayed(), visible);
    }

    @Parameters({"password", "repassword", "visible"})
    @Test(groups = "repassword")
    public void Test_RePassword(String password, String repassword, boolean visible) {
        pwfPassword.sendKeys(password);
        pwfRe_Password.sendKeys(repassword);
        btnSignUp.click();

        WebElement error = webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/form/div[4]/div"));

        Assert.assertEquals(error.isDisplayed(), visible);
    }

    @Parameters({"name", "email", "password", "repassword", "visible"})
    @Test(groups = "all")
    public void Test_All(String name, String email, String password, String repassword, boolean visible) {
        txtName.sendKeys(name);
        txtEmail.sendKeys(email);
        pwfPassword.sendKeys(password);
        pwfRe_Password.sendKeys(repassword);
        btnSignUp.click();

        WebElement alertBox = webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/div"));

        Assert.assertEquals(alertBox.isDisplayed(), visible);
    }
}

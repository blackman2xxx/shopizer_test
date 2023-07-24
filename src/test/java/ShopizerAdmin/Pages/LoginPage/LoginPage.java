package ShopizerAdmin.Pages.LoginPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public String UserName;
    private By usernameInput = By.id("inputUsername1");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By signInBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-auth[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-login[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]");
    private By languageSelect = By.xpath("//nb-action[@class='context-menu-host']");
    private By englishSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-context-menu[1]/nb-menu[1]/ul[1]/li[2]/a[1]/span[1]");
    private By usernameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-home[1]/div[1]/div[2]/div[1]/nb-card[1]/nb-card-body[1]/div[2]/span[1]");
    private By wrongPasswordAlert = By.xpath("//div[@class='form-group row alert-error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void SignIn (String username, String password) throws InterruptedException {
        validateHelper.sendText(usernameInput,username);
        validateHelper.sendText(passwordInput,password);
        validateHelper.clickElement(signInBtn);
        validateHelper.clickElement(languageSelect);
        validateHelper.clickElement(englishSelect);
        Assert.assertEquals(username,validateHelper.getText(usernameGet));
    }
    public void LogInWithInvalidEmail (String username, String password) throws InterruptedException {
        boolean check;
        validateHelper.sendText(usernameInput,"abc");
        validateHelper.sendText(passwordInput,password);
        validateHelper.clickElement(signInBtn);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(languageSelect));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void LogInWithWrongPassword (String username, String password) throws InterruptedException {
        validateHelper.sendText(usernameInput,username);
        validateHelper.sendText(passwordInput,"123");
        validateHelper.clickElement(signInBtn);
        Assert.assertTrue(driver.findElement(wrongPasswordAlert).isDisplayed());
    }
}

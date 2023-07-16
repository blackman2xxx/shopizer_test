package ShopizerUser.Pages.LoginPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class LoginPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public String EmailAddress;
    private By acceptedBtn = By.id("rcc-confirm-button");
    private By accountBtn = By.xpath("//button[@class='account-setting-active']");
    private By loginBtn = By.xpath("//div[@class='account-dropdown active']//ul//div//a[normalize-space()='Login']");
    private By usernameInput = By.xpath("//input[contains(@name,'username')]");
    private By passwordInput = By.xpath("//input[contains(@name,'loginPassword')]");
    private By submitBtn = By.xpath("//div[@class='fade tab-pane active show']//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void Login(String username, String password) throws InterruptedException {
        validateHelper.clickElement(acceptedBtn);
        validateHelper.clickElement(accountBtn);
        validateHelper.clickElement(loginBtn);

        validateHelper.sendText(usernameInput,username);
        validateHelper.sendText(passwordInput,password);

        validateHelper.clickElement(submitBtn);


        //EmailAddress = validateHelper.getText(emailGet);
    }
}

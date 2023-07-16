package ShopizerAdmin.Pages.LoginPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
        UserName = validateHelper.getText(usernameGet);
    }
}

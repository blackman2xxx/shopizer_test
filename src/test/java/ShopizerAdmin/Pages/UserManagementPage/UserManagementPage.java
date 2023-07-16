package ShopizerAdmin.Pages.UserManagementPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;
import static org.bouncycastle.cms.RecipientId.password;

public class UserManagementPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By userManagementTab = By.xpath("//a[@title='User management']");
    private By userAddTab = By.xpath("//span[normalize-space()='Create user']");
    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By merchantStoreInput = By.xpath("//button[normalize-space()='Merchant store']");
    private By merchantStoreSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By repeatPasswordInput = By.id("repeatPassword");
    private By activeCheckInput = By.xpath("(//span[@class='custom-checkbox'])[1]");
    private By languageUserInput = By.xpath("(//button[normalize-space()='Select language'])[1]");
    private By englishUserSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[2]");
    private By adminStoreCheckInput = By.xpath("(//span[@class='custom-checkbox'])[4]");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By getNameList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-users-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[2]");
    private By getEmailList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-users-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[3]");

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }
    public void AddUser () throws InterruptedException {
        validateHelper.clickElement(userManagementTab);
        validateHelper.clickElement(userAddTab);
        validateHelper.sendText(firstNameInput,"Tu");
        validateHelper.sendText(lastNameInput,"Bui");
        validateHelper.clickElement(merchantStoreInput);
        validateHelper.clickElement(merchantStoreSelect);
        validateHelper.sendText(emailInput,"tubui@gmail.com");
        validateHelper.scrollTo(merchantStoreInput);
        validateHelper.sendText(passwordInput,"123456Aa@");
        validateHelper.sendText(repeatPasswordInput,"123456Aa@");
        validateHelper.clickElement(activeCheckInput);
        validateHelper.clickElement(languageUserInput);
        validateHelper.clickElement(englishUserSelect);
        validateHelper.clickElement(adminStoreCheckInput);

        js.executeScript("window.scrollBy(0,-500)", "");
        validateHelper.clickElementwithJS(saveBtn);
    }
    public void ListCheck () {
        Assert.assertEquals("Tu Bui", validateHelper.getText(getNameList));
        Assert.assertEquals("tubui@gmail.com", validateHelper.getText(getEmailList));
    }
}

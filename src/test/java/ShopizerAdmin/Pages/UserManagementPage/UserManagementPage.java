package ShopizerAdmin.Pages.UserManagementPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By adminCheckInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-create-new-user[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[9]/div[1]/nb-checkbox[2]/label[1]/span[1]");
    private By adminRetailerCheckInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-create-new-user[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[9]/div[1]/nb-checkbox[3]/label[1]/span[1]");
    private By adminStoreCheckInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-create-new-user[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[9]/div[1]/nb-checkbox[4]/label[1]/span[1]");
    private By adminCatalogueCheckInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-create-new-user[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[9]/div[1]/nb-checkbox[5]/label[1]/span[1]");
    private By adminOrderCheckInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-user-details[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[9]/div[1]/nb-checkbox[6]/label[1]/span[1]");
    private By adminContentCheckInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-create-new-user[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[9]/div[1]/nb-checkbox[7]/label[1]/span[1]");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By getNameList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-users-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[2]");
    private By getEmailList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-users-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[3]");
    private By invalidEmailAlert = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-create-new-user[1]/div[1]/ngx-user-form[1]/div[1]/nb-card[1]/nb-card-body[1]/form[1]/div[4]/div[1]/span[1]/span[1]");
    private By wrongPasswordAlert = By.xpath("//span[contains(text(),'Passwords do not match.')]");
    private By userBtn = By.xpath("//div[@class='user-container']");
    private By logOutBtn = By.xpath("//a[@title='Log out']");
    private By userList = By.xpath("//span[normalize-space()='Users list']");
    private By editBtn = By.xpath("//body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-user-management[1]/div[1]/div[1]/ngx-users-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[5]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By deleteBtn = By.xpath("//button[normalize-space()='Remove']");

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }
    public void AddUser (String firstname, String lastname, String email, String password) throws InterruptedException {

        String fullname = firstname + " " + lastname;
        validateHelper.clickElement(userManagementTab);
        validateHelper.clickElement(userAddTab);
        validateHelper.sendText(firstNameInput,firstname);
        validateHelper.sendText(lastNameInput,lastname);
        validateHelper.clickElement(merchantStoreInput);
        validateHelper.clickElement(merchantStoreSelect);
        validateHelper.sendText(emailInput,email);
        validateHelper.scrollTo(merchantStoreInput);
        validateHelper.sendText(passwordInput,password);
        validateHelper.sendText(repeatPasswordInput,password);
        validateHelper.clickElement(activeCheckInput);
        validateHelper.clickElement(languageUserInput);
        validateHelper.clickElement(englishUserSelect);
        validateHelper.clickElement(adminCheckInput);
        validateHelper.clickElement(adminRetailerCheckInput);
        validateHelper.clickElement(adminStoreCheckInput);

        js.executeScript("window.scrollBy(0,-500)", "");
        validateHelper.clickElementwithJS(saveBtn);
        ListCheck(fullname,email);
    }
    public void ListCheck (String name, String email) {
        Assert.assertEquals( name, validateHelper.getAttribute(getNameList,"innerText"));
        Assert.assertEquals(email, validateHelper.getText(getEmailList));
    }
    public void Logout() {
        validateHelper.clickElementwithJS(userBtn);
        validateHelper.clickElementwithJS(logOutBtn);
    }
    public void AddUserWithInvalidEmail (String firstname, String lastname, String email, String password) {
        validateHelper.clickElement(userManagementTab);
        validateHelper.clickElement(userAddTab);
        validateHelper.sendText(firstNameInput,firstname);
        validateHelper.sendText(lastNameInput,lastname);
        validateHelper.clickElement(merchantStoreInput);
        validateHelper.clickElement(merchantStoreSelect);
        validateHelper.sendText(emailInput,"abc");
        Assert.assertTrue(driver.findElement(invalidEmailAlert).isDisplayed());
    }
    public void AddUserWithWrongPassWord (String firstname, String lastname, String email, String password) {
        validateHelper.clickElement(userManagementTab);
        validateHelper.clickElement(userAddTab);
        validateHelper.sendText(firstNameInput,firstname);
        validateHelper.sendText(lastNameInput,lastname);
        validateHelper.clickElement(merchantStoreInput);
        validateHelper.clickElement(merchantStoreSelect);
        validateHelper.sendText(emailInput,email);
        validateHelper.scrollTo(merchantStoreInput);
        validateHelper.sendText(passwordInput,password);
        validateHelper.sendText(repeatPasswordInput,"123");
        Assert.assertTrue(driver.findElement(wrongPasswordAlert).isDisplayed());
    }

    public void UserEdit() throws InterruptedException {
        validateHelper.clickElement(userManagementTab);
        validateHelper.clickElement(userList);
        validateHelper.clickElement(editBtn);
        validateHelper.scrollTo(repeatPasswordInput);
        validateHelper.clickElementwithJS(adminOrderCheckInput);
        validateHelper.clickElementwithJS(saveBtn);
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElement(adminOrderCheckInput).isSelected());
    }
    public void UserRemove(){
        boolean check;
        validateHelper.clickElement(userManagementTab);
        validateHelper.clickElement(userList);
        validateHelper.clickElement(editBtn);
        validateHelper.clickElement(deleteBtn);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(editBtn));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
}

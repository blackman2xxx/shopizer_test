package ShopizerAdmin.Pages.StoreManagementPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StoreManagementPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;

    private By storeManagementTab = By.xpath("//a[@title='Store management']");
    private By addStoreTab = By.xpath("//a[@title='Create store']");
    private By storeNameInput = By.id("name");
    private By uniqueStoreCodeInput = By.id("code");
    private By storePhoneInput = By.id("phone");
    private By storeEmailInput = By.id("email");
    private By storeAddressInput = By.id("address");
    private By storeCityInput = By.id("city");
    private By storePostalCodeInput = By.id("postalCode");
    private By supportLanguageInput = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-store-creation[1]/div[1]/ngx-store-form[1]/div[1]/form[1]/nb-card[1]/nb-card-body[1]/div[6]/div[1]/nb-checkbox[2]/label[1]/span[1]");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By getCodeList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[2]");
    private By getStoreNameList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[4]");
    private By getStoreEmailList = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[5]");
    private By storeList = By.xpath("//span[normalize-space()='Stores list']");
    private By editBtn = By.xpath("//body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[6]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("//body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[6]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirm = By.xpath("//button[normalize-space()='Ok']");
    private By nameSearch = By.xpath("//input[@placeholder='Store name']");
    private By nameSearchCheck = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]");
    private By emailSearch = By.xpath("//input[@placeholder='Email']");
    private By emailSearchCheck = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-store-management[1]/div[1]/div[1]/ngx-stores-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[5]");

    public StoreManagementPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }
    public void AddStore (String name, String id, String phone, String email, String address, String city, String postalCode) {
        validateHelper.clickElement(storeManagementTab);
        validateHelper.clickElement(addStoreTab);
        validateHelper.sendText(storeNameInput,name);
        validateHelper.sendText(uniqueStoreCodeInput,id);
        validateHelper.sendText(storePhoneInput,phone);
        validateHelper.sendText(storeEmailInput,email);
        validateHelper.scrollTo(storePhoneInput);

        validateHelper.sendText(storeAddressInput,address);
        validateHelper.sendText(storeCityInput,city);
        validateHelper.sendText(storePostalCodeInput,postalCode);
        validateHelper.clickElement(supportLanguageInput);

        validateHelper.clickElementwithJS(saveBtn);
        ListCheck(id,name,email);
    }
    public void ListCheck (String id, String name, String email) {
        Assert.assertEquals(id,validateHelper.getText(getCodeList));
        Assert.assertEquals(name,validateHelper.getText(getStoreNameList));
        Assert.assertEquals(email,validateHelper.getText(getStoreEmailList));
    }
    public void SearchByName (String name) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(storeManagementTab);
        validateHelper.clickElement(storeList);
        validateHelper.sendText(nameSearch,name);
        validateHelper.sendTextKey(nameSearch, Keys.ENTER);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(nameSearchCheck));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals(name,validateHelper.getText(nameSearchCheck));
    }
    public void SearchByEmail (String email) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(storeManagementTab);
        validateHelper.clickElement(storeList);
        validateHelper.sendText(emailSearch,email);
        validateHelper.sendTextKey(nameSearch, Keys.ENTER);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(emailSearchCheck));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals(email,validateHelper.getText(emailSearchCheck));
    }

    public void EditStore (String id, String name, String email){
        validateHelper.clickElement(storeManagementTab);
        validateHelper.clickElement(storeList);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(storeEmailInput,email);
        validateHelper.clickElementwithJS(saveBtn);
        ListCheck(id,name,email);
    }
    public void RemoveStore () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(storeManagementTab);
        validateHelper.clickElement(storeList);
        validateHelper.clickElement(removeBtn);
        validateHelper.clickElement(removeConfirm);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(removeBtn));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
}

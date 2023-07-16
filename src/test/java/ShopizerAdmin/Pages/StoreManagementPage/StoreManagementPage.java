package ShopizerAdmin.Pages.StoreManagementPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
    public StoreManagementPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }
    public void AddStore () {
        validateHelper.clickElement(storeManagementTab);
        validateHelper.clickElement(addStoreTab);
        validateHelper.sendText(storeNameInput,"Coolmate");
        validateHelper.sendText(uniqueStoreCodeInput,"1234");
        validateHelper.sendText(storePhoneInput,"0987654321");
        validateHelper.sendText(storeEmailInput,"cm@gmail.com");
        validateHelper.scrollTo(storePhoneInput);

        validateHelper.sendText(storeAddressInput,"Cau Giay");
        validateHelper.sendText(storeCityInput,"Ha Noi");
        validateHelper.sendText(storePostalCodeInput,"HN001");
        validateHelper.clickElement(supportLanguageInput);

        validateHelper.clickElementwithJS(saveBtn);
    }
    public void ListCheck () {
        Assert.assertEquals("1234",validateHelper.getText(getCodeList));
        Assert.assertEquals("Coolmate",validateHelper.getText(getStoreNameList));
        Assert.assertEquals("cm@gmail.com",validateHelper.getText(getStoreEmailList));
    }
}

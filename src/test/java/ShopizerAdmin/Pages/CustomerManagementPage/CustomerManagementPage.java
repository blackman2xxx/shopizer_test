package ShopizerAdmin.Pages.CustomerManagementPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerManagementPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By customerManagementTab = By.xpath("//span[normalize-space()='Customer management']");
    private By customerList = By.xpath("//a[@title='Customer List']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By firstnameInput = By.id("first_name");
    private By lastnameInput = By.id("last_name");
    private By usernameInput = By.id("user_name");
    private By companyInput = By.id("billing_company");
    private By streetInput = By.id("billing_address");
    private By cityInput = By.id("billing_city");
    private By countrySelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-add[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[4]/div[1]/div[1]/nb-select[1]");
    private By stateSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-add[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[4]/div[2]/div[1]/nb-select[1]");
    private By postalCodeInput = By.id("billing_postal");
    private By emailInput = By.id("billing_email");
    private By phoneInput = By.id("billing_phone");
    private By languageSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-add[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[6]/div[2]/div[1]/nb-select[1]");
    private By dataNotFoundAlert = By.xpath("//td[normalize-space()='No data found']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By firstnameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By lastnameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By emailGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[5]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[6]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[6]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By updateBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-customer[1]/div[1]/div[1]/ngx-add[1]/div[1]/nb-card-header[1]/div[3]/button[1]");

    public CustomerManagementPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void AddCustomerData(String firstname, String lastname, String username, String company, String street, String city, String postalcode, String email, String phone){
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(firstnameInput,firstname);
        validateHelper.sendText(lastnameInput,lastname);
        validateHelper.sendText(usernameInput,username);
        validateHelper.sendText(companyInput,company);
        validateHelper.sendText(streetInput,street);
        validateHelper.sendText(cityInput,city);
        validateHelper.clickElement(countrySelect);
        validateHelper.clickElementwithJS(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[37]"));
        validateHelper.clickElement(stateSelect);
        validateHelper.clickElementwithJS(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.sendText(postalCodeInput,postalcode);
        validateHelper.sendText(emailInput,email);
        validateHelper.sendText(phoneInput,phone);
        validateHelper.clickElement(languageSelect);
        validateHelper.clickElementwithJS(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.clickElementwithJS(submitBtn);
    }
    public void AddCustomer (String firstname, String lastname, String username, String company, String street, String city, String postalcode, String email, String phone){
        validateHelper.clickElementwithJS(customerManagementTab);
        validateHelper.clickElementwithJS(customerList);
        AddCustomerData(firstname, lastname,username, company, street, city, postalcode, email, phone);
        ListCheck(firstname,lastname,email);
    }
    public void ListCheck (String firstname, String lastname, String email){
        Assert.assertEquals(firstname,validateHelper.getText(firstnameGet));
        Assert.assertEquals(lastname,validateHelper.getText(lastnameGet));
        Assert.assertEquals(email, validateHelper.getText(emailGet));
    }
    public void EditCustomer (String editdata) throws InterruptedException {
        validateHelper.clickElementwithJS(customerManagementTab);
        validateHelper.clickElementwithJS(customerList);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(emailInput,editdata);
        validateHelper.clickElementwithJS(updateBtn);
        Thread.sleep(1000);
        Assert.assertEquals(editdata,validateHelper.getText(emailGet));
    }
    public void RemoveCustomer () throws InterruptedException {
        boolean check;
        validateHelper.clickElementwithJS(customerManagementTab);
        validateHelper.clickElementwithJS(customerList);
        validateHelper.clickElement(removeBtn);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
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

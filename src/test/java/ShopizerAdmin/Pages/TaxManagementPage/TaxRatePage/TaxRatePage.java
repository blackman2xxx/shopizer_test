package ShopizerAdmin.Pages.TaxManagementPage.TaxRatePage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TaxRatePage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By taxManagementTab = By.xpath("//span[normalize-space()='Tax management']");
    private By taxRateTab = By.xpath("//span[normalize-space()='Tax Rate']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By countrySelect = By.xpath("//nb-card-body/div[1]/div[1]/div[1]/nb-select[1]");
    private By stateSelect = By.xpath("//nb-card-body/div[1]/div[2]/div[1]/nb-select[1]");
    private By nameInput = By.xpath("//input[@placeholder='Tax Rate Name']");
    private By codeInput = By.xpath("//input[@placeholder='Tax Rate Code']");
    private By rateInput = By.xpath("//input[@placeholder='Tax Rate']");
    private By compoundCheckbox = By.xpath("//span[@class='custom-checkbox']");
    private By orderInput = By.xpath("//input[@placeholder='Order']");
    private By classSelect = By.xpath("//button[normalize-space()='Select Tax Class Name']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By dataNotFoundAlert = By.xpath("//td[normalize-space()='No data found']");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[5]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By taxRateGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[6]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By orderGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[7]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By compoundGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[8]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]/input[1]");
    private By classGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[9]");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[10]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-rate-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[10]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeCofirm = By.xpath("//button[normalize-space()='Ok']");
    private By updateBtn = By.xpath("//button[normalize-space()='Update']");
    private By duplicateCodeAlert = By.xpath("//span[@class='err-message ng-star-inserted']");

    public TaxRatePage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void AddRate (String name, String code, String rate, String order){
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxRateTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(countrySelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[37]"));
        validateHelper.clickElement(stateSelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(rateInput,rate);
        validateHelper.clickElementwithJS(compoundCheckbox);
        validateHelper.sendText(orderInput,order);
        validateHelper.clickElement(classSelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.clickElementwithJS(submitBtn);
        ListCheck(name,code,rate,order);
    }
    public void ListCheck (String name, String code, String rate, String order){
        Assert.assertEquals(code,validateHelper.getText(codeGet));
        Assert.assertEquals(name,validateHelper.getText(nameGet));
        Assert.assertEquals(rate,validateHelper.getText(taxRateGet));
        Assert.assertEquals(order,validateHelper.getText(orderGet));
        Assert.assertTrue(driver.findElement(compoundGet).isSelected());
        Assert.assertEquals("Class 2",validateHelper.getText(classGet));
    }
    public void AddRateSameCode (String name, String code, String rate, String order) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxRateTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(countrySelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[37]"));
        validateHelper.clickElement(stateSelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(rateInput,rate);
        Assert.assertTrue(driver.findElement(duplicateCodeAlert).isDisplayed());
        validateHelper.clickElementwithJS(compoundCheckbox);
        validateHelper.sendText(orderInput,order);
        validateHelper.clickElement(classSelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.clickElementwithJS(submitBtn);
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(codeGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void EditRate (String editdata) throws InterruptedException {
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxRateTab);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(rateInput,editdata);
        validateHelper.clickElementwithJS(compoundCheckbox);
        validateHelper.clickElement(classSelect);
        validateHelper.clickElement(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));
        validateHelper.clickElementwithJS(updateBtn);
        Thread.sleep(1000);
        Assert.assertEquals(editdata,validateHelper.getText(taxRateGet));
    }
    public void RemoveRate () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxRateTab);
        validateHelper.clickElement(removeBtn);
        validateHelper.clickElement(removeCofirm);
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

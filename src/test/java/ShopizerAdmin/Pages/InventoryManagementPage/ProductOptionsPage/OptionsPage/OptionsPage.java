package ShopizerAdmin.Pages.InventoryManagementPage.ProductOptionsPage.OptionsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OptionsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By productOptionsPage = By.xpath("//a[@title='Product Options / property']");
    private By optionsPage = By.xpath("//a[@title='List of product options / property']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By codeInput = By.id("code");
    private By nameInput = By.id("name");
    private By typeInput = By.xpath("//button[normalize-space()='Type']");
    private By textOptionSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[4]");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-options[1]/div[1]/div[1]/ngx-options-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By duplicateIDAlert = By.xpath("//span[@class='err-message ng-star-inserted']");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-options[1]/div[1]/div[1]/ngx-options-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[6]/td[4]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-options[1]/div[1]/div[1]/ngx-options-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[6]/td[4]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirm = By.xpath("//button[contains(text(),'Ok')]");

    public OptionsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddOption (String code, String name){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productOptionsPage);
        validateHelper.clickElement(optionsPage);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(typeInput);
        validateHelper.clickElement(textOptionSelect);
        validateHelper.clickElementwithJS(submitBtn);
        ListCheck(name);

    }
    public void AddOptionData (String code, String name){
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(typeInput);
        validateHelper.clickElement(textOptionSelect);
        validateHelper.clickElementwithJS(submitBtn);
    }
    public void ListCheck (String name){
        Assert.assertEquals(name,validateHelper.getText(nameGet));
//        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
    public void AddOptionSameID (String code, String name){
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productOptionsPage);
        validateHelper.clickElement(optionsPage);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(typeInput);
        validateHelper.clickElement(textOptionSelect);
        Assert.assertTrue(driver.findElement(duplicateIDAlert).isDisplayed());
        validateHelper.clickElementwithJS(submitBtn);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(nameGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void EditOption (String editnamedata){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productOptionsPage);
        validateHelper.clickElement(optionsPage);
        validateHelper.clickElementwithJS(editBtn);
        validateHelper.sendText(nameInput, editnamedata);
        validateHelper.clickElement(submitBtn);
        driver.navigate().refresh();
        Assert.assertEquals(editnamedata,validateHelper.getAttribute(nameInput, "value"));
    }
    public void RemoveOption () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productOptionsPage);
        validateHelper.clickElement(optionsPage);
        validateHelper.clickElementwithJS(removeBtn);
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

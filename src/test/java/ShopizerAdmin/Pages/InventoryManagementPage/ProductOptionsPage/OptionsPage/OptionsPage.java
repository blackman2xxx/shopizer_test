package ShopizerAdmin.Pages.InventoryManagementPage.ProductOptionsPage.OptionsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
}

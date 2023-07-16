package ShopizerAdmin.Pages.InventoryManagementPage.ProductOptionsPage.ValuesPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;

public class ValuesPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By productOptionsPage = By.xpath("//a[@title='Product Options / property']");
    private By valuesPage = By.xpath("//a[@title='Options values / property values']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By codeInput = By.id("code");
    private By nameInput = By.id("name");
    private By imageUpload = By.xpath("//button[normalize-space()='Add image']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");

    public ValuesPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddValue (String code, String name, String path) throws AWTException {
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productOptionsPage);
        validateHelper.clickElement(valuesPage);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        validateHelper.uploadFile(imageUpload,path);
        validateHelper.clickElementwithJS(submitBtn);
        Assert.assertTrue(driver.findElement(createBtn).isDisplayed());
    }
    public void AddValueData (String code, String name){

    }
    public void ListCheck (String name){
//        Assert.assertEquals(name,validateHelper.getText(nameGet));
//        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
}

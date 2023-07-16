package ShopizerAdmin.Pages.InventoryManagementPage.ProductsGroupsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsGroupsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By productsGroupsTab = By.xpath("//a[@title='Products groups']");
    private By listTab = By.xpath("//a[@title='List of product groups']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By codeInput = By.id("code");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By codeGet = By.xpath("//div[@class='ng-star-inserted']");

    public ProductsGroupsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddProductsGroups (String code){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsGroupsTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.clickElement(submitBtn);
    }
    public void AddProductsGroupsData (String code){
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.clickElement(submitBtn);
    }
    public void ListCheck (String code){
//        Assert.assertEquals(name,validateHelper.getText(nameGet));
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
}

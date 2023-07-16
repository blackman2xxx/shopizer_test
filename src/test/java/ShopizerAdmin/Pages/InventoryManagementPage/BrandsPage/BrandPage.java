package ShopizerAdmin.Pages.InventoryManagementPage.BrandsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrandPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By brandTab = By.xpath("//a[@title='Brands']");
    private By createBtn = By.xpath("//a[@title='Create brand']");
    private By codeInput = By.id("code");
    private By orderInput = By.id("sortOrder");
    private By nameInput = By.id("name");
    private By titleInput = By.id("title");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-brands[1]/div[1]/div[1]/ngx-brands-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-brands[1]/div[1]/div[1]/ngx-brands-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");

    public BrandPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddBrand (String code, String order, String name, String title){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(brandTab);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(orderInput,order);
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.clickElementwithJS(submitBtn);
    }
    public void AddBrandData (String code, String order, String name, String title){
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(orderInput,order);
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.clickElementwithJS(submitBtn);
    }
    public void ListCheck (String name, String code){
        Assert.assertEquals(name,validateHelper.getText(nameGet));
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
}

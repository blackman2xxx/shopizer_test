package ShopizerAdmin.Pages.InventoryManagementPage.CategoryPage;

import Initialization.ValidateHelper;
import org.apache.pdfbox.contentstream.operator.state.SetRenderingIntent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By categoryTab = By.xpath("//span[normalize-space()='Category']");
    private By categoryAdd = By.xpath("//span[normalize-space()='Create category']");
    private By visibleBtn = By.xpath("//span[@class='custom-checkbox']");
    private By codeInput = By.id("code");
    private By orderInput = By.id("order");
    private By titleInput = By.id("title");
    private By nameInput = By.id("name");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-categories[1]/div[1]/div[1]/ngx-categories-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-categories[1]/div[1]/div[1]/ngx-categories-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddCategory (String code, String order, String title, String name){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(categoryTab);
        validateHelper.clickElement(categoryAdd);
        validateHelper.clickElement(visibleBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(orderInput,order);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(submitBtn);
    }

    public void AddCategoryData (String code, String order, String title, String name){
        validateHelper.clickElement(categoryAdd);
        validateHelper.clickElement(visibleBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(orderInput,order);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(submitBtn);
    }

    public void ListCheck (String name, String code){
        Assert.assertEquals(name,validateHelper.getText(nameGet));
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
}

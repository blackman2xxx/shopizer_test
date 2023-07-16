package ShopizerAdmin.Pages.InventoryManagementPage.ProductsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By productsTab = By.xpath("//a[@title='Products']");
    private By listTab = By.xpath("//a[@title='List of products']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By visibleCheck = By.xpath("//span[@class='custom-checkbox']");
    private By idInput = By.id("identifier");
    private By orderInput = By.id("order");
    private By manufacturerSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-product-creation[1]/div[1]/ngx-product-form[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[5]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/div[3]/label[1]");
    private By gucciSelect = By.xpath("//li[@aria-label='gucci']");
    private By manufacturerSearch = By.xpath("//input[@class='ui-dropdown-filter ui-inputtext ui-widget ui-state-default ui-corner-all']");
    private By manufacturerClick = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-product-creation[1]/div[1]/ngx-product-form[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[5]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/div[5]/div[2]/ul[1]/p-dropdownitem[1]/li[1]");
    private By typeSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-product-creation[1]/div[1]/ngx-product-form[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[6]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/div[3]/label[1]");
    private By typeSearch = By.xpath("//input[@class='ui-dropdown-filter ui-inputtext ui-widget ui-state-default ui-corner-all']");
    private By typeClick = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-product-creation[1]/div[1]/ngx-product-form[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[6]/div[1]/div[1]/div[1]/p-dropdown[1]/div[1]/div[5]/div[2]/ul[1]/p-dropdownitem[1]/li[1]");
    private By nameInput = By.id("name");
    private By titleInput = By.id("title");
    private By priceInput = By.xpath("//input[@placeholder='Price']");
    private By quantityInput = By.xpath("//input[@placeholder='Quantity']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save Product definition']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddProduct (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(visibleCheck);
        validateHelper.sendText(idInput,id);
        validateHelper.sendText(orderInput,order);
        validateHelper.clickElement(manufacturerSelect);
        validateHelper.sendText(manufacturerSearch,manufacturer);
        validateHelper.clickElement(manufacturerClick);
        validateHelper.clickElement(typeSelect);
        validateHelper.sendText(typeSearch,type);
        validateHelper.clickElement(typeClick);
//        validateHelper.clickElement(typeSearch);
//        validateHelper.sendTextKey(typeSearch,Keys.ENTER);
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);

    }
    public void AddProductData (String code, String name){

    }
    public void ListCheck (String name){
//        Assert.assertEquals(name,validateHelper.getText(nameGet));
//        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
}

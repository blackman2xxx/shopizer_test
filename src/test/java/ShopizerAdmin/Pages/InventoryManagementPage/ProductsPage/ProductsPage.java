package ShopizerAdmin.Pages.InventoryManagementPage.ProductsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;

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
    private By idGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By quantityGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By priceGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[6]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By edit1Btn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[8]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By remove2Btn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[2]/td[8]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By imageTag = By.xpath("//span[normalize-space()='Product images']");
    private By imageInsertBtn = By.xpath("//button[normalize-space()='Browse files']");
    private By categoryTag = By.xpath("//span[normalize-space()='Product to category']");
    private By categorySelect = By.xpath("//span[@class='dropdown-btn']");
    private By aonamSelect = By.xpath("//li[1]//div[1]");
    private By quannamSelect = By.xpath("//li[2]//div[1]");
    private By quanlotnamSelect = By.xpath("//li[3]//div[1]");
    private By phukienSelect = By.xpath("//li[4]//div[1]");
    private By page2Btn = By.xpath("//button[normalize-space()='2']");
    private By page3Btn = By.xpath("//button[normalize-space()='3']");
    private By idSearch = By.xpath("//input[@placeholder='Sku']");
    private By nameSearch = By.xpath("//input[@placeholder='Product name']");
    private By removeCofirm = By.xpath("//button[normalize-space()='Ok']");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddProduct (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity, String anh1, String anh2, String anh3) throws AWTException, InterruptedException {
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
        ListCheck(id,name,quantity,price);
        validateHelper.clickElement(edit1Btn);
        validateHelper.clickElementwithJS(imageTag);
        validateHelper.uploadFile(imageInsertBtn,anh1);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.clickElement(categoryTag);
        validateHelper.clickElement(categorySelect);
        validateHelper.clickElement(aonamSelect);
    }
    public void AddProductDataAo (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity, String anh1, String anh2, String anh3, String editXpath) throws AWTException {
//        String editXpath = "/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products[1]/div[1]/div[1]/ngx-products-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr["+"stt"+"]/td[8]/ng2-st-tbody-custom[1]/a[1]/i[1]";
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
        validateHelper.clickElement(By.xpath(editXpath));
        validateHelper.clickElementwithJS(imageTag);
        validateHelper.uploadFile(imageInsertBtn,anh1);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.clickElement(categoryTag);
        validateHelper.clickElement(categorySelect);
        validateHelper.clickElement(aonamSelect);
    }
    public void AddProductDataQuan (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity, String anh1, String anh2, String anh3, String editXpath) throws AWTException {
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
        validateHelper.clickElement(By.xpath(editXpath));
        validateHelper.clickElementwithJS(imageTag);
        validateHelper.uploadFile(imageInsertBtn,anh1);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.clickElement(categoryTag);
        validateHelper.clickElement(categorySelect);
        validateHelper.clickElement(quannamSelect);
    }

    public void AddProductDataQuanlot (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity, String anh1, String anh2, String anh3, String editXpath) throws AWTException {
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
        validateHelper.clickElement(page2Btn);
        validateHelper.clickElement(By.xpath(editXpath));
        validateHelper.clickElementwithJS(imageTag);
        validateHelper.uploadFile(imageInsertBtn,anh1);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh2);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.uploadFile(imageInsertBtn,anh3);
        validateHelper.clickElement(categoryTag);
        validateHelper.clickElement(categorySelect);
        validateHelper.clickElement(quanlotnamSelect);
    }

    public void AddProductDataPhukien (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity, String anh1, String editXpath) throws AWTException {
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
        validateHelper.clickElement(page2Btn);
        validateHelper.clickElement(By.xpath(editXpath));
        validateHelper.clickElementwithJS(imageTag);
        validateHelper.uploadFile(imageInsertBtn,anh1);
        validateHelper.uploadFile(imageInsertBtn,anh1);
        validateHelper.clickElement(categoryTag);
        validateHelper.clickElement(categorySelect);
        validateHelper.clickElement(phukienSelect);
    }
    public void AddProductDataTest (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity) throws AWTException {
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
    }

    public void SetUp (){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsTab);
    }

    public void ListCheck (String id, String name, String quantity, String price){
        Assert.assertEquals(id,validateHelper.getText(idGet));
        Assert.assertEquals(name,validateHelper.getText(nameGet));
        Assert.assertEquals(quantity,validateHelper.getText(quantityGet));
        Assert.assertEquals(price,validateHelper.getText(priceGet));
    }
    public void SearchByID (String id) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsTab);
        validateHelper.clickElement(listTab);
        validateHelper.sendText(idSearch,id);
        validateHelper.sendTextKey(idSearch,Keys.ENTER);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(idGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals(id,validateHelper.getText(idGet));
    }
    public void SearchByName (String name) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsTab);
        validateHelper.clickElement(listTab);
        validateHelper.sendText(nameSearch,name);
        validateHelper.sendTextKey(nameSearch,Keys.ENTER);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(nameGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals(name,validateHelper.getText(nameGet));
    }
    public void AddProductSameID (String id, String order, String manufacturer, String type, String name, String title, String price, String quantity){
        boolean check;
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
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(priceInput,price);
        validateHelper.sendText(quantityInput,quantity);
        validateHelper.clickElement(submitBtn);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(idGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void EditProduct (String editnamedata) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(page3Btn);
        validateHelper.clickElement(edit1Btn);
        validateHelper.sendText(nameInput,editnamedata);
        validateHelper.clickElement(submitBtn);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(nameInput));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals(editnamedata,validateHelper.getAttribute(nameInput,"value"));
    }
    public void RemoveProduct () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(page3Btn);
        validateHelper.clickElement(remove2Btn);
        validateHelper.clickElement(removeCofirm);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(remove2Btn));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);

    }
}

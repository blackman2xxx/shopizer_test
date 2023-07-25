package ShopizerAdmin.Pages.InventoryManagementPage.BrandsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By duplicateIDAlert = By.xpath("//span[@class='err-message ng-star-inserted']");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-brands[1]/div[1]/div[1]/ngx-brands-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[11]/td[4]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-brands[1]/div[1]/div[1]/ngx-brands-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[11]/td[4]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirm = By.xpath("//button[contains(text(),'Ok')]");
    private By brandList = By.xpath("//span[normalize-space()='List of brands']");
    private By nameSearch = By.xpath("//input[@placeholder='Brand name']");
    private By codeSearch = By.xpath("//input[@placeholder='Code']");

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
        ListCheck(name,code);
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
    public void SearchByName (String name) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(brandTab);
        validateHelper.clickElement(brandList);
        validateHelper.sendText(nameSearch,name);
        validateHelper.sendTextKey(nameSearch, Keys.ENTER);
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
    public void SearchByCode (String code) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(brandTab);
        validateHelper.clickElement(brandList);
        validateHelper.sendText(codeSearch,code);
        validateHelper.sendTextKey(codeSearch, Keys.ENTER);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(codeGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
    public void AddBrandSameID (String code, String order, String name, String title){
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(brandTab);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(orderInput,order);
        Assert.assertTrue(driver.findElement(duplicateIDAlert).isDisplayed());
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(titleInput,title);
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
    public void EditBrand(String editnamedata) throws InterruptedException {
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(brandTab);
        validateHelper.clickElement(brandList);
        validateHelper.clickElementwithJS(editBtn);
        validateHelper.sendText(nameInput,editnamedata);
        validateHelper.clickElement(submitBtn);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Assert.assertEquals(editnamedata,validateHelper.getAttribute(nameInput,"value"));
    }
    public void RemoveBrand() throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(brandTab);
        validateHelper.clickElement(brandList);
        validateHelper.clickElement(removeBtn);
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

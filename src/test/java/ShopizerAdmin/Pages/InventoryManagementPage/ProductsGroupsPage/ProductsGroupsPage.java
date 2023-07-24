package ShopizerAdmin.Pages.InventoryManagementPage.ProductsGroupsPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products-groups[1]/div[1]/div[1]/ngx-groups-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[5]/td[3]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-products-groups[1]/div[1]/div[1]/ngx-groups-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[5]/td[3]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By selectProducts = By.xpath("//span[@class='dropdown-btn']");
    private By product1Select = By.xpath("//div[contains(text(),'Ao thun chay bo Basic')]");
    private By product2Select = By.xpath("//div[contains(text(),'Ao thun Gym Powerfit')]");
    private By product1Check = By.xpath("//span[contains(text(),'Ao thun chay bo Basic')]");
    private By product2Check = By.xpath("//span[contains(text(),'Ao thun Gym Powerfit')]");
    private By updateBtn = By.xpath("//button[contains(text(),'Update')]");
    private By removeConfirm = By.xpath("//button[normalize-space()='Ok']");

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
        Assert.assertEquals(code,validateHelper.getText(codeGet));
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
    public void AddProductsGroupsSameID (String code){
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsGroupsTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.clickElement(submitBtn);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(createBtn));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void EditProductsGroups (){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsGroupsTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(editBtn);
        validateHelper.clickElement(selectProducts);
        validateHelper.clickElement(product1Select);
        validateHelper.clickElement(product2Select);
        validateHelper.clickElement(updateBtn);
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElement(product1Check).isDisplayed());
        Assert.assertTrue(driver.findElement(product2Check).isDisplayed());
    }
    public void RemoveProductsGroups () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productsGroupsTab);
        validateHelper.clickElement(listTab);
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

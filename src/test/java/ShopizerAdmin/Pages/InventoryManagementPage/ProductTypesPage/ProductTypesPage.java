package ShopizerAdmin.Pages.InventoryManagementPage.ProductTypesPage;

import Initialization.ValidateHelper;
import org.apache.pdfbox.contentstream.operator.state.SetRenderingIntent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductTypesPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By inventoryTab = By.xpath("//span[normalize-space()='Inventory management']");
    private By productTypesTab = By.xpath("//a[@title='Product types']");
    private By listTab = By.xpath("//span[normalize-space()='List of product types']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By visibleBtn = By.xpath("//span[@class='custom-checkbox']");
    private By codeInput = By.id("code");
    private By languageInput = By.xpath("//nb-select[@name='selectedLanguage']");
    private By englishSelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]");
    private By nameInput = By.id("name");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-types[1]/div[1]/div[1]/ngx-types-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By duplicateIDAlert = By.xpath("//span[@class='err-message ng-star-inserted']");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-types[1]/div[1]/div[1]/ngx-types-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[6]/td[4]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-catalogue[1]/ngx-types[1]/div[1]/div[1]/ngx-types-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[6]/td[4]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirm = By.xpath("//button[normalize-space()='Ok']");

    public ProductTypesPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }

    public void AddProductType (String code, String name){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productTypesTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(visibleBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.clickElement(languageInput);
        validateHelper.clickElement(englishSelect);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(submitBtn);
    }
    public void AddProductTypeData (String code, String name){
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(visibleBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.clickElement(languageInput);
        validateHelper.clickElement(englishSelect);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(submitBtn);
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
    public void ListCheck (String code){
//        Assert.assertEquals(name,validateHelper.getText(nameGet));
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
    public void AddProductTypeSameID (String code, String name){
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productTypesTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(visibleBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.clickElement(languageInput);
        validateHelper.clickElement(englishSelect);
        validateHelper.sendText(nameInput,name);
        Assert.assertTrue(driver.findElement(duplicateIDAlert).isDisplayed());
        validateHelper.clickElement(submitBtn);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(codeGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void EditProductType (){
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productTypesTab);
        validateHelper.clickElement(listTab);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(nameInput,"Type 10");
        validateHelper.clickElement(submitBtn);
        driver.navigate().refresh();
        Assert.assertEquals("Type 10",validateHelper.getAttribute(nameInput,"value"));
    }
    public void RemoveProductType () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(inventoryTab);
        validateHelper.clickElement(productTypesTab);
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

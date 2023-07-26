package ShopizerAdmin.Pages.ShippingManagementPage.PackagingPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PackagingPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By shippingManagementTab = By.xpath("//span[normalize-space()='Shipping management']");
    private By packagingTab = By.xpath("//span[normalize-space()='Packaging']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By boxpackingCheckbox = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-add[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[1]/div[1]/div[1]/nb-radio-group[1]/nb-radio[2]/label[1]/span[2]");
    private By codeInput = By.xpath("//input[@placeholder='Code']");
    private By widthInput = By.xpath("//input[@placeholder='Box width']");
    private By heightInput = By.xpath("//input[@placeholder='Box height']");
    private By lenghtInput = By.xpath("//input[@placeholder='Box lenght']");
    private By weightInput = By.xpath("//input[@placeholder='Box weight']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[1]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By widthGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By heightGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By lengthGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By weightGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[5]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[6]/td[7]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-packages-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[6]/td[7]/ng2-st-tbody-custom[1]/a[2]/i[1]");

    public PackagingPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void AddBox (String code, String width, String height, String length, String weight){
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(packagingTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(boxpackingCheckbox);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(widthInput,width);
        validateHelper.sendText(heightInput,height);
        validateHelper.sendText(lenghtInput,length);
        validateHelper.sendText(weightInput,weight);
        validateHelper.clickElementwithJS(submitBtn);
        ListCheck(code,width,height,length,weight);
    }
    public void AddBoxSameCode (String code, String width, String height, String length, String weight) throws InterruptedException {
        boolean check;
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(packagingTab);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(boxpackingCheckbox);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(widthInput,width);
        validateHelper.sendText(heightInput,height);
        validateHelper.sendText(lenghtInput,length);
        validateHelper.sendText(weightInput,weight);
        validateHelper.clickElementwithJS(submitBtn);
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(codeGet));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
    public void ListCheck (String code, String width, String height, String length, String weight){
        Assert.assertEquals(code,validateHelper.getText(codeGet));
        Assert.assertEquals(width,validateHelper.getText(widthGet));
        Assert.assertEquals(height,validateHelper.getText(heightGet));
        Assert.assertEquals(length,validateHelper.getText(lengthGet));
        Assert.assertEquals(weight,validateHelper.getText(weightGet));
    }
    public void AddBoxData (String code, String width, String height, String length, String weight){
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(boxpackingCheckbox);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(widthInput,width);
        validateHelper.sendText(heightInput,height);
        validateHelper.sendText(lenghtInput,length);
        validateHelper.sendText(weightInput,weight);
        validateHelper.clickElementwithJS(submitBtn);
    }
    public void EditBox (String editdata) throws InterruptedException {
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(packagingTab);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(widthInput,editdata);
        validateHelper.clickElement(submitBtn);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        Assert.assertEquals(editdata,validateHelper.getAttribute(widthInput,"value"));
    }
    public void RemoveBox () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(packagingTab);
        validateHelper.clickElement(removeBtn);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
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

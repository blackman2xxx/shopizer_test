package ShopizerAdmin.Pages.ContentManagementPage.ContentPagesPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PagesPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By contentManagementTab = By.xpath("//span[normalize-space()='Content management']");
    private By pagesList = By.xpath("//span[normalize-space()='Content Pages']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By visibleCheckbox = By.xpath("//nb-checkbox[@formcontrolname='visible']//span[@class='custom-checkbox']");
    private By mainmenuCheckbox = By.xpath("//nb-checkbox[@formcontrolname='mainmenu']//span[@class='custom-checkbox']");
    private By codeInput = By.id("code");
    private By orderInput = By.id("order");
    private By titleInput = By.id("title");
    private By metatagInput = By.id("metaDescription");
    private By nameInput = By.id("name");
    private By pageContentInput = By.xpath("//div[@role='textbox']");
    private By submitBtn = By.xpath("//button[normalize-space()='COMMON.SAVE']");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/page-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/page-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/page-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[5]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/page-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[5]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirmBtn = By.xpath("//button[contains(text(),'COMMON.OK')]");
    private By updateBtn = By.xpath("//button[contains(text(),'COMMON.UPDATE')]");

    public PagesPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }
    public void AddPage (String code, String order, String title, String metatag, String name, String pagecontent){
        validateHelper.clickElement(contentManagementTab);
        validateHelper.clickElement(pagesList);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(visibleCheckbox);
        validateHelper.clickElement(mainmenuCheckbox);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(orderInput,order);
        validateHelper.sendText(titleInput,title);
        validateHelper.sendText(metatagInput,metatag);
        validateHelper.sendText(nameInput,name);
        validateHelper.sendText(pageContentInput,pagecontent);
        validateHelper.clickElementwithJS(submitBtn);
        ListCheck(code,name);
    }
    public void ListCheck (String code, String name){
        Assert.assertEquals(code,validateHelper.getText(codeGet));
        Assert.assertEquals(name,validateHelper.getText(nameGet));
    }
    public void EditPage (String editnamedata){
        validateHelper.clickElement(contentManagementTab);
        validateHelper.clickElement(pagesList);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(nameInput,editnamedata);
        validateHelper.clickElement(updateBtn);
        Assert.assertEquals(editnamedata,validateHelper.getText(nameGet));
    }
    public void RemovePage () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(contentManagementTab);
        validateHelper.clickElement(pagesList);
        validateHelper.clickElement(removeBtn);
        validateHelper.clickElement(removeConfirmBtn);
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

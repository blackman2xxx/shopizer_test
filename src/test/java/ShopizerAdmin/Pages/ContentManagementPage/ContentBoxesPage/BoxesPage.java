package ShopizerAdmin.Pages.ContentManagementPage.ContentBoxesPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BoxesPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public JavascriptExecutor js;
    private By contentManagementTab = By.xpath("//span[normalize-space()='Content management']");
    private By boxesList = By.xpath("//span[normalize-space()='Content Boxes']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By visibleCheckBox = By.xpath("//span[@class='custom-checkbox']");
    private By codeInput = By.id("code");
    private By pageContentInput = By.xpath("//div[@role='textbox']");
    private By submitBtn = By.xpath("//button[contains(text(),'COMMON.SAVE')]");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/boxes-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/boxes-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirm = By.xpath("//button[contains(text(),'COMMON.OK')]");
    private By updateBtn = By.xpath("//button[contains(text(),'COMMON.UPDATE')]");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/boxes-table[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By pageContentGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-content-management[1]/div[1]/div[1]/add-box[1]/div[1]/div[1]/form[1]/div[1]/div[2]/nb-card[1]/nb-card-body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]");

    public BoxesPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        js = (JavascriptExecutor)driver;
    }
    public void AddBox (String code, String pagecontent){
        validateHelper.clickElement(contentManagementTab);
        validateHelper.clickElement(boxesList);
        validateHelper.clickElement(createBtn);
        validateHelper.clickElement(visibleCheckBox);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(pageContentInput,pagecontent);
        validateHelper.clickElementwithJS(submitBtn);
        Assert.assertEquals(code,validateHelper.getText(codeGet));
    }
    public void EditBox (String editdata){
        validateHelper.clickElement(contentManagementTab);
        validateHelper.clickElement(boxesList);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(pageContentInput,editdata);
        validateHelper.clickElementwithJS(updateBtn);
        validateHelper.clickElement(editBtn);
        Assert.assertEquals(editdata,validateHelper.getText(pageContentGet));
    }
    public void RemoveBox () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(contentManagementTab);
        validateHelper.clickElement(boxesList);
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
        Assert.assertFalse(check);}
}

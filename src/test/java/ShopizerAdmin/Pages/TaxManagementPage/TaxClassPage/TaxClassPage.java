package ShopizerAdmin.Pages.TaxManagementPage.TaxClassPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TaxClassPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By taxManagementTab = By.xpath("//span[normalize-space()='Tax management']");
    private By taxClassTab = By.xpath("//span[normalize-space()='Tax Classes']");
    private By createBtn = By.xpath("//a[@class='createBtn']");
    private By codeGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-class-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[2]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By nameGet = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-class-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[3]/ng2-smart-table-cell[1]/table-cell-view-mode[1]/div[1]/div[1]");
    private By editBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-class-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-st-tbody-custom[1]/a[1]/i[1]");
    private By removeBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-class-list[1]/nb-card[1]/nb-card-body[1]/div[1]/ng2-smart-table[1]/table[1]/tbody[1]/tr[1]/td[4]/ng2-st-tbody-custom[1]/a[2]/i[1]");
    private By removeConfirm = By.xpath("//button[normalize-space()='Ok']");
    private By updateBtn = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-tax[1]/div[1]/div[1]/ngx-tax-class-add[1]/div[1]/nb-card-header[1]/div[2]/button[1]");
    private By codeInput = By.xpath("//input[@placeholder='Tax class code']");
    private By nameInput = By.xpath("//input[@placeholder='Tax class name']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By duplicateCodeAlert = By.xpath("//span[@class='err-message ng-star-inserted']");

    public TaxClassPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void AddClass (String code, String name){
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxClassTab);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(submitBtn);
        Assert.assertEquals(code,validateHelper.getText(codeGet));
        Assert.assertEquals(name,validateHelper.getText(nameGet));
    }
    public void AddClassData (String code, String name){
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        validateHelper.clickElement(submitBtn);
    }
    public void AddClassSameCode (String code, String name){
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxClassTab);
        validateHelper.clickElement(createBtn);
        validateHelper.sendText(codeInput,code);
        validateHelper.sendText(nameInput,name);
        Assert.assertTrue(driver.findElement(duplicateCodeAlert).isDisplayed());
        Assert.assertFalse(driver.findElement(submitBtn).isEnabled());
    }
    public void EditClass (String editdataname) {
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxClassTab);
        validateHelper.clickElement(editBtn);
        validateHelper.sendText(nameInput,editdataname);
        validateHelper.clickElement(updateBtn);
        Assert.assertEquals(editdataname,validateHelper.getText(nameGet));
    }
    public void RemoveClass (){
        validateHelper.clickElement(taxManagementTab);
        validateHelper.clickElement(taxClassTab);
        String firstname = validateHelper.getText(nameGet);
        validateHelper.clickElement(removeBtn);
        validateHelper.clickElement(removeConfirm);
        driver.navigate().refresh();
        Assert.assertNotEquals(firstname,validateHelper.getText(nameGet));
    }
}

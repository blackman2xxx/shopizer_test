package ShopizerAdmin.Pages.ShippingManagementPage.ExpeditionPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExpeditionPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By shippingManagementTab = By.xpath("//span[normalize-space()='Shipping management']");
    private By expeditionTab = By.xpath("//span[normalize-space()='Expedition']");
    private By domesticCheckBox = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/shipping-config[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[1]/div[1]/div[1]/nb-radio-group[1]/nb-radio[1]/label[1]/span[2]");
    private By internationalCheckbox = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/shipping-config[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[1]/div[1]/div[1]/nb-radio-group[1]/nb-radio[2]/label[1]/span[1]");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");
    private By countrySelectSearch = By.xpath("//input[@id='Available_keyword']");
    private By countrySelect = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/shipping-config[1]/div[1]/div[1]/form[1]/div[2]/div[1]/nb-card[1]/nb-card-body[1]/div[1]/app-transferlistbox[1]/div[1]/div[1]/div[1]/div[1]/app-filterlistbox[1]/div[1]/div[3]/ul[1]/li[1]");
    private By selectBtn = By.xpath("//button[@title='Click here to move items from Country available To Country selected']");
    private By countrySelected = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/shipping-config[1]/div[1]/div[1]/form[1]/div[2]/div[1]/nb-card[1]/nb-card-body[1]/div[1]/app-transferlistbox[1]/div[1]/div[1]/div[3]/div[1]/app-filterlistbox[1]/div[1]/div[3]/ul[1]/li[1]");
    private By unselectBtn = By.xpath("//button[@title='Click here to move items from Country selected to Country available']");

    public ExpeditionPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void DomesticSelect (){
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(expeditionTab);
        validateHelper.clickElement(domesticCheckBox);
        validateHelper.clickElement(submitBtn);
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElement(domesticCheckBox).isSelected());
    }
    public void CountrySelect () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(expeditionTab);
        validateHelper.sendText(countrySelectSearch,"Canada");
        validateHelper.sendTextKey(countrySelectSearch, Keys.ENTER);
        validateHelper.clickElementwithJS(countrySelect);
        validateHelper.clickElement(selectBtn);
        validateHelper.clickElementwithJS(submitBtn);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(countrySelected));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertTrue(check);
        Assert.assertEquals("Canada",validateHelper.getText(countrySelected));
    }
    public void CountryUnselect () throws InterruptedException {
        boolean check;
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(expeditionTab);
        validateHelper.clickElementwithJS(countrySelected);
        validateHelper.clickElement(unselectBtn);
        validateHelper.clickElementwithJS(submitBtn);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10); // Chờ tối đa 10 giây
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(countrySelected));
            check = true;
        } catch (org.openqa.selenium.TimeoutException e) {
            check = false;
        }
        Assert.assertFalse(check);
    }
}

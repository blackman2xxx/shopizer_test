package ShopizerAdmin.Pages.ShippingManagement.ShippingOriginPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ShippingOriginPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By shippingManagementTab = By.xpath("//span[normalize-space()='Shipping management']");
    private By shippingOriginTab = By.xpath("//span[normalize-space()='Shipping origin']");
    private By activeCheckbox = By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nb-layout-column[1]/ngx-shipping[1]/div[1]/div[1]/ngx-origin[1]/div[1]/div[1]/form[1]/div[1]/div[1]/nb-card[1]/nb-card-body[1]/div[1]/div[1]/div[1]/nb-checkbox[1]/label[1]/span[1]");
    private By streetAddressInput = By.xpath("//input[@placeholder='Street Address']");
    private By cityInput = By.xpath("//input[@placeholder='City']");
    private By countrySelect = By.xpath("//nb-select[@name='country']");
    private By stateSelect = By.xpath("//nb-select[@name='stateProvince']");
    private By postalCodeInput = By.xpath("//input[@placeholder='Postal Code']");
    private By submitBtn = By.xpath("//button[normalize-space()='Save']");


    public ShippingOriginPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void AddShippingOrigin (String street, String city, String country, String state, String postalCode) throws InterruptedException {
        validateHelper.clickElement(shippingManagementTab);
        validateHelper.clickElement(shippingOriginTab);
        validateHelper.clickElement(activeCheckbox);
        validateHelper.sendText(streetAddressInput,street);
        validateHelper.sendText(cityInput,city);

        validateHelper.clickElement(countrySelect);
        validateHelper.clickElementwithJS(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[37]"));
        validateHelper.clickElement(stateSelect);
        validateHelper.clickElementwithJS(By.xpath("/html[1]/body[1]/ngx-app[1]/div[1]/ngx-pages[1]/ngx-sample-layout[1]/nb-layout[1]/div[2]/div[1]/div[1]/nb-option-list[1]/ul[1]/nb-option[1]"));

        validateHelper.sendText(postalCodeInput,postalCode);
        validateHelper.clickElementwithJS(submitBtn);
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
//        Assert.assertTrue(driver.findElement(activeCheckbox).isSelected());
        Assert.assertEquals(street,validateHelper.getAttribute(streetAddressInput,"value"));
        Assert.assertEquals(city,validateHelper.getAttribute(cityInput,"value"));
        Assert.assertEquals(country,validateHelper.getAttribute(countrySelect,"innerText"));
        Assert.assertEquals(state,validateHelper.getAttribute(stateSelect,"innerText"));
        Assert.assertEquals(postalCode,validateHelper.getAttribute(postalCodeInput,"value"));
    }
}

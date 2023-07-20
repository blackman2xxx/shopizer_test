package ShopizerUser.Pages.CheckoutPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By cartBtn = By.xpath("//div[@class='same-style cart-wrap d-none d-lg-block']");
    private By checkoutBtn = By.xpath("//a[contains(text(),'Checkout')]");
    private By firstnameGet = By.xpath("//input[@name='firstName']");
    private By lastnameGet = By.xpath("//input[@name='lastName']");
    private By companyGet = By.xpath("//input[@name='company']");
    private By streetGet = By.xpath("//input[@id='autocomplete']");
    private By cityGet = By.xpath("//input[@name='city']");
    private By postalcodeGet = By.xpath("//input[@name='postalCode']");
    private By phoneGet = By.xpath("//input[@name='phone']");
    private By emailGet = By.xpath("//div[@class='billing-info mb-20']//input[@name='email']");
    private By agreeCheck = By.xpath("//input[@name='isAgree']");
    private By submitBtn = By.xpath("//button[normalize-space()='Place your order']");
    private By aoCheck = By.xpath("//a[contains(@href,'/product/null')][normalize-space()='Ao Tank Top the thao nam Active V1']");



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void CheckoutTest(String company, String street, String city, String postalcode, String phone, String email) throws InterruptedException {
        validateHelper.clickElement(cartBtn);
        validateHelper.clickElementwithJS(checkoutBtn);
        CheckUserInformation(company,street,city,postalcode,phone,email);
        validateHelper.clickElementwithJS(agreeCheck);
        validateHelper.clickElementwithJS(submitBtn);
        driver.get("http://localhost/cart");
        Assert.assertFalse(driver.findElement(aoCheck).isDisplayed());
    }
    public void CheckUserInformation (String company, String street, String city, String postalcode, String phone, String email){
        Assert.assertEquals(company,validateHelper.getAttribute(companyGet,"value"));
        Assert.assertEquals(street,validateHelper.getAttribute(streetGet,"value"));
        Assert.assertEquals(city,validateHelper.getAttribute(cityGet,"value"));
        Assert.assertEquals(postalcode,validateHelper.getAttribute(postalcodeGet,"value"));
        Assert.assertEquals(phone,validateHelper.getAttribute(phoneGet,"value"));
        Assert.assertEquals(email,validateHelper.getAttribute(emailGet,"value"));
    }
}

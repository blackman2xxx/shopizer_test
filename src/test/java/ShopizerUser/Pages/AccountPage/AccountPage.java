package ShopizerUser.Pages.AccountPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.postalCode;

public class AccountPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public String EmailAddress;
    private By billingAddressTab = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]/h3[1]");
    private By companyNameInput = By.xpath("//input[contains(@name,'company')]");
    private By streetAddressInput = By.id("autocomplete");
    private By countrySelect = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/select[1]");
    private By stateSelect = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/select[1]");
//    private By stateSelect = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/select[1]");
    private By cityInput = By.xpath("//input[contains(@name,'city')]");
    private By postalCodeInput = By.xpath("//input[@name='postalCode']");
    private By phoneInput = By.xpath("//input[@name='phone']");
    private By submitBtn = By.xpath("//div[@class='collapse show']//button[@type='submit'][normalize-space()='Continue']");
    private By billingAddressTab2 = By.xpath("//div[2]//div[1]//button[1]//h3[1]");
    private By companyGet = By.xpath("//input[@name='company']");
    private By streetGet = By.xpath("//input[@id='autocomplete']");
    private By cityGet = By.xpath("//input[@name='city']");


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void UpdateBillingAddress(String company, String street, String country, String state, String city, String postalcode, String phone){
        validateHelper.clickElement(billingAddressTab);
        validateHelper.sendText(companyNameInput,company);
        validateHelper.sendText(streetAddressInput,street);
        Select selectCountry = new Select(driver.findElement(countrySelect));
        selectCountry.selectByVisibleText(country);
        Select selectState = new Select(driver.findElement(stateSelect));
        selectState.selectByVisibleText(state);
        validateHelper.sendText(cityInput,city);
        validateHelper.sendText(postalCodeInput,postalcode);
        validateHelper.sendText(phoneInput,phone);
        validateHelper.clickElement(submitBtn);
        driver.navigate().refresh();
        validateHelper.clickElement(billingAddressTab);
        checkData(company,street,country,state,city,postalcode,phone);

    }

    public void checkData(String company, String street, String country, String state, String city, String postalcode, String phone){
        Assert.assertEquals(company,validateHelper.getAttribute(companyGet,"value"));
        Assert.assertEquals(street,validateHelper.getAttribute(streetGet,"value"));
//        Assert.assertEquals(country,validateHelper.getAttribute(countrySelect,"value"));
//        Assert.assertEquals(state,validateHelper.getAttribute(stateSelect,"value"));
        Assert.assertEquals(city,validateHelper.getAttribute(cityGet,"value"));
        Assert.assertEquals(postalcode,validateHelper.getAttribute(postalCodeInput,"value"));
        Assert.assertEquals(phone,validateHelper.getAttribute(phoneInput,"value"));
    }
}

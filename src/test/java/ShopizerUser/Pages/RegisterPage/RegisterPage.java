package ShopizerUser.Pages.RegisterPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class RegisterPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    public String EmailAddress;
    private By acceptedBtn = By.id("rcc-confirm-button");
    private By accountBtn = By.xpath("//button[@class='account-setting-active']");
    private By registerBtn = By.xpath("//div[@class='account-dropdown active']//ul//div//a[normalize-space()='Register']");
    private By emailInput = By.xpath("//input[@autocomplete='Email']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By repeatPasswordInput = By.xpath("//input[@placeholder='Repeat Password']");

    private By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    private By lastNameInput = By.xpath("//input[@placeholder='Last Name']");

    private By countrySelect = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[6]/select[1]");
    private By stateSelect = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[7]/select[1]");
    private By submitBtn = By.xpath("(//button[contains(@type,'submit')])[2]");
    private By emailGet = By.xpath("//div[@class='billing-info']//input[@name='email']");
    private By titleGet = By.xpath("//span[contains(@to,'/my-account')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void Register(String username, String password, String firstname, String lastname) throws InterruptedException {
        validateHelper.clickElement(acceptedBtn);
        validateHelper.clickElement(accountBtn);
        validateHelper.clickElement(registerBtn);

        validateHelper.sendText(emailInput,username);
        validateHelper.sendText(passwordInput,password);
        validateHelper.sendText(repeatPasswordInput,password);
        validateHelper.sendText(firstNameInput,firstname);
        validateHelper.sendText(lastNameInput,lastname);

        Select selectCountry = new Select(driver.findElement(countrySelect));
        selectCountry.selectByIndex(1);
        Select selectState = new Select(driver.findElement(stateSelect));
        selectState.selectByIndex(1);
        validateHelper.clickElement(submitBtn);
        Assert.assertTrue(driver.findElement(titleGet).isDisplayed());
    }
}

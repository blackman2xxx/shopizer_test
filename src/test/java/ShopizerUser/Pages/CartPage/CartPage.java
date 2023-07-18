package ShopizerUser.Pages.CartPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By aonamTab = By.xpath("(//a[normalize-space()='Áo nam'])[1]");
    private By addCart = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[10]/div[1]/div[1]/div[1]/div[2]/button[1]");
    private By quannamTab = By.xpath("(//a[contains(text(),'Quần nam')])[1]");

    private By quanlotnamTab = By.xpath("(//a[contains(text(),'Quần lót nam')])[1]");
    private By phukienTab = By.xpath("(//a[contains(text(),'Phụ kiện')])[1]");
    private By noibatTab = By.xpath("(//a[contains(text(),'Nổi bật')])[1]");
    private By cartBtn = By.xpath("//div[@class='same-style cart-wrap d-none d-lg-block']");
    private By viewCartBtn = By.xpath("//a[normalize-space()='View Cart']");
    private By aoCheck = By.xpath("//a[contains(@href,'/product/null')][normalize-space()='Ao Tank Top the thao nam Active V1']");
    private By quanlotCheck = By.xpath("//a[contains(@href,'/product/null')][normalize-space()='Combo 03 Quan lot nam Trunk Bamboo S2']");
    private By quanCheck = By.xpath("//a[contains(@href,'/product/null')][normalize-space()='Quan Jeans Clean Denim dang Slimfit S3']");
    private By phukienCheck = By.xpath("//a[contains(@href,'/product/null')][normalize-space()='Tat the thao co dai chong truot']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void AddCart() throws InterruptedException {
        validateHelper.clickElement(aonamTab);
        validateHelper.clickElementwithJS(addCart);
        validateHelper.clickElement(quannamTab);
        validateHelper.clickElementwithJS(addCart);
        validateHelper.clickElement(quanlotnamTab);
        validateHelper.clickElementwithJS(addCart);
        validateHelper.clickElement(phukienTab);
        validateHelper.clickElementwithJS(addCart);
        validateHelper.clickElement(cartBtn);
        validateHelper.clickElementwithJS(viewCartBtn);
        Assert.assertTrue(driver.findElement(aoCheck).isDisplayed());
        Assert.assertTrue(driver.findElement(quanCheck).isDisplayed());
        Assert.assertTrue(driver.findElement(quanlotCheck).isDisplayed());
        Assert.assertTrue(driver.findElement(phukienCheck).isDisplayed());
    }
}

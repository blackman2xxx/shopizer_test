package ShopizerUser.Pages.ProductInforPage;

import Initialization.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ProductInforPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By aonamTab = By.xpath("(//a[normalize-space()='Áo nam'])[1]");
    private By firstProductInfor = By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/h3[1]/a[1]");
    private By nameProductGet = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h2[1]");
    private By priceGet = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]");
    private By idGet = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[1]/li[1]/a[1]");
    private By categoryGet = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[7]/ul[1]/li[1]/a[1]");
    private By reviewTab = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]");
    private By fourstarsClick = By.xpath("//div[@class='description-review-area pb-90']//div[4]//*[name()='svg']//*[name()='path' and contains(@class,'star')]");


    public ProductInforPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void ProductInfor(String name, String price, String id, String category) throws InterruptedException {
        validateHelper.clickElement(aonamTab);
        validateHelper.clickElement(firstProductInfor);
        Assert.assertEquals(name,validateHelper.getText(nameProductGet));
        Assert.assertEquals(price,validateHelper.regexPrice(priceGet).replaceAll(",",""));
        Assert.assertEquals(id,validateHelper.getText(idGet));
        Assert.assertEquals(category,validateHelper.getText(categoryGet));
    }
    public void AddReview(){
        validateHelper.clickElement(aonamTab);
        validateHelper.clickElement(firstProductInfor);
        validateHelper.clickElementwithJS(reviewTab);
        validateHelper.clickElementwithJS(fourstarsClick);
    }
}

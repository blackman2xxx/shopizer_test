package ShopizerUser.TestCase.CheckoutTest;


import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.CartPage.CartPage;
import ShopizerUser.Pages.CheckoutPage.CheckoutPage;
import ShopizerUser.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class CheckoutTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public CheckoutPage checkoutPage;
    public CartPage cartPage;
    @Test
    public void CheckoutTest() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(1,2), excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.AddCart();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.CheckoutTest(excel.getCellData(1,39),excel.getCellData(1,40),excel.getCellData(1,43),excel.getCellData(1,44),excel.getCellData(1,45),excel.getCellData(1,2));

    }
}

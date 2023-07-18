package ShopizerUser.TestCase.CartTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.CartPage.CartPage;
import ShopizerUser.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class CartTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public CartPage cartPage;
    @Test
    public void AddCartTest() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login("tu2@gmail.com", excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.AddCart();
//        Thread.sleep(10000);
    }
}

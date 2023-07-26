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
    @Test (priority = 1)
    public void AddCartTest() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(3,2), excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.AddCart();
//        Thread.sleep(10000);
    }
    @Test (priority = 2)
    public void RemoveProductFromCart() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(3,2), excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.RemoveProductFromCart();
//        Thread.sleep(10000);
    }
    @Test (priority = 3)
    public void RemoveProductFromMiniCart() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(3,2), excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.RemoveProductFromMiniCart();
//        Thread.sleep(10000);
    }
    @Test (priority = 4)
    public void RemoveProductFromCartByQuantity() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(3,2), excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.RemoveProductFromCartByQuantity();
//        Thread.sleep(10000);
    }
    @Test (priority = 5)
    public void RemoveAllProductsFromCart() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(3,2), excel.getCellData(1,3 ));
        cartPage = new CartPage(driver);
        cartPage.RemoveAllProductsFromCart();
//        Thread.sleep(10000);
    }

}

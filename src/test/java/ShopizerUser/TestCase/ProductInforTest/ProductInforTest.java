package ShopizerUser.TestCase.ProductInforTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.LoginPage.LoginPage;
import ShopizerUser.Pages.ProductInforPage.ProductInforPage;
import org.testng.annotations.Test;

public class ProductInforTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public ProductInforPage productInforPage;
    @Test (priority = 1)
    public void ProductInfor() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(1,2), excel.getCellData(1,3 ));
        productInforPage = new ProductInforPage(driver);
        productInforPage.ProductInfor(excel.getCellData(1,30), excel.getCellData(1,31), excel.getCellData(1,25), excel.getCellData(1,7));
    }
    @Test (priority = 2)
    public void AddReview() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(1,2), excel.getCellData(1,3 ));
        productInforPage = new ProductInforPage(driver);
        productInforPage.AddReview("Áo đẹp");

    }
}


package ShopizerAdmin.TestCase.ShippingManagement.ShippingOriginTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.ShippingManagement.ShippingOriginPage.ShippingOriginPage;
import org.testng.annotations.Test;

public class ShippingOriginTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public ShippingOriginPage shippingOriginPage;
    @Test
    public void AddShippingOrigin() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        shippingOriginPage = new ShippingOriginPage(driver);
        shippingOriginPage.AddShippingOrigin(excel.getCellData(1,68),excel.getCellData(1,69),excel.getCellData(1,70),excel.getCellData(1,71),excel.getCellData(1,72));
    }
}

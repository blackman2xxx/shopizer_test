package ShopizerUser.TestCase.Register;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.RegisterPage.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends Init {
    public RegisterPage registerPage;
    public ExcelHelpers excel;
    @Test
    public void RegisterTest() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        registerPage = new RegisterPage(driver);
        registerPage.Register(excel.getCellData(1,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.Register(excel.getCellData(2,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.Register(excel.getCellData(3,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.Register(excel.getCellData(4,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.Register(excel.getCellData(5,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));

        //Assert.assertEquals(excel.getCellData(1,2),loginPage.EmailAddress);
    }
}

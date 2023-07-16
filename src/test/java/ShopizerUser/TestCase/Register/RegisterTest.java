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
        driver.get("http://localhost/");

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        registerPage = new RegisterPage(driver);
        registerPage.Register(excel.getCellData(1,2), excel.getCellData(1,3 ));

        //Assert.assertEquals(excel.getCellData(1,2),loginPage.EmailAddress);
    }
}

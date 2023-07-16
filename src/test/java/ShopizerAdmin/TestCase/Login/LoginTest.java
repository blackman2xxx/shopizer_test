package ShopizerAdmin.TestCase.Login;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    @Test
    public void LoginTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");

        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        //loginPage.SignIn("admin@shopizer.com","password");
        Assert.assertEquals(excel.getCellData(1,0),loginPage.UserName);
    }
}

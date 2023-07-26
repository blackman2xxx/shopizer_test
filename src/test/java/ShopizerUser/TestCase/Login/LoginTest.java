package ShopizerUser.TestCase.Login;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;

    @Test (priority = 1)
    public void LoginWithInvalidEmail() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.LoginWithInvalidEmail(excel.getCellData(1,2), excel.getCellData(1,3 ));
    }
    @Test (priority = 2)
    public void LoginWithWrongPassword() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.LoginWithWrongPassword(excel.getCellData(1,2), excel.getCellData(1,3 ));
    }
    @Test (priority = 3)
    public void LoginTest() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        loginPage.Login(excel.getCellData(1,2), excel.getCellData(1,3 ));
    }
}

package ShopizerAdmin.TestCase.Login;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    @Test (priority = 1)
    public void LoginWithInvalidEmail() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");

        loginPage.LogInWithInvalidEmail(excel.getCellData(1,0), excel.getCellData(1,1 ));
    }
    @Test (priority = 2)
    public void LoginWithWrongPassword() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");

        loginPage.LogInWithWrongPassword(excel.getCellData(1,0), excel.getCellData(1,1 ));
    }
    @Test (priority = 3)
    public void LoginTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");

        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
    }
}

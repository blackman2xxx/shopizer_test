package ShopizerAdmin.TestCase.UserManagement;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.UserManagementPage.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagementTest extends Init{
    public LoginPage loginPage;
    public UserManagementPage userManagementPage;
    public ExcelHelpers excel;
    @Test
    public void UserTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.AddUser();
        userManagementPage.ListCheck();
    }
}

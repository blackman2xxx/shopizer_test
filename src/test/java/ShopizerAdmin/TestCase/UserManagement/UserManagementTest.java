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
    @Test (priority = 1)
    public void AddUserWithInvalidEmail() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.AddUserWithInvalidEmail(excel.getCellData(1,48),excel.getCellData(1,49),excel.getCellData(1,50),excel.getCellData(1,51));
    }
    @Test (priority = 2)
    public void AddUserWithWrongPassword() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.AddUserWithWrongPassWord(excel.getCellData(1,48),excel.getCellData(1,49),excel.getCellData(1,50),excel.getCellData(1,51));
    }
    @Test (priority = 3)
    public void AddUserTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.AddUser(excel.getCellData(1,48),excel.getCellData(1,49),excel.getCellData(1,50),excel.getCellData(1,51));
        userManagementPage.Logout();
        loginPage.SignIn(excel.getCellData(1,50),excel.getCellData(1,51));
        Assert.assertEquals(excel.getCellData(1,50),loginPage.UserName);
    }
    @Test (priority = 4)
    public void EditUser () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.UserEdit();
    }
    @Test (priority = 5)
    public void RemoveUser () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        userManagementPage = new UserManagementPage(driver);
        userManagementPage.UserRemove();
    }
}

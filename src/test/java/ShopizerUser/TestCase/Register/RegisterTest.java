package ShopizerUser.TestCase.Register;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.RegisterPage.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends Init {
    public RegisterPage registerPage;
    public ExcelHelpers excel;
    @Test (priority = 1)
    public void RegisterWithInvalidEmail() throws Exception {
        driver.get(urlUser);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        registerPage = new RegisterPage(driver);
        registerPage.RegisterWithInvalidEmail(excel.getCellData(1,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
    }
    @Test (priority = 2)
    public void RegisterWithWrongPassword() throws Exception {
        driver.get(urlUser);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        registerPage = new RegisterPage(driver);
        registerPage.RegisterWithWrongPassword(excel.getCellData(1,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
    }
    @Test (priority = 3)
    public void RegisterTest() throws Exception {
        driver.get(urlUser);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        registerPage = new RegisterPage(driver);
        registerPage.Register(excel.getCellData(1,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.LogOut();
        driver.get(urlUser);
        registerPage.RegisterAddUser(excel.getCellData(2,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.LogOut();
        driver.get(urlUser);
        registerPage.RegisterAddUser(excel.getCellData(3,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.LogOut();
        driver.get(urlUser);
        registerPage.RegisterAddUser(excel.getCellData(4,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.LogOut();
        driver.get(urlUser);
        registerPage.RegisterAddUser(excel.getCellData(5,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
        registerPage.LogOut();
        driver.get(urlUser);
        //Assert.assertEquals(excel.getCellData(1,2),loginPage.EmailAddress);
    }

    @Test (priority = 4)
    public void RegisterWithSameEmail() throws Exception {
        driver.get(urlUser);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        registerPage = new RegisterPage(driver);
        registerPage.RegisterWithSameEmail(excel.getCellData(1,2), excel.getCellData(1,3), excel.getCellData(1,46), excel.getCellData(1,47));
    }
}

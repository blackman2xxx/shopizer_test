package ShopizerAdmin.TestCase.StoreManagement;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.StoreManagementPage.StoreManagementPage;
import ShopizerAdmin.Pages.UserManagementPage.UserManagementPage;
import org.testng.annotations.Test;

public class StoreManagementTest extends Init{
    public LoginPage loginPage;
    public StoreManagementPage storeManagementPage;
    public ExcelHelpers excel;
    @Test
    public void StoreTest() throws Exception {
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        storeManagementPage = new StoreManagementPage(driver);
        storeManagementPage.AddStore();
        storeManagementPage.ListCheck();
    }
}

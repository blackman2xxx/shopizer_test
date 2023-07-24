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
    @Test (priority = 1)
    public void StoreTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        storeManagementPage = new StoreManagementPage(driver);
        storeManagementPage.AddStore(excel.getCellData(1,52),excel.getCellData(1,53),excel.getCellData(1,54),excel.getCellData(1,55),excel.getCellData(1,56),excel.getCellData(1,57),excel.getCellData(1,58));
    }
    @Test (priority = 2)
    public void SearchByName() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        storeManagementPage = new StoreManagementPage(driver);
        storeManagementPage.SearchByName(excel.getCellData(1,52));
    }
    @Test (priority = 3)
    public void SearchByEmail() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        storeManagementPage = new StoreManagementPage(driver);
        storeManagementPage.SearchByEmail(excel.getCellData(1,55));
    }

    @Test (priority = 4)
    public void EditStore() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        storeManagementPage = new StoreManagementPage(driver);
        storeManagementPage.EditStore(excel.getCellData(1,53),excel.getCellData(1,52),excel.getCellData(1,59));
    }
    @Test (priority = 5)
    public void RemoveStore() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        storeManagementPage = new StoreManagementPage(driver);
        storeManagementPage.RemoveStore();
    }
}

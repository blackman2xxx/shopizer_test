package ShopizerAdmin.TestCase.InventoryManagement.ProductOptionsTest.OptionsTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductOptionsPage.OptionsPage.OptionsPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class OptionsTest extends Init{
    public LoginPage loginPage;
    public OptionsPage optionsPage;
    public ExcelHelpers excel;
    @Test
    public void OptionsTest() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.AddOption(excel.getCellData(1,19),excel.getCellData(1,20));
        optionsPage.ListCheck(excel.getCellData(1,20));
        for (int i = 1; i < 5; i++) {
            optionsPage.AddOptionData(excel.getCellData(i+1,19),excel.getCellData(i+1,20));
        }
    }
    @Test
    public void OptionsTestFail() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.AddOption(excel.getCellData(1,19),excel.getCellData(1,20));
        optionsPage.ListCheck(excel.getCellData(1,20));
    }
}

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
    @Test (priority = 1)
    public void OptionsTest() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.AddOption(excel.getCellData(1,19),excel.getCellData(1,20));
        for (int i = 1; i < 6; i++) {
            optionsPage.AddOptionData(excel.getCellData(i+1,19),excel.getCellData(i+1,20));
        }
    }
    @Test (priority = 2)
    public void SearchByName() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.SearchByName(excel.getCellData(2,20));
    }
    @Test (priority = 3)
    public void AddOptionsSameID() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.AddOptionSameID(excel.getCellData(1,19),excel.getCellData(1,20));
    }
    @Test (priority = 4)
    public void EditOptions() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.EditOption("Option 10");
    }
    @Test (priority = 5)
    public void RemoveOptions() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        optionsPage = new OptionsPage(driver);
        optionsPage.RemoveOption();
    }
}

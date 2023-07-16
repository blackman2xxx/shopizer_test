package ShopizerAdmin.TestCase.InventoryManagement.ProductOptionsTest.ValuesTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductOptionsPage.OptionsPage.OptionsPage;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductOptionsPage.ValuesPage.ValuesPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class ValuesTest extends Init{
    public LoginPage loginPage;
    public ValuesPage valuesPage;
    public ExcelHelpers excel;
    @Test
    public void ValuesTest() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
       //excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        valuesPage = new ValuesPage(driver);
        valuesPage.AddValue(excel.getCellData(1,22),excel.getCellData(1,23),excel.getCellData(1,24));
//        optionsPage = new OptionsPage(driver);
//        optionsPage.AddOption(excel.getCellData(1,19),excel.getCellData(1,20));
//        optionsPage.ListCheck(excel.getCellData(1,20));
//        for (int i = 1; i < 5; i++) {
//            optionsPage.AddOptionData(excel.getCellData(i+1,19),excel.getCellData(i+1,20));
//        }
    }

}

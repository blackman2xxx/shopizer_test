package ShopizerAdmin.TestCase.ShippingManagement.PackagingTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.ShippingManagement.PackagingPage.PackagingPage;
import org.testng.annotations.Test;

public class PackagingTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public PackagingPage packagingPage;
    @Test (priority = 1)
    public void AddBox () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        packagingPage = new PackagingPage(driver);
        packagingPage.AddBox(excel.getCellData(1,74),excel.getCellData(1,75),excel.getCellData(1,76),excel.getCellData(1,77),excel.getCellData(1,78));
        for (int i = 1; i < 6; i++) {
            packagingPage.AddBoxData(excel.getCellData(i+1,74),excel.getCellData(i+1,75),excel.getCellData(i+1,76),excel.getCellData(i+1,77),excel.getCellData(i+1,78));
        }
    }
    @Test (priority = 2)
    public void EditBox () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        packagingPage = new PackagingPage(driver);
        packagingPage.EditBox("70");
    }
    @Test (priority = 3)
    public void RemoveBox () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        packagingPage = new PackagingPage(driver);
        packagingPage.RemoveBox();
    }
}

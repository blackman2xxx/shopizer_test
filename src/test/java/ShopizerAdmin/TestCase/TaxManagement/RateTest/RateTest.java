package ShopizerAdmin.TestCase.TaxManagement.RateTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.TaxManagementPage.TaxRatePage.TaxRatePage;
import org.testng.annotations.Test;

public class RateTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public TaxRatePage taxRatePage;
    @Test (priority = 1)
    public void AddTaxRate () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxRatePage = new TaxRatePage(driver);
        taxRatePage.AddRate(excel.getCellData(1,81),excel.getCellData(1,82),excel.getCellData(1,83),excel.getCellData(1,84));
    }
    @Test (priority = 2)
    public void AddTaxRateSameCode () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxRatePage = new TaxRatePage(driver);
        taxRatePage.AddRateSameCode(excel.getCellData(1,81),excel.getCellData(1,82),excel.getCellData(1,83),excel.getCellData(1,84));
    }
    @Test (priority = 3)
    public void EditRate () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxRatePage = new TaxRatePage(driver);
        taxRatePage.EditRate("15.0000");
    }
    @Test (priority = 4)
    public void RemoveRate () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxRatePage = new TaxRatePage(driver);
        taxRatePage.RemoveRate();
    }
}

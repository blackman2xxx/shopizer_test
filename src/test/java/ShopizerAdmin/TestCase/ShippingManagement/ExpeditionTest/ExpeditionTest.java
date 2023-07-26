package ShopizerAdmin.TestCase.ShippingManagement.ExpeditionTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.ShippingManagementPage.ExpeditionPage.ExpeditionPage;
import org.testng.annotations.Test;

public class ExpeditionTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public ExpeditionPage expeditionPage;
    @Test (priority = 1)
    public void DomesticSelect() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        expeditionPage = new ExpeditionPage(driver);
        expeditionPage.DomesticSelect();
    }
    @Test (priority = 2)
    public void CountrySelect() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        expeditionPage = new ExpeditionPage(driver);
        expeditionPage.CountrySelect();
    }
    @Test (priority = 3)
    public void CountryUnselect() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        expeditionPage = new ExpeditionPage(driver);
        expeditionPage.CountryUnselect();
    }
}

package ShopizerAdmin.TestCase.InventoryManagement.BrandTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.InventoryManagementPage.BrandsPage.BrandPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;

import org.testng.annotations.Test;

public class BrandTest extends Init{
    public LoginPage loginPage;
    public BrandPage brandPage;
    public ExcelHelpers excel;
    @Test
    public void BrandTest() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.AddBrand(excel.getCellData(1,15),excel.getCellData(1,16),excel.getCellData(1,17),excel.getCellData(1,18));
        brandPage.ListCheck(excel.getCellData(1,17),excel.getCellData(1,15));
        for (int i = 1; i < 10; i++){
            brandPage.AddBrandData(excel.getCellData(i+1,15),excel.getCellData(i+1,16),excel.getCellData(i+1,17),excel.getCellData(i+1,18));
        }
    }
    @Test
    public void BrandTestFail() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.AddBrand(excel.getCellData(1,15),excel.getCellData(1,16),excel.getCellData(1,17),excel.getCellData(1,18));
        brandPage.ListCheck(excel.getCellData(1,17),excel.getCellData(1,15));
    }
}

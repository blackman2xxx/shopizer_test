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
    @Test (priority = 1)
    public void BrandTest() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.AddBrand(excel.getCellData(1,15),excel.getCellData(1,16),excel.getCellData(1,17),excel.getCellData(1,18));
        for (int i = 1; i < 10; i++){
            brandPage.AddBrandData(excel.getCellData(i+1,15),excel.getCellData(i+1,16),excel.getCellData(i+1,17),excel.getCellData(i+1,18));
        }
    }
    @Test (priority = 2)
    public void SearchByName() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.SearchByName(excel.getCellData(2,17));
    }
    @Test (priority = 3)
    public void SearchByCode() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.SearchByCode(excel.getCellData(2,15));
    }

    @Test (priority = 4)
    public void AddBrandSameID() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.AddBrandSameID(excel.getCellData(1,15),excel.getCellData(1,16),excel.getCellData(1,17),excel.getCellData(1,18));
    }
    @Test (priority = 5)
    public void EditBrand() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.EditBrand("Brand Edit Test");
    }
    @Test (priority = 6)
    public void RemoveBrand() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        brandPage = new BrandPage(driver);
        brandPage.RemoveBrand();
    }
}

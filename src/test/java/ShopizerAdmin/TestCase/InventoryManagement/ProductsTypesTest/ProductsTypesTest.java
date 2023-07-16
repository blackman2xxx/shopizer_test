package ShopizerAdmin.TestCase.InventoryManagement.ProductsTypesTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductTypesPage.ProductTypesPage;
import org.testng.annotations.Test;

public class ProductsTypesTest extends Init{
    public LoginPage loginPage;
    public ProductTypesPage productTypesPage;
    public ExcelHelpers excel;
    @Test
    public void ProductsTypesTest() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productTypesPage = new ProductTypesPage(driver);
        productTypesPage.AddProductType(excel.getCellData(1,11),excel.getCellData(1,12));
        productTypesPage.ListCheck(excel.getCellData(1,11));
        for (int i = 1; i < 5; i++){
            productTypesPage.AddProductTypeData(excel.getCellData(i+1,11),excel.getCellData(i+1,12));
        }
    }
    @Test
    public void ProductsTypesTestFail() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productTypesPage = new ProductTypesPage(driver);
        productTypesPage.AddProductType(excel.getCellData(1,11),excel.getCellData(1,12));
        productTypesPage.ListCheck(excel.getCellData(1,11));
    }
}

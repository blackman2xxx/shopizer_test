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
    @Test (priority = 1)
    public void ProductsTypesTest() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productTypesPage = new ProductTypesPage(driver);
        productTypesPage.AddProductType(excel.getCellData(1,11),excel.getCellData(1,12));
        for (int i = 1; i < 6; i++){
            productTypesPage.AddProductTypeData(excel.getCellData(i+1,11),excel.getCellData(i+1,12));
        }
    }
    @Test (priority = 2)
    public void ProductsTypesTestFail() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productTypesPage = new ProductTypesPage(driver);
        productTypesPage.AddProductTypeSameID(excel.getCellData(1,11),excel.getCellData(1,12));
    }
    @Test (priority = 3)
    public void EditProductsTypes() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productTypesPage = new ProductTypesPage(driver);
        productTypesPage.EditProductType();
    }
    @Test (priority = 4)
    public void RemoveProductsTypes() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productTypesPage = new ProductTypesPage(driver);
        productTypesPage.RemoveProductType();
    }
}

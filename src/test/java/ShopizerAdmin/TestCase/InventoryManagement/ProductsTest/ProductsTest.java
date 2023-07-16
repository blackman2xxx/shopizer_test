package ShopizerAdmin.TestCase.InventoryManagement.ProductsTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductsPage.ProductsPage;
import org.testng.annotations.Test;

public class ProductsTest extends Init{
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public ExcelHelpers excel;
    @Test
    public void ProductsTest() throws Exception{
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productsPage = new ProductsPage(driver);
//        productsPage.AddProduct(excel.getCellData(1,25),excel.getCellData(1,26),excel.getCellData(1,27),excel.getCellData(1,28),excel.getCellData(1,29),excel.getCellData(1,30),excel.getCellData(1,31),excel.getCellData(1,32));

        productsPage.AddProduct(excel.getCellData(2,25),excel.getCellData(2,26),excel.getCellData(2,27),excel.getCellData(2,28),excel.getCellData(2,29),excel.getCellData(2,30),excel.getCellData(2,31),excel.getCellData(2,32));
//        productTypesPage = new ProductTypesPage(driver);
//        productTypesPage.AddProductType(excel.getCellData(1,11),excel.getCellData(1,12));
//        productTypesPage.ListCheck(excel.getCellData(1,11));
//        for (int i = 1; i < 5; i++){
//            productTypesPage.AddProductTypeData(excel.getCellData(i+1,11),excel.getCellData(i+1,12));
//        }
    }
}

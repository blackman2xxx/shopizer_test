package ShopizerAdmin.TestCase.InventoryManagement.ProductsTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductsPage.ProductsPage;
import org.testng.annotations.Test;

public class ProductsTest extends Init {
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public ExcelHelpers excel;

    @Test(priority = 1)
    public void ProductsTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath, "data");
        loginPage.SignIn(excel.getCellData(1, 0), excel.getCellData(1, 1));
        productsPage = new ProductsPage(driver);
        productsPage.AddProduct(excel.getCellData(1, 25), excel.getCellData(1, 26), excel.getCellData(1, 27), excel.getCellData(1, 28), excel.getCellData(1, 29), excel.getCellData(1, 30), excel.getCellData(1, 31), excel.getCellData(1, 32), excel.getCellData(1, 33), excel.getCellData(1, 34), excel.getCellData(1, 35));
        for (int i = 1; i < 10; i++) {
            productsPage.AddProductDataAo(excel.getCellData(i + 1, 25), excel.getCellData(i + 1, 26), excel.getCellData(i + 1, 27), excel.getCellData(i + 1, 28), excel.getCellData(i + 1, 29), excel.getCellData(i + 1, 30), excel.getCellData(i + 1, 31), excel.getCellData(i + 1, 32), excel.getCellData(i + 1, 33), excel.getCellData(i + 1, 34), excel.getCellData(i + 1, 35), excel.getCellData(i + 1, 36));
        }
        for (int i = 10; i < 20; i++) {
            productsPage.AddProductDataQuan(excel.getCellData(i + 1, 25), excel.getCellData(i + 1, 26), excel.getCellData(i + 1, 27), excel.getCellData(i + 1, 28), excel.getCellData(i + 1, 29), excel.getCellData(i + 1, 30), excel.getCellData(i + 1, 31), excel.getCellData(i + 1, 32), excel.getCellData(i + 1, 33), excel.getCellData(i + 1, 34), excel.getCellData(i + 1, 35), excel.getCellData(i + 1, 36));
        }
//        productsPage.SetUp();
        for (int i = 20; i < 30; i++) {
            productsPage.AddProductDataQuanlot(excel.getCellData(i + 1, 25), excel.getCellData(i + 1, 26), excel.getCellData(i + 1, 27), excel.getCellData(i + 1, 28), excel.getCellData(i + 1, 29), excel.getCellData(i + 1, 30), excel.getCellData(i + 1, 31), excel.getCellData(i + 1, 32), excel.getCellData(i + 1, 33), excel.getCellData(i + 1, 34), excel.getCellData(i + 1, 35), excel.getCellData(i + 1, 36));
        }
        for (int i = 30; i < 40; i++) {
            productsPage.AddProductDataPhukien(excel.getCellData(i + 1, 25), excel.getCellData(i + 1, 26), excel.getCellData(i + 1, 27), excel.getCellData(i + 1, 28), excel.getCellData(i + 1, 29), excel.getCellData(i + 1, 30), excel.getCellData(i + 1, 31), excel.getCellData(i + 1, 32), excel.getCellData(i + 1, 33), excel.getCellData(i + 1, 36));
        }
        for (int i = 40; i < 42; i++) {
            productsPage.AddProductDataTest(excel.getCellData(i + 1, 25), excel.getCellData(i + 1, 26), excel.getCellData(i + 1, 27), excel.getCellData(i + 1, 28), excel.getCellData(i + 1, 29), excel.getCellData(i + 1, 30), excel.getCellData(i + 1, 31), excel.getCellData(i + 1, 32));
        }
    }

    @Test(priority = 2)
    public void SearchByID() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath, "data");
        loginPage.SignIn(excel.getCellData(1, 0), excel.getCellData(1, 1));
        productsPage = new ProductsPage(driver);
        productsPage.SearchByID(excel.getCellData(5, 25));
    }

    @Test(priority = 3)
    public void SearchByName() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath, "data");
        loginPage.SignIn(excel.getCellData(1, 0), excel.getCellData(1, 1));
        productsPage = new ProductsPage(driver);
        productsPage.SearchByName(excel.getCellData(5, 29));
    }
    @Test(priority = 4)
    public void AddProductSameID() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath, "data");
        loginPage.SignIn(excel.getCellData(1, 0), excel.getCellData(1, 1));
        productsPage = new ProductsPage(driver);
        productsPage.SetUp();
        productsPage.AddProductSameID(excel.getCellData(1, 25), excel.getCellData(1, 26), excel.getCellData(1, 27), excel.getCellData(1, 28), excel.getCellData(1, 29), excel.getCellData(1, 30), excel.getCellData(1, 31), excel.getCellData(1, 32));
    }
    @Test(priority = 5)
    public void EditProduct() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath, "data");
        loginPage.SignIn(excel.getCellData(1, 0), excel.getCellData(1, 1));
        productsPage = new ProductsPage(driver);
        productsPage.EditProduct("Product Test 10");
    }
    @Test(priority = 6)
    public void RemoveProduct() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath, "data");
        loginPage.SignIn(excel.getCellData(1, 0), excel.getCellData(1, 1));
        productsPage = new ProductsPage(driver);
        productsPage.RemoveProduct();
    }
}

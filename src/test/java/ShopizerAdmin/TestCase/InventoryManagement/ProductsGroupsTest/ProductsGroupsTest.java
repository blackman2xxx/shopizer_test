package ShopizerAdmin.TestCase.InventoryManagement.ProductsGroupsTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.InventoryManagementPage.ProductsGroupsPage.ProductsGroupsPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;

import org.testng.annotations.Test;

public class ProductsGroupsTest extends Init{
    public LoginPage loginPage;
    public ProductsGroupsPage productsGroupsPage;
    public ExcelHelpers excel;
    @Test (priority = 1)
    public void ProductsGroupsTest() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productsGroupsPage = new ProductsGroupsPage(driver);
        productsGroupsPage.AddProductsGroups(excel.getCellData(1,14));
        for (int i = 1; i < 5; i++){
            productsGroupsPage.AddProductsGroupsData(excel.getCellData(i+1,14));
        }
    }
    @Test (priority = 2)
    public void SearchByCode() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productsGroupsPage = new ProductsGroupsPage(driver);
        productsGroupsPage.SearchByCode(excel.getCellData(2,14));
    }
    @Test (priority = 3)
    public void ProductsGroupsSameID() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productsGroupsPage = new ProductsGroupsPage(driver);
        productsGroupsPage.AddProductsGroupsSameID(excel.getCellData(1,14));
    }
    @Test (priority = 4)
    public void EditProductsGroups() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productsGroupsPage = new ProductsGroupsPage(driver);
        productsGroupsPage.EditProductsGroups();
    }
    @Test (priority = 5)
    public void RemoveProductsGroups() throws Exception{
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        productsGroupsPage = new ProductsGroupsPage(driver);
        productsGroupsPage.RemoveProductsGroups();
    }
}

package ShopizerAdmin.TestCase.InventoryManagement.Category;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.InventoryManagementPage.CategoryPage.CategoryPage;
import org.testng.annotations.Test;

public class CategoryTest extends Init{
    public LoginPage loginPage;
    public CategoryPage categoryPage;
    public ExcelHelpers excel;
    @Test
    public void CategoryTest() throws Exception {
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        categoryPage = new CategoryPage(driver);
        categoryPage.AddCategory(excel.getCellData(1,4), excel.getCellData(1,5), excel.getCellData(1,6), excel.getCellData(1,7));
        categoryPage.ListCheck(excel.getCellData(1,7),excel.getCellData(1,4));
        for (int i = 1; i < 5; i++) {
            categoryPage.AddCategoryData(excel.getCellData(i+1,4), excel.getCellData(i+1,5), excel.getCellData(i+1,6), excel.getCellData(i+1,7));
        }

    }
    @Test
    public void CategoryTestFail() throws Exception {
        driver.get("http://localhost:4200/");
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        categoryPage = new CategoryPage(driver);
        categoryPage.AddCategory(excel.getCellData(1,4), excel.getCellData(1,5), excel.getCellData(1,6), excel.getCellData(1,7));
        categoryPage.ListCheck(excel.getCellData(1,7),excel.getCellData(1,4));
    }
}

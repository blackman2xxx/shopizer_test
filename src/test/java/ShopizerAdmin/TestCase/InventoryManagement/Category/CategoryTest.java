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
    @Test (priority = 1)
    public void CategoryTest() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        categoryPage = new CategoryPage(driver);
        categoryPage.AddCategory(excel.getCellData(1,4), excel.getCellData(1,5), excel.getCellData(1,6), excel.getCellData(1,7));
        for (int i = 1; i < 5; i++) {
            categoryPage.AddCategoryData(excel.getCellData(i+1,4), excel.getCellData(i+1,5), excel.getCellData(i+1,6), excel.getCellData(i+1,7));
        }

    }
    @Test (priority = 2)
    public void AddCategorySameID() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        categoryPage = new CategoryPage(driver);
        categoryPage.AddCategorySameID(excel.getCellData(1,4), excel.getCellData(1,5), excel.getCellData(1,6), excel.getCellData(1,7));
    }
    @Test (priority = 3)
    public void EditCategory() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        categoryPage = new CategoryPage(driver);
        categoryPage.EditCategory("Nổi bật 1");
    }
    @Test (priority = 4)
    public void RemoveCategory() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        categoryPage = new CategoryPage(driver);
        categoryPage.RemoveCategory();
    }
}

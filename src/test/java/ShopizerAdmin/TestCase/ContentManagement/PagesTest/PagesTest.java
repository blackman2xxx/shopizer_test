package ShopizerAdmin.TestCase.ContentManagement.PagesTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.ContentManagementPage.ContentPagesPage.PagesPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class PagesTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public PagesPage pagesPage;
    @Test (priority = 1)
    public void AddPage () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        pagesPage = new PagesPage(driver);
        pagesPage.AddPage(excel.getCellData(1,60),excel.getCellData(1,61),excel.getCellData(1,62),excel.getCellData(1,63),excel.getCellData(1,64),excel.getCellData(1,65));
    }
    @Test (priority = 2)
    public void EditPage () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        pagesPage = new PagesPage(driver);
        pagesPage.EditPage("Content Name 10");
    }
    @Test (priority = 3)
    public void RemovePage () throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        pagesPage = new PagesPage(driver);
        pagesPage.RemovePage();
    }
}

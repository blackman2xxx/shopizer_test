package ShopizerAdmin.TestCase.ContentManagement.BoxesTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.ContentManagementPage.ContentBoxesPage.BoxesPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class BoxesTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public BoxesPage boxesPage;
    @Test (priority = 1)
    public void AddBox() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        boxesPage = new BoxesPage(driver);
        boxesPage.AddBox(excel.getCellData(1,66),excel.getCellData(1,67));
    }
    @Test (priority = 2)
    public void EditBox() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        boxesPage = new BoxesPage(driver);
        boxesPage.EditBox("Content Page 10");
    }
    @Test (priority = 3)
    public void RemoveBox() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        boxesPage = new BoxesPage(driver);
        boxesPage.RemoveBox();
    }
}

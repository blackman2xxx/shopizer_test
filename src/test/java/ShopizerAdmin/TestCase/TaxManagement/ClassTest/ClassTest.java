package ShopizerAdmin.TestCase.TaxManagement.ClassTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import ShopizerAdmin.Pages.TaxManagementPage.TaxClassPage.TaxClassPage;
import org.testng.annotations.Test;

public class ClassTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public TaxClassPage taxClassPage;
    @Test (priority = 1)
    public void AddClass() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxClassPage = new TaxClassPage(driver);
        taxClassPage.AddClass(excel.getCellData(1,79),excel.getCellData(1,80));
        for (int i = 1; i < 6; i++) {
            taxClassPage.AddClassData(excel.getCellData(i+1,79),excel.getCellData(i+1,80));
        }
    }
    @Test (priority = 2)
    public void AddClassSameCode() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxClassPage = new TaxClassPage(driver);
        taxClassPage.AddClassSameCode(excel.getCellData(1,79),excel.getCellData(1,80));
    }
    @Test (priority = 3)
    public void EditClass() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxClassPage = new TaxClassPage(driver);
        taxClassPage.EditClass("Class 10");
    }
    @Test (priority = 4)
    public void RemoveClass() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        taxClassPage = new TaxClassPage(driver);
        taxClassPage.RemoveClass();
    }
}

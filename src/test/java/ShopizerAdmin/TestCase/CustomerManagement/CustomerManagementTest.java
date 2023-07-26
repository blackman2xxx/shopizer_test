package ShopizerAdmin.TestCase.CustomerManagement;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerAdmin.Pages.CustomerManagementPage.CustomerManagementPage;
import ShopizerAdmin.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class CustomerManagementTest extends Init {
    public LoginPage loginPage;
    public ExcelHelpers excel;
    public CustomerManagementPage customerManagementPage;
    @Test (priority = 1)
    public void AddCustomer() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        customerManagementPage = new CustomerManagementPage(driver);
        customerManagementPage.AddCustomer(excel.getCellData(1,85),excel.getCellData(1,86),excel.getCellData(1,87),excel.getCellData(1,88),excel.getCellData(1,89),excel.getCellData(1,90),excel.getCellData(1,91),excel.getCellData(1,92),excel.getCellData(1,93));
//        customerManagementPage.AddCustomerData(excel.getCellData(2,85),excel.getCellData(2,86),excel.getCellData(2,87),excel.getCellData(2,88),excel.getCellData(2,89),excel.getCellData(2,90),excel.getCellData(2,91),excel.getCellData(2,92),excel.getCellData(2,93));
    }
    @Test (priority = 2)
    public void EditCustomer() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        customerManagementPage = new CustomerManagementPage(driver);
        customerManagementPage.EditCustomer("test@gmail.com");
    }
    @Test (priority = 3)
    public void RemoveCustomer() throws Exception {
        driver.get(urlAdmin);
        loginPage = new LoginPage(driver);
        excel = new ExcelHelpers();
        excel.setExcelFile(excelPath,"data");
        loginPage.SignIn(excel.getCellData(1,0), excel.getCellData(1,1 ));
        customerManagementPage = new CustomerManagementPage(driver);
        customerManagementPage.RemoveCustomer();
    }
}

package ShopizerUser.TestCase.AccountTest;

import Initialization.ExcelHelpers;
import Initialization.Init;
import ShopizerUser.Pages.AccountPage.AccountPage;
import ShopizerUser.Pages.LoginPage.LoginPage;
import org.testng.annotations.Test;

public class AccountTest extends Init{
    public LoginPage loginPage;
    public AccountPage accountPage;
    public ExcelHelpers excel;
    @Test
    public void UpdateBillingAddress() throws Exception {
        driver.get(urlUser);

        excel = new ExcelHelpers();
        excel.setExcelFile("D:\\H\\ShopizerTestData.xlsx","data");
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        loginPage.Login(excel.getCellData(1,2), excel.getCellData(1,3 ));
        accountPage.UpdateBillingAddress(excel.getCellData(1,39),excel.getCellData(1,40),excel.getCellData(1,41),excel.getCellData(1,42),excel.getCellData(1,43),excel.getCellData(1,44),excel.getCellData(1,45));
        accountPage.LogOut();
        driver.get(urlUser);
        loginPage.LoginWithoutAccept(excel.getCellData(2,2), excel.getCellData(1,3 ));
        accountPage.UpdateBillingAddress(excel.getCellData(1,39),excel.getCellData(1,40),excel.getCellData(1,41),excel.getCellData(1,42),excel.getCellData(1,43),excel.getCellData(1,44),excel.getCellData(1,45));
        accountPage.LogOut();
        driver.get(urlUser);
        loginPage.LoginWithoutAccept(excel.getCellData(3,2), excel.getCellData(1,3 ));
        accountPage.UpdateBillingAddress(excel.getCellData(1,39),excel.getCellData(1,40),excel.getCellData(1,41),excel.getCellData(1,42),excel.getCellData(1,43),excel.getCellData(1,44),excel.getCellData(1,45));
        accountPage.LogOut();
        driver.get(urlUser);
        loginPage.LoginWithoutAccept(excel.getCellData(4,2), excel.getCellData(1,3 ));
        accountPage.UpdateBillingAddress(excel.getCellData(1,39),excel.getCellData(1,40),excel.getCellData(1,41),excel.getCellData(1,42),excel.getCellData(1,43),excel.getCellData(1,44),excel.getCellData(1,45));
        accountPage.LogOut();
        driver.get(urlUser);
        loginPage.LoginWithoutAccept(excel.getCellData(5,2), excel.getCellData(1,3 ));
        accountPage.UpdateBillingAddress(excel.getCellData(1,39),excel.getCellData(1,40),excel.getCellData(1,41),excel.getCellData(1,42),excel.getCellData(1,43),excel.getCellData(1,44),excel.getCellData(1,45));
        accountPage.LogOut();
        driver.get(urlUser);
    }

}

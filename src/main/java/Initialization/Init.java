package Initialization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Init {

    public WebDriver driver = null;
    public String urlAdmin = "http://localhost:4200/";
    public String urlUser = "http://localhost/";
//    public String excelPath = "D:\\H\\ShopizerTestData.xlsx";
    public String excelPath = "src/test/resources/ShopizerTestData.xlsx";
    @BeforeMethod
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
        // Đặt thời gian chời ngầm định cho tất cả các element (đơn vị Giây)
        // Ví dụ thiết lập 20 giây cho tất cả
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Thiết lập thời gian chờ Load page xong mới thao tác (tối đa 20s)
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void TearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}

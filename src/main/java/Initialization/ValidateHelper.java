package Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHelper {
    WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public Select select;
    public JavascriptExecutor js;
//    public Robot robot;

    public ValidateHelper(WebDriver driver)  {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
//        robot = new Robot();
    }

    public void clickElement(By by) {
        waitForPageLoaded();
        //Chờ đợi click (xem có hiển thị không)
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        // xem có click đc k
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
       // wait.until(ExpectedConditions.elementToBeClickable(by));
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
        //Click
        driver.findElement(by).click();
//        js.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public void clickElementwithJS(By by) {
        waitForPageLoaded();
        //Chờ đợi click (xem có hiển thị không)
       // wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //kéo đến phần tử đó
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
        // xem có click đc k
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
//        wait.until(ExpectedConditions.elementToBeClickable(by));
        //Click
//        driver.findElement(by).click();
        js.executeScript("arguments[0].click();", driver.findElement(by));
    }
    public void scrollTo (By by) {
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }
     public void scroll100 (){
         js.executeScript("window.scrollBy(0,100)", "");
     }

    public void sendText(By by, String value) {
        waitForPageLoaded();
        //Chờ đợi click
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        clickElementwithJS(by);
//        driver.findElement(by).click();
        driver.findElement(by).clear();
        //Sendkey
        driver.findElement(by).sendKeys(value);
    }
    public String getText(By by) {
        return driver.findElement(by).getText();}
    public String getAttribute(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);}

    public void sendTextKey (By by, Keys key) {
        driver.findElement(by).sendKeys(key);
    }

    public void rightClickElement (By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        action.contextClick().build().perform();
    }

    //Handle dropdown tĩnh
    public void selectOptionByText (By by, String Text) {
        select = new Select(driver.findElement(by));
        select.selectByVisibleText(Text);
    }

    public void selectOptionByValue (By by, String Value) {
        select = new Select(driver.findElement(by));
        select.selectByValue(Value);
    }

    public void selectOptionByIndex (By by, int Index) {
        select = new Select(driver.findElement(by));
        select.selectByIndex(Index);
    }

    public void selectOptionTotal (By by, int total) {
        select = new Select(driver.findElement(by));
        Assert.assertEquals(total, select.getOptions().size());
    }

    public void delay(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String regexProfileID (By by) {
        Pattern pattern = Pattern.compile("\\d{3}.\\d{2}.\\d{2}.\\w\\d{2}.\\d{6}.\\d{4}");
//        Pattern pattern = Pattern.compile("\\1(.+)");
        String input = driver.findElement(by).getText();
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String output = input.substring(matcher.start(), matcher.end());

            return output;
        } else return null;
    }

    public void uploadFile (By by, String Path) throws AWTException {
        Robot robot = new Robot();
        clickElementwithJS(by);
        robot.delay(1000);
        StringSelection selection = new StringSelection(Path);
//        StringSelection selection = new StringSelection("C:\\Users\\Anh Tu\\Desktop\\xuatmahoso.java.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        /*
        1. Copy the path
        2. CTRL+V
        3. Enter
         */

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}

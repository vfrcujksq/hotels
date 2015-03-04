package performance.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import performance.test.util.PropertyLoader;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;


public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static String devbaseUrl;
  protected static Capabilities capabilities;
  public boolean acceptNextAlert = true;
  protected  StringBuffer verificationErrors = new StringBuffer();
  protected  WebDriver driver;
  protected WebDriverWait wait ;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url"); 
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
//    driver.manage().window().setSize(new Dimension(1050, 600));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    wait = new WebDriverWait(driver, 20);
    
  }
  
   @AfterSuite(alwaysRun = true)
  protected void tearDown() {
    WebDriverFactory.dismissAll();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
     fail(verificationErrorString);
    }
    
  }

  protected boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  protected boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

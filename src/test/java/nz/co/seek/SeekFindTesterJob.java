package nz.co.seek;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeekFindTesterJob {
  private WebDriver driver;
  private String baseUrl;
  //private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.seek.co.nz/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("lillian.cheng2012@gmail.com");
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("Password");
    driver.findElement(By.cssSelector("button.mod-button.state-button-primary")).click();
    
    driver.findElement(By.id("keywords")).clear();
    driver.findElement(By.id("keywords")).sendKeys("tester");
    driver.findElement(By.cssSelector("button.seek-button--primary")).click();
    assertEquals("tester", driver.findElement(By.cssSelector("span.active-filter-keywords")).getText());
    
    driver.findElement(By.linkText("Save search")).click();
    assertEquals("Search saved. New jobs for tester in New Zealand will be emailed daily.\nEdit saved searches in My Activity.", driver.findElement(By.cssSelector("div.confirmation > span")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}

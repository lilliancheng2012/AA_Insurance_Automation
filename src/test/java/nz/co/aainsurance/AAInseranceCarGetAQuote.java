package nz.co.aainsurance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * The Class AAInserance_Car_GetAQuote.
 */
public class AAInseranceCarGetAQuote {

	/** The driver. */
	private WebDriver driver;
	
	/** The base url. */
	private String baseUrl;
	
	/** The verification errors. */
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.aainsurance.co.nz/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Car get A quote find your car.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void carGetAQuoteFindYourCar() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Get a quote")).click();

		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> itererator = windowId.iterator();
		itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);

		assertEquals("Find Your Car", driver.findElement(By.cssSelector("span.sg-Progress-text")).getText());
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(.,'Comprehensive')]")).click();

		// Choose 'No', I am not an AA member.
		driver.findElement(By.xpath("//span[contains(.,'No')]")).click();

		driver.findElement(By.cssSelector("#vehicleYearOfManufactureList > option[value=\"2004\"]")).click();
		Thread.sleep(1000);
		// new Select(driver.findElement(By.id("vehicleMakeList"))).selectByVisibleText("Nissan");
		driver.findElement(By.cssSelector("option[value=\"NISSAN\"]")).click();

		// new Select(driver.findElement(By.id("vehicleModelList"))).selectByVisibleText("March");
		driver.findElement(By.cssSelector("option[value=\"MARCH\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("findcar")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("vehicleSearchResult0")).click();
		driver.findElement(By.id("_eventId_submit")).click();

		//System go to 'Car Features' page once click 'Car Features' button on 'Find Your Car'
		assertEquals("Car Features",
				driver.findElement(By.cssSelector("#car-features-aainz > span.sg-Progress-text")).getText());
		assertEquals("Accessories and modifications we cover", driver.findElement(By.cssSelector("h2")).getText());

		// test Car Features
		driver.findElement(By.xpath("//div[@id='otherAccessoriesModificationsButtons']/label[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("_eventId_submit")).click();

		// test Car Details
		assertEquals(driver.findElement(By.cssSelector("#car-details-aainz > span.sg-Progress-text")).getText(),"Car Details");
		
		driver.findElement(By.xpath("//div[@id='vehicleFinance.financedButtons']/label[2]/span")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(.,'Private')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("address.suburbPostcodeRegionCity")).clear();
		driver.findElement(By.id("address.suburbPostcodeRegionCity")).sendKeys("MOUNT WELLINGTON, 1060, AUCKLAND");
		Thread.sleep(1000);
		
		driver.findElement(By.id("address.streetAddress")).clear();
		driver.findElement(By.id("address.streetAddress")).sendKeys("242 Penrose Road");
		Thread.sleep(1000);
		
		driver.findElement(By.id("_eventId_submit")).click();
		
		// test Driver Details
		assertEquals(driver.findElement(By.cssSelector("#driver-details-aainz > span.sg-Progress-text")).getText(),"Driver Details");
		//Main driver's date of birth
		driver.findElement(By.id("mainDriver.dateOfBirth")).sendKeys("18-10-1989");
		
	    driver.findElement(By.xpath("//div[@id='mainDriver.driverGenderButtons']/label[2]/span")).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//div[@id='existingPoliciesButtons']/label[2]/span")).click();
	    Thread.sleep(1000);
	    
	    new Select(driver.findElement(By.id("previousInsurerList"))).selectByVisibleText("AA INSURANCE");
	    driver.findElement(By.cssSelector("option[value=\"AA\"]")).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.cssSelector("#mainDriverNumberOfAccidentsOccurrencesButtons > label > span")).click();
	    driver.findElement(By.cssSelector("#numberOfAdditionalDriversButtons > label > span")).click();
	    driver.findElement(By.id("_eventId_submit")).click();
	    
	    //Test Quote page
	    assertEquals("Your quote number:", driver.findElement(By.cssSelector("span.text")).getText());
	    assertEquals("Pay\nAnnually", driver.findElement(By.id("payAnnuallySelected")).getText());
	    assertEquals("$643.67", driver.findElement(By.cssSelector("span.amount")).getText());
	    assertEquals("Buy online now", driver.findElement(By.id("_eventId_buy")).getText());
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}

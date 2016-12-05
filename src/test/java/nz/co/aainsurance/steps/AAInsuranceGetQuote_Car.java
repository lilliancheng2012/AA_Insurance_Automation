package nz.co.aainsurance.steps;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.co.aainsurance.model.Profile;

/**
 * The Class AAInsuranceGetQuote_Car.
 */
public class AAInsuranceGetQuote_Car {

	/** The driver. */
	private WebDriver driver;
	
	/** The base url. */
	private String baseUrl;

	/**
	 * I go to A A insurance website.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^I go to AA Insurance website$")
	public void i_go_to_AA_Insurance_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:/Dev/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.aainsurance.co.nz/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(baseUrl);
	}

	/**
	 * I want to by car insurance.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^I want to by car insurance$")
	public void i_want_to_by_car_insurance() throws Throwable {
		driver.findElement(By.linkText("Get a quote")).click();

		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);

		assertEquals("Find Your Car", driver.findElement(By.cssSelector("span.sg-Progress-text")).getText());
		Thread.sleep(2000);
	}

	/**
	 * I choose type of car insurance cover is.
	 *
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Given("^I choose type of car insurance cover is \"([^\"]*)\"$")
	public void i_choose_type_of_car_insurance_cover_is(String arg1) throws Throwable {

		driver.findElement(By.xpath("//span[contains(.,'" + arg1 + "')]")).click();

	}

	/**
	 * I want the policy start date is today.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^I want the Policy start date is today$")
	public void i_want_the_Policy_start_date_is_today() throws Throwable {

	}

	/**
	 * I am not an A A insurance member.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^I am not an AA insurance member$")
	public void i_am_not_an_AA_insurance_member() throws Throwable {
		// Choose 'No', I am not an AA member.
		driver.findElement(By.xpath("//span[contains(.,'No')]")).click();
	}

	/**
	 * My car year of manufacture is.
	 *
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Given("^My car Year Of Manufacture is \"([^\"]*)\"$")
	public void my_car_Year_Of_Manufacture_is(String arg1) throws Throwable {
		driver.findElement(By.cssSelector("#vehicleYearOfManufactureList > option[value=\"" + arg1 + "\"]")).click();
		Thread.sleep(1000);
	}

	/**
	 * The car make is.
	 *
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Given("^The car Make is \"([^\"]*)\"$")
	public void the_car_Make_is(String arg1) throws Throwable {
		driver.findElement(By.cssSelector("option[value=\"" + arg1 + "\"]")).click();
	}

	/**
	 * The car module is.
	 *
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Given("^The car module is \"([^\"]*)\"$")
	public void the_car_module_is(String arg1) throws Throwable {
		driver.findElement(By.cssSelector("option[value=\"" + arg1 + "\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("findcar")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("vehicleSearchResult0")).click();
		driver.findElement(By.id("_eventId_submit")).click();
	}

	/**
	 * I don t cover accessories and modifications.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^I don't cover Accessories and modifications$")
	public void i_don_t_cover_Accessories_and_modifications() throws Throwable {
		// System go to 'Car Features' page once click 'Car Features' button on
		// 'Find Your Car'
		assertEquals("Car Features",
				driver.findElement(By.cssSelector("#car-features-aainz > span.sg-Progress-text")).getText());
		assertEquals("Accessories and modifications we cover", driver.findElement(By.cssSelector("h2")).getText());

		// test Car Features
		driver.findElement(By.xpath("//div[@id='otherAccessoriesModificationsButtons']/label[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("_eventId_submit")).click();
	}

	/**
	 * I don t buy car on finance.
	 *
	 * @throws Throwable the throwable
	 */
	@Given("^I don't buy car on finance$")
	public void i_don_t_buy_car_on_finance() throws Throwable {
		// test Car Details
		assertEquals(driver.findElement(By.cssSelector("#car-details-aainz > span.sg-Progress-text")).getText(),
				"Car Details");

		driver.findElement(By.xpath("//div[@id='vehicleFinance.financedButtons']/label[2]/span")).click();
		Thread.sleep(1000);
	}

	/**
	 * I use my car as.
	 *
	 * @param arg1 the arg 1
	 * @throws Throwable the throwable
	 */
	@Given("^I use my car as \"([^\"]*)\"$")
	public void i_use_my_car_as(String arg1) throws Throwable {
		driver.findElement(By.xpath("//span[contains(.,'" + arg1 + "')]")).click();
		Thread.sleep(1000);
	}

	/**
	 * My personal details as below.
	 *
	 * @param dataTable the data table
	 * @throws Throwable the throwable
	 */
	@Given("^My personal details as below:$")
	public void my_personal_details_as_below(DataTable dataTable) throws Throwable {

		List<Profile> profileList = dataTable.asList(Profile.class);
		Profile profile = profileList.get(0);

		driver.findElement(By.id("address.suburbPostcodeRegionCity")).clear();
		driver.findElement(By.id("address.suburbPostcodeRegionCity")).sendKeys(profile.getSuburb());
		Thread.sleep(1000);

		driver.findElement(By.id("address.streetAddress")).clear();
		driver.findElement(By.id("address.streetAddress")).sendKeys(profile.getStreet());
		Thread.sleep(1000);

		driver.findElement(By.id("_eventId_submit")).click();

		// test Driver Details
		assertEquals(driver.findElement(By.cssSelector("#driver-details-aainz > span.sg-Progress-text")).getText(),
				"Driver Details");
		
		// Main driver's date of birth
		driver.findElement(By.id("mainDriver.dateOfBirth")).sendKeys(profile.getDatebirth());

		if (profile.getSex().equalsIgnoreCase("Female")) {
			driver.findElement(By.xpath("//div[@id='mainDriver.driverGenderButtons']/label[2]/span")).click();
		} else {
			driver.findElement(By.xpath("//div[@id='mainDriver.driverGenderButtons']/label[1]/span")).click();
		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@id='existingPoliciesButtons']/label[2]/span")).click();
		Thread.sleep(1000);

		new Select(driver.findElement(By.id("previousInsurerList"))).selectByVisibleText("AA INSURANCE");
		driver.findElement(By.cssSelector("option[value=\"AA\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("#mainDriverNumberOfAccidentsOccurrencesButtons > label > span")).click();
		driver.findElement(By.cssSelector("#numberOfAdditionalDriversButtons > label > span")).click();
	}

	/**
	 * I get my quote from the website.
	 *
	 * @throws Throwable the throwable
	 */
	@When("^I get my quote from the website$")
	public void i_get_my_quote_from_the_website() throws Throwable {
		driver.findElement(By.id("_eventId_submit")).click();
	}

	/**
	 * The premium fee should be per annual.
	 *
	 * @param premium the premium
	 * @throws Throwable the throwable
	 */
	@Then("^The premium fee should be \"([^\"]*)\" per annual$")
	public void the_premium_fee_should_be_per_annual(String premium) throws Throwable {
		// Test Quote page
		assertEquals("Your quote number:", driver.findElement(By.cssSelector("span.text")).getText());
		assertEquals("Pay\nAnnually", driver.findElement(By.id("payAnnuallySelected")).getText());
		assertEquals(premium, driver.findElement(By.cssSelector("span.amount")).getText());
		assertEquals("Buy online now", driver.findElement(By.id("_eventId_buy")).getText());

		driver.quit();
	}

}

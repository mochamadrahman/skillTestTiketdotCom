package pagefactory;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage {

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div/div[2]/label")
	WebElement roundtrip;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/input")
	WebElement airportFrom;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/ul/li[2]")
	WebElement cityFrom;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/input")
	WebElement airportTo;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div/div[2]/div/div/ul/li[5]/div/div")
	WebElement cityTo;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[4]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody/tr[3]/td[6]")
	WebElement departureDate;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/div[5]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody/tr[4]/td[5]")
	WebElement returnDate;

	@FindBy(className = "btn-done")
	WebElement doneButton;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[4]/button")
	WebElement searchFlightButton;

	@FindBy(xpath = "//*[@id='app']/div/div[5]/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]")
	WebElement understoodButton;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[1]/div/form/div/div[1]/div/div[2]/div/div[3]/div/label")
	WebElement oneTransit;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[1]")
	WebElement chooseDepartureFlight;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[2]/div/div[2]/div/div[2]/div[3]/div/div/div[1]/div/div[1]")
	WebElement chooseReturnFlight;
	
	@FindBy(xpath = "//*[@name='cp-phone']")
	WebElement inputPhoneNumber;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[3]/div/div[2]/div/div[1]/div/div[2]/div[2]/div/div[1]/label/span[2]")
	WebElement clickSwitchButon;
	
	@FindBy(xpath = "//*[@class='input-flight-dropdown-searchbox']")
	WebElement nationality;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[3]/div/div[2]/div/div[1]/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div[3]/div[2]/ul/li[1]")
	WebElement indonesia;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[3]/div/div[2]/div/div[1]/div/div[6]/button")
	WebElement payment;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div[3]/div/div[3]/div/div/div/div/div[3]/button[2]")
	WebElement confirmPayment;
	
	/* below 2 elements appear after click understoodButton with randomly */
	@FindBy(xpath = "//*[@id='ab-iam-18f6265ccc6dcdaeb10a79cc6e5cbf4d']/div[2]/div[1]")
	WebElement covid19Notification;
	
	@FindBy(xpath = "//*[@id='ab-iam-18f6265ccc6dcdaeb10a79cc6e5cbf4d']/div[2]/div[2]/button[2]")
	WebElement confirmCovid19Notification;
	

	WebDriver driver;

	public FlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void chooseRoundTrip() {
		roundtrip.click();
	}

	public void clickFrom() {
		airportFrom.click();
	}

	public void chooseFrom() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(cityFrom);
		hover.build().perform();
		sleep(1000);
		hover.click();
		sleep(1000);
		hover.build().perform();
	}

	public void clickTo() {
		airportTo.click();
	}

	public void chooseTo() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(cityTo);
		hover.build().perform();
		sleep(1000);
		hover.click();
		sleep(1000);
		hover.build().perform();
	}

	public void chooseDepartureDate() {
		departureDate.click();
	}

	public void chooseReturnDate() {
		returnDate.click();
	}

	public void doneButtonForFlight() {
		doneButton.click();
	}

	public void clickSearchFlight() {
		searchFlightButton.click();
	}

	public void clickUnderstood() {
		understoodButton.click();
	}
	
	public void oneTransit() {
		oneTransit.click();
	}
	
	public void chooseDepartureFlight() {
		chooseDepartureFlight.click();
	}
	
	/* handle popup notification related covid19*/
	public void randomPopUpNotifCovid19() {
	try {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        System.out.println("Window Covid19 notification accepted");
	
	} catch (TimeoutException ex) {
			System.out.println("No window Covid19 notification present within 10 seconds");
		}
	}
	
	public void confirmCovid19Notification() {
		confirmCovid19Notification.click();
	}
	
	public void chooseReturnFlight() {
		chooseReturnFlight.click();
	}
	
	public void inputPhoneNumber() {
		inputPhoneNumber.sendKeys("81383361755");
	}
	
	public void clickSwitchButton() {
		clickSwitchButon.click();
	}
	
	public void clickNationality() {
		nationality.click();
	}
	
	public void chooseNationality() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(indonesia);
		hover.build().perform();
		sleep(1000);
		hover.click();
		sleep(1000);
		hover.build().perform();
	}
	
	public void clickContinuePayment() {
		payment.click();
	}
	
	public void confirmContinuePayment() {
		confirmPayment.click();
	}
	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

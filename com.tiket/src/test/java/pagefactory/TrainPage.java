package pagefactory;

import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainPage {

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/input")
	WebElement stationFrom;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/ul/li[2]")
	WebElement cityFrom;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/div/input")
	WebElement stationTo;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/div/div/div[2]/ul/li[1]")
	WebElement cityTo;

	/* sixth day of week 4 */
	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody/tr[4]/td[7]/div")
	WebElement departureDate;

	/* + button to add numbers of adults */
	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[3]")
	WebElement addAdults;

	/* + button to add numbers of infants */
	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[3]")
	WebElement addInfants;

	/* done button */
	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[3]/button")
	WebElement doneButton;

	@FindBy(xpath = "//*[@id='formhome']/div/div/div[1]/div[3]/button")
	WebElement searchButton;

	/* choose train button */
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[3]/div/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/button")
	WebElement chooseDepartureTrain;

	@FindBy(xpath = "//*[@name='cp-phone']")
	WebElement inputPhoneNumber;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/label")
	WebElement clickSwitchButon;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[4]/div/input")
	WebElement idNumber;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div/input")
	WebElement infantName;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[4]/div/div[1]")
	WebElement birthDateField;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[4]/div/div[1]/div[1]/div/div[3]/ul/li[1]")
	WebElement dayOfBirth;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[4]/div/div[1]/div[3]/div/div[3]/ul/li[1]")
	WebElement monthOfBirth;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[4]/div/div[1]/div[5]/div/div[3]/ul/li[3]")
	WebElement yearOfBirth;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[4]/button[1]")
	WebElement seletcSeatButton;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[3]/div/div/div[2]/div/div/div")
	WebElement selectTrain;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div[4]/table/tr[6]/td[9]/div/div")
	WebElement selectSeat;

	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[4]/button")
	WebElement goToPayment;

	@FindBy(xpath = "//*[@class='btn active btn-continue']")
	WebElement buttonContinueToPayment;

	@FindBy(xpath = "//*[@id='popup']/div/div/div/div[5]/button[1]")
	WebElement confirmPayment;

	WebDriver driver;

	public TrainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFrom() {
		stationFrom.click();
	}

	public void chooseFrom() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(cityFrom);
		hover.build().perform();
		Thread.sleep(3000);
		hover.click();
		Thread.sleep(3000);
		hover.build().perform();
	}

	public void clickTo() {
		stationTo.click();
	}

	public void chooseTo() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(cityTo);
		hover.build().perform();
		Thread.sleep(3000);
		hover.click();
		Thread.sleep(3000);
		hover.build().perform();
	}

	public void chooseDepartureDate() {
		departureDate.click();
	}

	public void addAdults() {
		addAdults.click();
	}

	public void addInfants() {
		addInfants.click();
	}

	public void clickDoneAfterChoosePassengers() {
		doneButton.click();
	}

	public void clickSearch() {
		searchButton.click();
	}

	public void chooseDepartureTrain() {
		chooseDepartureTrain.click();
	}

	/* handle popup notification related covid19 */

	public void randomPopUpNotif() {
		try {
			WebDriverWait winwait = new WebDriverWait(driver, 3);
			String mainWindow = driver.getWindowHandle();

			// wait for 2 windows and get the handles
			Set<String> handles = winwait.until((WebDriver drv) -> {
				Set<String> items = drv.getWindowHandles();
				return items.size() == 2 ? items : null;
			});

			// set the context on the last opened window
			handles.remove(mainWindow);
			driver.switchTo().window(handles.iterator().next());

			// close the window
			driver.close();

			// set the context back to the main window
			driver.switchTo().window(mainWindow);

		} catch (TimeoutException ex) {
			System.out.println("No window Covid19 notification present within 3 seconds");
		}
	}

	public void inputPhoneNumber() {
		inputPhoneNumber.sendKeys("81383361755");
	}

	public void clickSwitchButton() {
		clickSwitchButon.click();
	}

	public void fillIDNumber(String nationalID) {
		idNumber.sendKeys(nationalID);
	}

	public void fillInfantName(String nameOfInfant) {
		infantName.sendKeys(nameOfInfant);
	}

	public void clickBirthDateField() {
		birthDateField.click();
	}

	public void chooseDateOfBirth() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(dayOfBirth);
		hover.build().perform();
		sleep(1000);
		hover.click();
		sleep(1000);
		hover.build().perform();
	}

	public void chooseMonthOfBirth() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(monthOfBirth);
		hover.build().perform();
		sleep(1000);
		hover.click();
		sleep(1000);
		hover.build().perform();
	}

	public void chooseYearOfBirth() throws InterruptedException {

		/* Mouse Hover */
		Actions action = new Actions(driver);
		Actions hover = action.moveToElement(yearOfBirth);
		hover.build().perform();
		sleep(1000);
		hover.click();
		sleep(1000);
		hover.build().perform();
	}

	public void clickSelectSeat() {
		seletcSeatButton.click();
	}

	public void selectTrain() {
		selectTrain.click();
	}

	public void selectSeat() {
		selectSeat.click();
	}

	public void clickGoToPayment() {
		goToPayment.click();
	}

	public void clickContinueToPayment() {
		buttonContinueToPayment.click();
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

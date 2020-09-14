package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.GoogleLoginPage;
import pagefactory.HomePage;
import pagefactory.LoginOptionPage;
import pagefactory.MyOrderPage;
import pagefactory.PaymentPage;
import pagefactory.ProfileHomePage;
import pagefactory.TrainPage;

public class ProductTrainSteps {

	WebDriver driver = null;

	HomePage home;
	LoginOptionPage loginOption;
	ProfileHomePage profileHomePage;
	GoogleLoginPage googleLogin;
	TrainPage train;
	PaymentPage payment;
	MyOrderPage myOrder;

	@Given("^user login with (.*) and (.*)$")
	public void user_login_with_email_and_password(String email, String password) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		
		/* create driver */
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/* open tiket.com page */
		driver.navigate().to("https://www.tiket.com/");
		
		/* maximize windows browser */
		driver.manage().window().maximize();
		
		/* user click login button to choose one of login option */
		home = new HomePage(driver);
		home.clickLoginButton();
		sleep(3000);
		
		/* user choose login with gmail account */
		loginOption = new LoginOptionPage(driver);
		loginOption.checkLogInGoogleButtonIsDisplayed();
		sleep(3000);
		loginOption.clickLoginGoogleButton();
		sleep(3000);
		
		/* user type email and password */
		googleLogin = new GoogleLoginPage(driver);
		googleLogin.typeEmail(email);
		sleep(3000);
		googleLogin.clickNextEmail();
		sleep(3000);
		googleLogin.typePassword(password);
		sleep(3000);
		googleLogin.clickNextPassword();

		/* verify profile account is display */
		profileHomePage = new ProfileHomePage(driver);
		profileHomePage.checkProfileAccountIsDisplay();

	}

	@When("user booking train for one-way trip with one adult and one infant")
	public void user_booking_train_for_one_way_trip_with_one_adult_and_one_infant() throws InterruptedException {

		profileHomePage = new ProfileHomePage(driver);
		profileHomePage.clickProductTrain();
		sleep(3000);

		/* Scroll down page little bit */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		train = new TrainPage(driver);

		/* perform departure station */
		train.clickFrom();
		sleep(3000);
		train.chooseFrom();
		sleep(3000);

		/* perform destination station */
		train.clickTo();
		sleep(3000);
		train.chooseTo();
		sleep(3000);

		/* perform departure date */
		train.chooseDepartureDate();
		sleep(3000);

		/* perform manage passengers */
		train.addInfants();
		sleep(3000);
		train.clickDoneAfterChoosePassengers();
		sleep(3000);

		train.clickSearch();
		sleep(3000);

		train.randomPopUpNotifCovid19();
		
		/* perform choose train */
		train.chooseDepartureTrain();
		sleep(3000);

		/* perform input data passengers */
		train.inputPhoneNumber();
		sleep(2000);
		train.clickSwitchButton();
		sleep(2000);

		/* Scroll down page small */
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		train.fillIDNumber("3201020912750009");
		sleep(2000);

		/* Scroll down page medium */
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		train.fillInfantName("Azhar Fahlavi");
		sleep(2000);
		train.clickBirthDateField();
		sleep(2000);
		train.chooseDateOfBirth();
		sleep(2000);
		train.chooseMonthOfBirth();
		sleep(2000);
		train.chooseYearOfBirth();
		sleep(2000);
		
		/*  perform select seat of passenger  */
		train.clickSelectSeat();
		sleep(2000);
		train.selectTrain();
		sleep(2000);
		train.selectSeat();
		sleep(2000);
		
		/*  perform continue to payment  */
		train.clickGoToPayment();
		sleep(2000);		
		train.confirmContinuePayment();
		sleep(7000);

	}

	@And("with non-instant payment schema")
	public void with_non_instant_payment_schema() {

		/* Scroll down page big */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*  choose non-instant payment with transfer bank to BCA*/
		payment = new PaymentPage(driver);
		sleep(5000);
		payment.chooseBankTransferBCA();
		sleep(5000);

	}

	@Then("user successful complete booking transaction")
	public void user_successful_complete_booking_transaction() {
		
		/*  identify orderID in payment page  */
		payment = new PaymentPage(driver);
		String orderIDPaymentPage = payment.orderIDTrainPaymentPage();
		payment.backToProfilePage();
		sleep(2000);

		/*  identify orderID in myorder page  */
		profileHomePage = new ProfileHomePage(driver);
		profileHomePage.clickMyOrder();
		myOrder = new MyOrderPage(driver);
		myOrder.clickButtonOK();
		sleep(5000);
		String orderIDMyorderPage = myOrder.orderIDTrainMyOrderPage();
		
//		String orderIDMyorderPage = myOrder.secondListMyOrderPage(); // To Test negative scenario with verify orderID's number 

		/* verify orderID are equal */
		Assert.assertTrue(orderIDMyorderPage.contains(orderIDPaymentPage), "OrderId NOT equal.\nOrderIDPayment: "
				+ orderIDPaymentPage + "\nOrderIDMyOrder: " + orderIDMyorderPage);

		System.out.println("OrderIDPaymentPage ==>" + orderIDPaymentPage);
		System.out.println("OrderIDMyOrderPage ==>" + orderIDMyorderPage);

		/*  perform back to profile home page and logout  */
		profileHomePage = new ProfileHomePage(driver);
		profileHomePage.clickProfileAccount();
		sleep(2000);
		profileHomePage.clickLogOut();
		sleep(2000);
		profileHomePage.clickYestoLogout();
		sleep(5000);

		driver.close();
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

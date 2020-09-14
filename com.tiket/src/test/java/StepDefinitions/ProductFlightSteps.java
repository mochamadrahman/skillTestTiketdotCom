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
import pagefactory.FlightPage;
import pagefactory.GoogleLoginPage;
import pagefactory.HomePage;
import pagefactory.LoginOptionPage;
import pagefactory.MyOrderPage;
import pagefactory.PaymentPage;
import pagefactory.ProfileHomePage;

public class ProductFlightSteps {

	WebDriver driver = null;

	HomePage home;
	LoginOptionPage loginOption;
	ProfileHomePage profileHomePage;
	GoogleLoginPage googleLogin;
	FlightPage flight;
	PaymentPage payment;
	MyOrderPage myOrder;

	@Given("^login with (.*) and (.*)$")
	public void login_with_email_and_password(String email, String password) {
		
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

	@When("user booking flight for domestic round trip with one transit")
	public void user_booking_flight_for_domestic_round_trip_with_one_transit() throws InterruptedException {
		
		/* user choose flight product */
		profileHomePage = new ProfileHomePage(driver);
		profileHomePage.clickProductFlight();
		sleep(3000);

		flight = new FlightPage(driver);
		sleep(3000);

		/* Scroll down page little */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*  choose trip type with departure and destination cities with date, and transit flights  */
		flight.chooseRoundTrip();
		sleep(3000);
		flight.clickFrom();
		sleep(3000);
		flight.chooseFrom();
		sleep(3000);
		flight.clickTo();
		sleep(3000);
		flight.chooseTo();
		sleep(3000);
		flight.chooseDepartureDate();
		sleep(3000);
		flight.chooseReturnDate();
		sleep(3000);
		flight.doneButtonForFlight();
		sleep(3000);
		flight.clickSearchFlight();
		sleep(3000);
		flight.clickUnderstood();
		sleep(3000);
		flight.randomPopUpNotifCovid19();
		flight.oneTransit();
		sleep(5000);
		flight.chooseDepartureFlight();
		sleep(3000);
		flight.randomPopUpNotifCovid19();
		flight.oneTransit();
		sleep(3000);
		flight.chooseReturnFlight();
		sleep(3000);
		
		/*  filled in passenger data administration  */
		flight.inputPhoneNumber();

		/* Scroll down page little bit */
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		flight.clickSwitchButton();
		sleep(2000);
		flight.clickNationality();
		sleep(2000);
		flight.chooseNationality();

		/* Scroll down page */
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,350)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*  perform continue to payment  */
		flight.clickContinuePayment();
		flight.confirmContinuePayment();
		sleep(7000);

	}

	@And("with virtual account payment schema")
	public void with_virtual_account_payment_schema() {

		/* Scroll down page */
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,250)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*  choose virtual account BCA as payment option  */
		payment = new PaymentPage(driver);
		sleep(5000);
		payment.chooseVaBca();
		sleep(3000);
		payment.clickContinueVaBca();

	}

	@Then("user complete booking transaction")
	public void user_complete_booking_transaction() {
		
		/*  identify orderID in payment page  */
		payment = new PaymentPage(driver);
		String orderIDPaymentPage = payment.orderIDFlightPaymentPage();
		payment.backToProfilePage();
		sleep(2000);
		
		/*  identify orderID in myorder page  */
		profileHomePage = new ProfileHomePage(driver);
		profileHomePage.clickMyOrder();
		sleep(2000);
		myOrder = new MyOrderPage(driver);
		myOrder.clickButtonOK();
		sleep(5000);
		String orderIDMyorderPage = myOrder.orderIDFlightMyOrderPage();

//		String orderIDMyorderPage = myOrder.secondListMyOrderPage(); // To Test negative scenario with verify orderID's number

		/*  verify orderID's are equal for both payment and myorder pages  */
		Assert.assertTrue(orderIDMyorderPage.contains(orderIDPaymentPage), "OrderId NOT equal.\nOrderIDPayment: "
				+ orderIDPaymentPage + "\nOrderIDMyOrder: " + orderIDMyorderPage);

		System.out.println("OrderIDPaymentPage ==>" + orderIDPaymentPage);
		System.out.println("OrderIDMyOrderPage ==>" + orderIDMyorderPage);

		/*  back to profile homepage and logout  */
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

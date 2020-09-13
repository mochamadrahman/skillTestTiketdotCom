package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	@FindBy(xpath = "//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/div[4]/div/a[1]/div")
	WebElement virtualAccountBCA;

	@FindBy(xpath = "//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div/div[4]/div[2]/button")
	WebElement clickContinueVaBca;

	@FindBy(xpath = "//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/p[2]")
	WebElement orderIDFlightPaymentPage;

	@FindBy(xpath = "//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/div[7]/div/a[1]/div")
	WebElement bankTransferBCA;

	@FindBy(xpath = "//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[1]/div/p[2]")
	WebElement orderIDTrainPaymentPage;

	@FindBy(xpath = "//*[@class='navbar-brand']")
	WebElement backToProfilePage;

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void chooseVaBca() {
		virtualAccountBCA.click();
	}

	public void clickContinueVaBca() {
		clickContinueVaBca.click();
	}

	public String orderIDFlightPaymentPage() {
		return orderIDFlightPaymentPage.getText();
	}

	public void chooseBankTransferBCA() {
		bankTransferBCA.click();
	}

	public String orderIDTrainPaymentPage() {
		return orderIDTrainPaymentPage.getText();
	}

	public void backToProfilePage() {
		backToProfilePage.click();
	}

}

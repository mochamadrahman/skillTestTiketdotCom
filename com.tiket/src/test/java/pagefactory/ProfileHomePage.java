package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileHomePage {

	@FindBy(className = "account-label")
	WebElement btn_profile_account;

	@FindBy(xpath = "//*[@class='account-item-container'][last()]")
	WebElement btn_logout;

	@FindBy(className = "logout-yes")
	WebElement btn_yes;

	@FindBy(xpath = "//*[@id='app']/div/div/div[3]/div[1]/div[3]/div/div[1]/div[2]/div[1]/a")
	WebElement flight;
	
	@FindBy(xpath = "//*[@id='app']/div/div/div[3]/div[1]/div[3]/div/div[1]/div[2]/div[4]/a")
	WebElement train;
	
	@FindBy(xpath = "//*[@id='app']/div/div/div[3]/div[1]/div[3]/div/div[2]/a[2]")
	WebElement myOrder;

	WebDriver driver;

	public ProfileHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void checkProfileAccountIsDisplay() {
		btn_profile_account.isDisplayed();
	}

	public void clickProfileAccount() {
		btn_profile_account.click();
	}

	public void clickLogOut() {
		btn_logout.click();
	}

	public void clickYestoLogout() {
		btn_yes.click();
	}

	public void clickProductFlight() {
		flight.click();
	}
	
	public void clickProductTrain() {
		train.click();
	}
	
	public void clickMyOrder() {
		myOrder.click();
	}

}

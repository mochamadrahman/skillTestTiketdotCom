package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOptionPage {
	
	@FindBy(className = "facebook")
	WebElement btn_login_facebook;
	
	@FindBy(className = "google")
	WebElement btn_login_google;
	
	WebDriver driver;
	
	public LoginOptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkLogInFacebookButtonIsDisplayed() {
		btn_login_facebook.isDisplayed();
	}

	public void clickLoginFacebookButton() {
		btn_login_facebook.click();
	}
	
	public void checkLogInGoogleButtonIsDisplayed() {
		btn_login_google.isDisplayed();
	}

	public void clickLoginGoogleButton() {
		btn_login_google.click();
	}

}

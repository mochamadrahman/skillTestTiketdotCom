package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLoginPage {
	
	@FindBy(id = "identifierId")
	WebElement txt_email;
	
	@FindBy(className = "VfPpkd-RLmnJb") //VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc
	WebElement next1;
	
	@FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	WebElement txt_password;
	
	@FindBy(xpath = "//*[@id='passwordNext']/div/button/div[1]")
	WebElement next2;
	
	WebDriver driver;
	
	public GoogleLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void clickNextEmail() {
		next1.click();
	}
	
	public void typePassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickNextPassword() {
		next1.click();
	}
	
	

}

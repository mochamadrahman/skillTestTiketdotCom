package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPage {
	
	@FindBy(xpath = "//*[@id='filter-area']/div/div[1]/div/div[2]/button")
	WebElement buttonOK;
	

	@FindBy(xpath = "//*[@id='app']/div/div[4]/div/div[2]/div/div/div/div[2]/div[1]/a/div/div[1]/div[1]/p")
	WebElement orderIDMyOrderPage;
	
	@FindBy(xpath = "//*[@id='app']/div/div[4]/div/div[2]/div/div/div/div[2]/div[2]/a/div/div[1]/div[1]/p")
	WebElement seconListMyOrderPage;
	
	@FindBy(xpath = "//*[@class='navbar-brand']")
	WebElement backToProfilePage;
	
	WebDriver driver;

	public MyOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickButtonOK() {
		buttonOK.click();
	}
	
	public String orderIDTrainMyOrderPage() {
		return orderIDMyOrderPage.getText();
	}
	
	public String orderIDFlightMyOrderPage() {
		return orderIDMyOrderPage.getText();
	}
	
	public String secondListMyOrderPage() {
		return seconListMyOrderPage.getText();
	}
	
	public void backToProfilePage() {
		backToProfilePage.click();
	}

}

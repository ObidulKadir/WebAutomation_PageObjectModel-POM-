package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseDrivers.PageDriver;

public class LoginPage {
	public LoginPage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]"),
		@FindBy(xpath = "//input[@name=\"username\"]") })
	
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	public void login() throws InterruptedException	{
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginButton.click();
		Thread.sleep(3000);
	
	}
	
	

}

package pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.entity.MediaEntity;

import BaseDrivers.PageDriver;
import utility.ExcelUtilis;
import utility.GetScreenShot;

public class LoginPage {
	private ExtentTest test;
	
	ExcelUtilis excelData = new ExcelUtilis();

	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBys({
		@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]"),
		@FindBy(xpath = "//input[@name=\"username\"]") })
	
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName +".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void login() throws InterruptedException, IOException	{	
		excelData.ReadExcel();
		try {
			test.info("Please enter username");
			if(username.isDisplayed()) {
				username.sendKeys(excelData.username);
				passCase("Username entered");
			}
				try {
					test.info("Please enter password");
					if(password.isDisplayed()) {
						password.sendKeys(excelData.password);
						passCase("Password entered");
				} 
					try {
						test.info("Please click on the login button.");
							if(loginButton.isDisplayed()) {
								loginButton.click();
								Thread.sleep(3000);
								passCaseWithSC("Login Sucessfull", "loginPass");
						} 
					}
					catch (Exception e) {
						failCase("Login button was not locateable, pls check the error message.", "loginbuttonfail");
					}
						
				}
				catch (Exception e) {
					failCase("Password field was not locateable, pls check the error message.", "passowrdfail");
				}
			
			}
			catch (Exception e) {
				failCase("username field was not locateable, pls check the error message.", "usernamefail");
				
			}
	}

	private void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
	}

	private void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		
	}
	
	

}

package pages;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.BaseDriver;
import BaseDrivers.PageDriver;
import utility.GetScreenShot;

public class adminPage extends BaseDriver{
	
	private ExtentTest test;

	public adminPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBy(
		xpath = "//header/div[2]/nav[1]/ul[1]/li[2]/span[1]"
	)
	WebElement job;
	
	@FindBy(xpath ="//a[contains(text(),'Job Titles')]")
	WebElement jobTitle;
	
	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]") 
	WebElement addJobTitle;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement InputJobTitle;
	
	@FindBy(xpath="//textarea[@placeholder='Type description here']")
	WebElement jobDescriptions;
	
	@FindBy(xpath="//textarea[@placeholder='Add note']")
	WebElement note;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement submitBtn;
	
	// if case has been failed, this method will run and generate ss.
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
	// if case has been pass but wants ss with the action.
		private void passCaseWithSC(String message, String scName) throws IOException {
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			
		}
		
		// if only pass the cases then this method will run and generate a message.
		private void passCase(String message) {
			test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
			
		}
	
	public void adminInside() throws IOException {
		try {
			test.info("Click on the Job dropdown");
			if(job.isDisplayed()) {
				job.click();
				Thread.sleep(3000);
				passCase("Job Element successfully located.");
				
				try {
					test.info("Click on the Job title.");
					if (jobTitle.isDisplayed()) {
							jobTitle.click();
							Thread.sleep(3000);
							passCase("Successfully fetch the job title element");
						
						try {
							test.info("Click on the add button.");
							if(addJobTitle.isDisplayed()) {
									addJobTitle.click();
									Thread.sleep(3000);
									passCase("Clicked on the Add button");
								
								try {
									test.info("Fill up add job title.");
									
									if(InputJobTitle.isDisplayed()) {
											InputJobTitle.sendKeys("CfO");
											Thread.sleep(3000);
											passCase("Entered Job title");
											
											try {
												test.info("Fillup the Job descriptions.");
												if(jobDescriptions.isDisplayed()) {
														jobDescriptions.sendKeys("to manage the oragansation.");
														Thread.sleep(3000);
														passCase("Entered job descriptions.");
														
													try {
														test.info("Click on the Submit button");
														if(submitBtn.isDisplayed()) {
																submitBtn.click();
																Thread.sleep(10000);
																passCaseWithSC("create a job title", "createJobTitlepass");
															
														}
															
													} catch (Exception e) {
														failCase("Submit button unable to locate", "submitBtnFail");
														
													}
													
												}									
											} 
												catch (Exception e) {
												// TODO: handle exception
										}
											
											
											
											
									}		
								} catch (Exception e) {
									failCase("Unable to Add job title field  element", "JobTitlefieldFail");
								}
							}
						} catch (Exception e) {
							failCase("Unable to locate element", "addJobtitleFail");
						}
					}
					
				} catch (Exception e) {
					failCase("JobTitle element unable to locate.", "jobTitleFailCase");
				}
				
			}
		} catch (Exception e) {
			failCase("Job element unable to locate.", "jobFailCase");
		}
	}
	
	
	
	

}

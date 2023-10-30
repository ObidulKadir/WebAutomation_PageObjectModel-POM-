package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pages.adminPage;
import utility.ExtentFactory;

public class adminTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\\\"color:#FF6000; font-size:20px\\\"><b>ORANGE HRM Admin</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
	}
	
	@Test
	
	public void adminInnerTest() throws IOException {
		childTest = parentTest.createNode(("<p style=\"color:#FF6000; font-size:20px\"><b>Admin Inside element</b></p>"));
		adminPage adminIn = new adminPage(childTest);
		adminIn.adminInside();
		
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}

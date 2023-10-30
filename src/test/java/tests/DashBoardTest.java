package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseDrivers.BaseDriver;
import BaseDrivers.PageDriver;
import pages.DashBoard;
import utility.ExtentFactory;

public class DashBoardTest extends BaseDriver{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() {
//		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM DASHBOARD</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
	}
	
	@Test
	public void adminTest() throws InterruptedException, IOException {
		childTest = parentTest.createNode(("<p style=\"color:#FF6000; font-size:20px\"><b>Admin</b></p>"));
		DashBoard DashBordTest = new DashBoard(childTest);
		DashBordTest.admin();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}

package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseDrivers.BaseDriver;
import BaseDrivers.PageDriver;
import pages.LoginPage;

public class LoginTest extends BaseDriver{
	
	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
//		System.out.println("beforeclass");
		Thread.sleep(3000);
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
//		System.out.println("login class");
		loginPage.login();
	}

}

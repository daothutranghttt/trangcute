package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.LoginPage;


public class NewTest {
	WebDriver driver;
	LoginPage loginPage;
	

	@Test 
	public void Test2() {
		loginPage = new LoginPage(driver);
		loginPage.login("incorrectUser", "Password123");
		String errorLoginPage = loginPage.getError();
		Assert.assertEquals(errorLoginPage.toLowerCase(), "Your username is invalid!", "Fail!!");
	}
	@Test 
	public void Test3() {
		loginPage = new LoginPage(driver);
		loginPage.login("student", "incorrectPassword");
		String errorLoginPage = loginPage.getError().toLowerCase();
		Assert.assertEquals(errorLoginPage, "Your password is invalid!", "Fail!!");
	}
	@Test
	public void Test4() {
		loginPage = new LoginPage(driver);
		loginPage.login("student", "Password123");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url.toLowerCase(), "https://practicetestautomation.com/logged-in-successfully/", "Fail!!");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}


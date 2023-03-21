package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By txtUserName = By.id("username");
	By txtPassword = By.id("password");
	By btnSubmitLogin = By.id("submit");
	By txterror = By.id("error");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		driver.findElement(txtUserName).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnSubmitLogin).click();
	}
	
	public String getError() {
		WebElement element = driver.findElement(txterror);
		return element.getText();
	}
	
}


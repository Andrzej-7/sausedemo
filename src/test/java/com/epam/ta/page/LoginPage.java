package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractPage
{
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);	private final String PAGE_URL = "https://www.saucedemo.com/";

	@FindBy(css = "#user-name")
	private WebElement inputLogin;

	@FindBy(css = "#password")
	private WebElement inputPassword;

	@FindBy(css = "#login-button")
	private WebElement buttonSubmit;

	@FindBy(css = "h3[data-test*='error']")
	private WebElement errorMessage;


	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
		return this;
	}


	public LoginPage loginWithEmptyCredentials(User user) {
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		inputLogin.clear();
		inputPassword.clear();
		buttonSubmit.click();
		logger.info("Login attempted with empty credentials");
		return this;
	}


	public LoginPage loginWithEmptyPasswordField(User user) {
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		inputPassword.clear();
		buttonSubmit.click();
		logger.info("Login attempted with empty password field");
		return this;
	}

	public MainPage loginWithCredentials(User user) {
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		buttonSubmit.click();
		logger.info("Login performed with username: " + user.getUsername());
		return new MainPage(driver);
	}


	public String getErrorMessage() {
		return errorMessage.getText();
	}


}

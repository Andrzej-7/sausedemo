package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public MainPage openPage() {
		driver.navigate().to(PAGE_URL);
		return this;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}

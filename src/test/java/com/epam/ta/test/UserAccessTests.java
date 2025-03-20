package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserAccessTests extends CommonConditions {

	@Test(description = "UC-1")
	public void testLoginWithEmptyCredentials() {
		User testUser = UserCreator.withCredentialsFromProperty();
		String errorMessage = new LoginPage(driver)
				.openPage()
				.loginWithEmptyCredentials(testUser)
				.getErrorMessage();

		assertThat(errorMessage)
				.as("Error message should be 'Epic sadface: Username is required'")
				.isEqualTo("Epic sadface: Username is required");
	}

	@Test(description = "UC-2")
	public void testLoginWithEmptyPasswordField() {
		User testUser = UserCreator.withCredentialsFromProperty();
		String errorMessage = new LoginPage(driver)
				.openPage()
				.loginWithEmptyPasswordField(testUser)
				.getErrorMessage();

		assertThat(errorMessage)
				.as("Error message should be 'Epic sadface: Password is required'")
				.isEqualTo("Epic sadface: Password is required");
	}

	@Test(description = "UC-3")
	public void testLoginWithValidCredentials() {
		String expectedTitle = "Swag Labs";
		User testUser = UserCreator.withCredentialsFromProperty();

		String actualTitle = new LoginPage(driver)
				.openPage()
				.loginWithCredentials(testUser)
				.getPageTitle();

		assertThat(actualTitle)
				.as("Dashboard title should be 'Swag Labs'")
				.isEqualTo(expectedTitle);
	}
}

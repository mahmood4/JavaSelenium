/**
 * 
 */
package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.ContactPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SignUpPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;


public class ContactPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;

	private SignUpPage signUpPage;

	private ContactPage contactPG;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		launchApp(browser); 
	}

	@Test(enabled = true,groups = {"Smoke","Sanity"},dataProvider = "Contact", dataProviderClass = DataProviders.class)
	public void contactTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("loginTest");
	//	indexPage= new IndexPage();
	//	indexPage= new IndexPage();

		Log.startTestCase("loginTest");

		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		contactPG=indexPage.contactPage();
		//signUpPage=loginPage.NewUserSignUp(hashMapValue.get("name"),hashMapValue.get("email"));

		Log.info("user is going to click on SignIn");
		//	loginPage=indexPage.clickOnSignIn();
		Log.info("user is going to click on SignIn");
		//	loginPage=indexPage.clickOnSignIn();

		//signUpPage=loginPage.NewUserSignUp(hashMapValue.get("name"),hashMapValue.get("email"));
		contactPG.contact(hashMapValue.get("name"),hashMapValue.get("email"),hashMapValue.get("subject"),hashMapValue.get("message"));

		String expectedURL="https://automationexercise.com/signup";
		Log.info("Verifying if user is able to login");
		//Assert.assertEquals(actualURL, expectedURL);
		Log.info("Register User is Sucess");
		Log.endTestCase("loginTest");
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}




}

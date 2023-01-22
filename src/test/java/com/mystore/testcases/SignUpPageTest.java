/**
 * 
 */
package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SignUpPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSInput;


import java.io.IOException;
import java.util.HashMap;


public class SignUpPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;


	private SignUpPage signUpPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		launchApp(browser); 
	}

	@Test(enabled = false,groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String name, String email) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		signUpPage=loginPage.NewUserSignUp(name,email);
		Log.info("Enter Username and Password for Registration");
		Log.info(name);
		Log.info(email);
		String actualURL=signUpPage.getCurrURL();
		System.out.println("   "+actualURL);
		String expectedURL="https://automationexercise.com/signup";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("loginTest");

	}

	@Test(enabled = true,groups = {"Smoke","Sanity"},dataProvider = "Register", dataProviderClass = DataProviders.class)
	public void reguserTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		signUpPage=loginPage.NewUserSignUp(hashMapValue.get("name"),hashMapValue.get("email"));
		Log.info("Enter Username and Password");
		String actualURL=signUpPage.getCurrURL();
		signUpPage.signup(hashMapValue.get("gender"),hashMapValue.get("password"),hashMapValue.get("fname"),hashMapValue.get("lname"),hashMapValue.get("address"),hashMapValue.get("state"),hashMapValue.get("city"),hashMapValue.get("zipcode"),hashMapValue.get("mobile_number"));
		//	System.out.println("   "+actualURL);

		String expectedURL="https://automationexercise.com/signup";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Register User is Sucess");
		Log.endTestCase("loginTest");
	}

	@Test(enabled = false,groups = {"Smoke","Sanity"},dataProvider = "Contact", dataProviderClass = DataProviders.class)
	public void contactTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("loginTest");

		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		signUpPage=loginPage.NewUserSignUp(hashMapValue.get("name"),hashMapValue.get("email"));

		Log.info("user is going to click on SignIn");
		//	loginPage=indexPage.clickOnSignIn();
		Log.info("user is going to click on SignIn");
		//	loginPage=indexPage.clickOnSignIn();

		//signUpPage=loginPage.NewUserSignUp(hashMapValue.get("name"),hashMapValue.get("email"));
		signUpPage.contact(hashMapValue.get("name"),hashMapValue.get("email"),hashMapValue.get("subject"),hashMapValue.get("message"));
		//Log.info("Enter Username and Password");
		//String actualURL=signUpPage.getCurrURL();
		//	signUpPage.signup(hashMapValue.get("gender"),hashMapValue.get("password"),hashMapValue.get("fname"),hashMapValue.get("lname"),hashMapValue.get("address"),hashMapValue.get("state"),hashMapValue.get("city"),hashMapValue.get("zipcode"),hashMapValue.get("mobile_number"));
		//	System.out.println("   "+actualURL);

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

/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import java.util.Random;

/**
 * @author Hitendra
 *  
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();


	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signInBtn;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement Nametxt;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement Emailtxt;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement signUpBtn;
	@FindBy(xpath="//input[@data-qa='login-email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	private WebElement password;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginUpBtn;

	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), loginUpBtn);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}


	public SignUpPage NewUserSignUp(String name, String email) throws Throwable {

		// create instance of Random class
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(1000);
		email = rand_int1+""+email;
		action.type(Nametxt,name);
		action.type(Emailtxt,email);

//		action.fluentWait(getDriver(), signUpBtn, 20);
		action.click(getDriver(), signUpBtn);

		return new SignUpPage();
	}



}







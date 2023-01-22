package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass {

	Action action= new Action();

	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signInBtn;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement Nametxt;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement Emailtxt;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement signUpBtn;

	@FindBy(xpath = "//input[@value='Mrs']")
	private WebElement GenderRadioBtn;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordtxt;

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement firstnametxt;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement lastnametxt;

	@FindBy(xpath = "//input[@id='address1']")
	private WebElement addresstxt;

	@FindBy(xpath = "//input[@id='state']")
	private WebElement statetxt;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement citytxt;

	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement zipcodetxt;

	@FindBy(xpath = "//input[@id='mobile_number']")
	private WebElement mobnumtxt;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	private WebElement CreateaccountBtn;



	@FindBy(xpath = "//a[@href='/delete_account']")
	private WebElement deletBtnlnk;

	@FindBy(xpath = "//*[contains(text(),'Continue')]")
	private WebElement ContBtnlnk;



	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;

	@FindBy(id="search_query_top")
	private WebElement searchProductBox;

	@FindBy(name="submit_search")
	private WebElement searchButton;


	@FindBy(xpath="//a[@href='/contact_us']")
	private WebElement ContactUs;

	@FindBy(xpath="//input[@name='name']")
	private WebElement nameXpath;

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailXpath;

	@FindBy(xpath="//input[@name='subject']")
	private WebElement subjectXpath;

	@FindBy(xpath="//textarea[@name='message']")
	private WebElement messageXpath;

	@FindBy(css = "input[type='file']")
	private WebElement uploadCssPath;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitXpath;


	public SignUpPage() {
		PageFactory.initElements(getDriver(), this);
	}


	public void signup(String lName,
							  String gender,
							  String password,
							  String fname,
							  String address1,
							  String city,
							  String state,
							  String zipcode,
							  String mobilePhone) throws Throwable {


		action.type(GenderRadioBtn, gender);
		action.type(passwordtxt, password);
		action.type(firstnametxt, fname);
		action.type(lastnametxt, lName);
		action.type(addresstxt,address1);
		action.type(statetxt,state);
		action.type(citytxt,city);
		//action.selectByVisibleText(stateName, state);

		action.type(zipcodetxt,zipcode);
	//	action.selectByVisibleText(countryName, country);
		action.type(mobnumtxt,mobilePhone);

		action.scrollByVisibilityOfElement(getDriver(),CreateaccountBtn);

		action.click(getDriver(),CreateaccountBtn);


		action.click(getDriver(),ContBtnlnk);

		action.click(getDriver(),deletBtnlnk);

		action.click(getDriver(),ContBtnlnk);

	}

	public void contact(String name,String email,String subject,String message)
	{
		action.click(getDriver(),ContactUs);
		action.type(nameXpath,name);
		action.type(emailXpath,email);
		action.type(subjectXpath,subject);
		action.type(messageXpath,message);

		action.uploadFile(getDriver(),uploadCssPath,"c:\\Users\\User\\Downloads\\76187.jpg");

		action.scrollByVisibilityOfElement(getDriver(),submitXpath);

		action.isAlertPresent(getDriver());




	}


	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signInBtn, 20);
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
 	}

	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		System.out.println("homePageURL    "+homePageURL);
		return homePageURL;
	}




}

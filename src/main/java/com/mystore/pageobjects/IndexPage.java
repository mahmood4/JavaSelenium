package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement signInBtn;

	@FindBy(xpath="//a[@href='/contact_us']")
	private WebElement ContactUs;


	@FindBy(xpath="//a[@href='/products']")
	private WebElement xpathProducts;


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

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
	//	action.fluentWait(getDriver(), signInBtn, 20);
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


	public ContactPage contactPage() throws Throwable {
//		action.type(searchProductBox, productName);
//		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), ContactUs);
		Thread.sleep(3000);
		return new ContactPage();
	}

	public ProductPage productPage() throws Throwable {
		action.click(getDriver(), xpathProducts);
		Thread.sleep(3000);
		return new ProductPage();
	}
	
	

}

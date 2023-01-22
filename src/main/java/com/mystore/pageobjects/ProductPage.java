/**
 * 
 */
package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Hitendra
 *
 */
public class ProductPage extends BaseClass {

	Action action= new Action();


	@FindBy(xpath="//a[@href='/product_details/1']")
	private WebElement nameXpath;

	@FindBy(xpath="(//a[@data-product-id='1'])[1]")
	private WebElement AddtoCartXpath;

	@FindBy(xpath="//div[@id='cartModal']//a[@href='/view_cart']")
	private WebElement ViewcartXpath;

	@FindBy(xpath="//textarea[@name='message']")
	private WebElement messageXpath;

    @FindBy(css = "input[type='file']")
	private WebElement uploadCssPath;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitXpath;

	public ProductPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void contact(String name,String email,String subject,String message)
	{
	//	action.click(getDriver(),ContactUs);
		action.type(nameXpath,name);
	//	action.type(emailXpath,email);
	//	action.type(subjectXpath,subject);
		action.type(messageXpath,message);

		action.uploadFile(getDriver(),uploadCssPath,"c:\\Users\\User\\Downloads\\76187.jpg");

		action.scrollByVisibilityOfElement(getDriver(),submitXpath);

		action.isAlertPresent(getDriver());


   //return this;

	}


}

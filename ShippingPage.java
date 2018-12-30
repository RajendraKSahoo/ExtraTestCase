package com.ibm.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ShippingPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}

//WebElement for link System
		@FindBy(xpath="//a[contains(text(),'System')]")
		WebElement systemEle;
	
//WebElement for link Shipping
		@FindBy(xpath="(//a[contains(text(),'Shipping')])[1]")
		WebElement shipEle;
		
//WebElement for link Shipping Pincode
		@FindBy(xpath="//a[contains(text(),'Shipping Pincode')]")
		WebElement spincodeEle;
			
//WebElement for button Action
		@FindBy(xpath="(//button[contains(text(), 'Action')])[1]")
		WebElement actionEle;
				
//WebElement for Edit
		@FindBy(xpath="//a[@title='Edit']")
		WebElement editEle;
		
//WebElement for field Pincode
		@FindBy(xpath="//input[@name='pincode']")
		WebElement pincodeEle;
				
//WebElement for icon Save
		@FindBy(xpath="//button[@title='Save']")
		WebElement saveEle;
		
//WebElement for Header text
		@FindBy(xpath="//div[@class='panel-title']")
		WebElement hmessageEle;
		
		public void clickOnLinkSystem()
		{
			systemEle.click();
		}
		
		public void clickOnLinkShipping()
		{
			shipEle.click();
		//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Shipping Pincode')]")));
		}
		
		public void clickOnLinkShippingPincode()
		{
			spincodeEle.click();
		}
		
		public void clickOnAction()
		{
			actionEle.click();
		}
		
		public void clickOnEdit()
		{
			editEle.click();
		}
		
		public void clearPincode()
		{
			pincodeEle.clear();
		}
		
		public void clickOnIconSave()
		{
			saveEle.click();
		}
		
		public void getHeaderMessage()
		{
			String header = hmessageEle.getText();
			if (header.contains("Edit Shipping Pincode"))
			{
			System.out.println("The validation on Edit Shipping Pincode page after clicking Save...");
			System.out.println("The header of this page: " +header);
			Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
			
		}
					
		public String validationOnMisingField()
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			String message = (String) js.executeScript("return document.getElementsByName('pincode')[0].validationMessage;");
			System.out.println("The validation on error message without entering data for field Pincode...");
			System.out.println("The error message as: " +message);
			return(message);
		}

}

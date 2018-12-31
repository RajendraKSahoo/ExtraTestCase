package com.ibm.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public OrderPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}

//WebElement for link System
		@FindBy(xpath="//a[contains(text(),'System')]")
		WebElement systemEle;
	
//WebElement for link Order Statuses
		@FindBy(xpath="//a[contains(text(),'Order Statuses')]")
		WebElement ordstatusEle;
		
//WebElement for button Action
		@FindBy(xpath="(//button[contains(text(), 'Action')])[1]")
		WebElement actionEle;
		
//WebElement for Edit
		@FindBy(xpath="//a[@title='Edit']")
		WebElement editEle;
		
//WebElement for field Order Status Name
		@FindBy(xpath="//input[@name='name']")
		WebElement ordstatusnameEle;
		
//WebElement for Header text
		@FindBy(xpath="//div[@class='panel-title']")
		WebElement hmessageEle;
	
//WebElement for icon Save
		@FindBy(xpath="//button[@title='Save']")
		WebElement saveEle;
		
//WebElement for link Home
		@FindBy(xpath="//a[contains(text(),'Home')]")
		WebElement homeEle;
		
		public void clickOnLinkHome()
		{
			homeEle.click();
		}
		
		public void clickOnLinkSystem()
		{
			systemEle.click();
		}
		
		public void clickOnLinkOrderStatus()
		{
			ordstatusEle.click();
		}
		
		public void clickOnAction()
		{
			actionEle.click();
		}
		
		public void clickOnEdit()
		{
			editEle.click();
		}
		
		public void clearOrderStatusName()
		{
			ordstatusnameEle.clear();
		}
		
		public void clickOnIconSave()
		{
			saveEle.click();
		}
		
		public void getHeaderMessage()
		{
			String header = hmessageEle.getText();
			if (header.contains("Edit Order Status"))
			{
			System.out.println("The validation on Edit Order Status page after clicking Save...");
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
			String message = (String) js.executeScript("return document.getElementsByName('name')[0].validationMessage;");
			System.out.println("The validation on error message without entering data for field Order Status Name...");
			System.out.println("The error message as: " +message);
			return(message);
		}
					
}

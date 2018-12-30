package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ReturnPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}

//WebElement for link System
		@FindBy(xpath="//a[contains(text(),'System')]")
		WebElement systemEle;
	
//WebElement for link Returns
		@FindBy(xpath="(//a[contains(text(),'Returns')])[2]")
		WebElement returnEle;
		
//WebElement for link Return Statuses
		@FindBy(xpath="//a[contains(text(),'Return Statuses')]")
		WebElement retstatusEle;
		
//WebElement for link Return Actions
		@FindBy(xpath="//a[contains(text(),'Return Actions')]")
		WebElement retactionEle;
	
//WebElement for button Action
		@FindBy(xpath="(//button[contains(text(), 'Action')])[1]")
		WebElement actionEle;
		
//WebElement for Edit
		@FindBy(xpath="//a[@title='Edit']")
		WebElement editEle;
		
//WebElement for field Return Status Name
		@FindBy(xpath="//input[@name='name']")
		WebElement retstatusnameEle;
		
//WebElement for Header text
		@FindBy(xpath="//div[@class='panel-title']")
		WebElement hmessageEle;
	
//WebElement for field Return Action Name
		@FindBy(xpath="//input[@name='name']")
		WebElement retactnameEle;
		
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
		
		public void clickOnLinkReturns()
		{
			returnEle.click();
		}
		
		public void clickOnLinkRetStatuses()
		{
			retstatusEle.click();
		}
		
		public void clickOnLinkRetActions()
		{
			retactionEle.click();
		}
		
		public void clickOnAction()
		{
			actionEle.click();
		}
		
		public void clickOnEdit()
		{
			editEle.click();
		}
		
		public void clearReturnStatus()
		{
			retstatusnameEle.clear();
		}
		
		public void enterReturnActionName(String returnactionname)
		{
			retactnameEle.clear();
			retactnameEle.sendKeys(returnactionname);
		}
		
		public void clickOnIconSave()
		{
			saveEle.click();
		}
		
		public void getHeaderMessage()
		{
			String header = hmessageEle.getText();
			if (header.contains("Edit Return Status"))
			{
			System.out.println("The validation on Edit Return Status page after clicking Save...");
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
			System.out.println("The validation on error message without entering data for field Return Status Name...");
			System.out.println("The error message as: " +message);
			return(message);
		}
					
		public void validationOnRecord() throws FileNotFoundException, IOException
		{
			Properties p = new Properties();
			p.load(new FileInputStream("./TestData/magentodata.properties"));
		
			String pagesource = driver.getPageSource();
			//System.out.println(pagesource);
			
			if(pagesource.contains(p.getProperty("returnactionname"))) {
				System.out.println("The presence of edited action name is confirmed!");
				Assert.assertTrue(true);
			}
			else {
				System.out.println("The action is not edited on the Return Actions List");
				Assert.fail();
			}
		}

}

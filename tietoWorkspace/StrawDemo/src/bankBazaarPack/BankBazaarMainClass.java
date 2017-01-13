package bankBazaarPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

public class BankBazaarMainClass
{
	public static WebElement myElementSelector;
	public static MainSpeaker speak;
	public static void run(WebDriver driver) throws InstantiationException, IOException, PropertyException, InterruptedException
	{
		RecognizerMain OFR = new RecognizerMain("bankbazaar");
		/*
		 * OFR stands for Object for Recognition*/
		
		speak = new MainSpeaker();
		speak.convertToSpeech(" welcome to bankbazaar dot com, you have following options to choose from, home loan,"
				+ "savings account, car insurance and mutual fund. ");
		speak.freeReference();
		
		String output = ConfirmationClass.isItConfirmed(OFR);
		
		selectWebElementSite(driver,output,OFR);
		
		/*Main crawler code ends over here*/
		
		OFR.stopRecordingMic();
		OFR.deallocateMemoryToRecognizer();
		OFR.freeReferences();
		OFR = null;
	}
	public static void selectWebElementSite(WebDriver driver, String option,RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
		/*In each of the case add getTitle of page command so that it waits for the sub-page to load up
		 * It will but you more time, ex- System.out.println(driver.getTitle());
		 * From here on we can start their own sub page Main Driver class like BankBazaarMainDriver
		 * to something like HomeLoanMainDriver etc.*/
			
		speak = new MainSpeaker();
		
		switch(option)
		{
		case "bank bazaar":
			driver.get("https://www.bankbazaar.com/");
			System.out.println("You clicked Bank bazaar");
			speak.convertToSpeech("You have successfully clicked BANK BAZAAR PAGE");
			speak.freeReference();
			BankBazaarMainClass.run(driver);
			break;
		case "car insurance":
			driver.findElement(By.xpath("//a[@title='Car Insurance']")).click();
			speak.convertToSpeech("You have successfully clicked CAR INSURANCE");
			speak.freeReference();
			CarInsurancePage.run(driver,OFR);
			break;
		case "home loan":
			driver.findElement(By.xpath("//a[@title='Home Loan']")).click();
			System.out.println("You clicked Home Loan");
			break;
		case "car loan":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Car Loan']"));
			System.out.println("You clicked Car Loan");
			myElementSelector.click();
			break;
		case "used car loan":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Used Car Loan']"));
			System.out.println("You clicked Used Car Loan");
			myElementSelector.click();
			break;
		case "personal loan":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Personal Loan']"));
			System.out.println("You clicked Personal Loan");
			myElementSelector.click();
			break;
		case "credit card":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Credit Card']"));
			System.out.println("You clicked Credit Card");
			myElementSelector.click();
			break;
		case "debit card":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Debit Card']"));
			System.out.println("You clicked Debit Card");
			myElementSelector.click();
			break;
		case "savings account":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Savings Account']"));
			System.out.println("You clicked Savings Account");
			myElementSelector.click();
			break;
		case "life insurance":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Life Insurance']"));
			System.out.println("You clicked Life Insurance");
			myElementSelector.click();
			break;
		case "health insurance":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Health Insurance']"));
			System.out.println("You clicked Health Insurance");
			myElementSelector.click();
			break;
		case "fixed deposit":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Fixed Deposit']"));
			System.out.println("You clicked Fixed Deposit");
			myElementSelector.click();
			break;
		case "mutual fund":
			myElementSelector = driver.findElement(By.xpath("//a[@title='Mutual Fund']"));
			System.out.println("You clicked Mutual Fund");
			myElementSelector.click();
			break;
		case "terminate program":
			break;
		default:
			System.out.println("Wrong");
			break;
		}
	}
}

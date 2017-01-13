package bankBazaarPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

public class CarInsurancePage
{
	public static WebElement myElementSelector;
	public static MainSpeaker speak;
	public static void run(WebDriver driver, RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{	
		speak = new MainSpeaker();
		speak.convertToSpeech("Welcome to car insurance quick search page, you have following options to choose from, "
				+ "Bank bazaar and Check your eligibility");
		speak.freeReference();
		
		String output = ConfirmationClass.isItConfirmed(OFR);
		
		selectWebElementSite(driver,output,OFR);
	}
	public static void selectWebElementSite(WebDriver driver,String option, RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
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
		case "check your eligibility":
			driver.findElement(By.xpath("//div[@class='btn btn-danger']")).click();
			System.out.println("You clicked Check my Eligibility");
			speak.convertToSpeech("You have successfully clicked CHECK MY ELIGIBILITY");
			speak.freeReference();
			BuyOrRenewCarInsurancePage.run(driver, OFR);
			break;
		case "terminate program":
			break;
		default:
			System.out.println("Dude you said something wrong?");
			break;
		}
	}
}
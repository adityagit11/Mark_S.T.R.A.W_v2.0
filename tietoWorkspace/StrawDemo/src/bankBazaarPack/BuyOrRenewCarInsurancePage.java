package bankBazaarPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

public class BuyOrRenewCarInsurancePage
{
	public static WebElement myElementSelector;
	public static MainSpeaker speak;
	public static void run(WebDriver driver, RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
		speak = new MainSpeaker();
		speak.convertToSpeech("Welcome to buy or renew car insurance page,Do you want to renew existing car insurance or new car insurance");
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
			break;
		case "car insurance":
			System.out.println("You clicked Car Insurance");
			speak.convertToSpeech("You have successfully clicked car insurance PAGE");
			speak.freeReference();
			CarInsurancePage.run(driver, OFR);
			break;
		case "renew car insurance":
			System.out.println("You clicked Renew Car Insurance");
			driver.findElement(By.xpath("//span[@class='sprite-car-status renewexiscar_insurs']")).click();
			speak.convertToSpeech("You have successfully clicked RENEW CAR INSURANCE PAGE");
			speak.freeReference();
			break;
		case "new car insurance":
			System.out.println("You clicked New Car Insurance");
			driver.findElement(By.xpath("//span[@class='sprite-car-status newcar_insurs']")).click();
			speak.convertToSpeech("You have successfully clicked NEW CAR INSURANCE PAGE");
			speak.freeReference();
			NewCarInsurancePage.run(driver, OFR);
			break;
		case "terminate program":
			break;
		default:
			System.out.println("Dude you said something wrong?");
			break;
		}
	}
}

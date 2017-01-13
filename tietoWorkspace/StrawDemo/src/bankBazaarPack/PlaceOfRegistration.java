package bankBazaarPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

public class PlaceOfRegistration
{
	public static WebElement myElementSelector;
	public static MainSpeaker speak;
	public static void run(WebDriver driver, RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
		speak = new MainSpeaker();
		speak.convertToSpeech("Successfully done, Enter place of registeration!, Say Place of registration");
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
		case "place of registration":
			driver.findElement(By.xpath("//input[@id='eForm_carRegistration_number']")).sendKeys("MH01 - MUMBAI TARDEO");
			driver.findElement(By.xpath("//input[@id='eForm_carRegistration_number']")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='eForm_submit_button']")).click();
			speak.convertToSpeech("MH01 - MUMBAI TARDEO");
			speak.freeReference();
			break;
		case "terminate program":
			break;
		default:
			System.out.println("Dude you said something wrong?");
			break;
		}
	}
}

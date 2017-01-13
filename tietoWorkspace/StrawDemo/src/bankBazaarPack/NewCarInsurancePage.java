package bankBazaarPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

public class NewCarInsurancePage
{
	public static WebElement myElementSelector;
	public static MainSpeaker speak;
	public static void run(WebDriver driver, RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
		speak = new MainSpeaker();
		speak.convertToSpeech("What car do you drive? Hyundai eon or Maruti Wagon R");
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
		case "maruti wagon r":
			System.out.println("You clicked Renew Car Insurance");
			driver.findElement(By.xpath("//span[@class='sprite-preferred-car MARUTI-SUZUKI-WAGON-R_round']")).click();
			speak.convertToSpeech("You have successfully clicked MARUTI WAGON ARE PAGE");
			speak.freeReference();
			MarutiWagonRPage.run(driver, OFR);
			break;
		case "hyundai eon":
			System.out.println("You clicked New Car Insurance");
			driver.findElement(By.xpath("//span[@class='sprite-preferred-car HYUNDAI-EON_round']")).click();
			speak.convertToSpeech("You have successfully clicked HYUNDAI PAGE PAGE");
			speak.freeReference();
			HyundaiEonPage.run(driver, OFR);
			break;
		case "terminate program":
			break;
		default:
			System.out.println("Dude you said something wrong?");
			break;
		}
	}
}

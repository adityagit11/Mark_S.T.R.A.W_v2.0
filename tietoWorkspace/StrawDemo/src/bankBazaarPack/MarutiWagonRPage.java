package bankBazaarPack;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

public class MarutiWagonRPage
{
	public static WebElement myElementSelector;
	public static MainSpeaker speak;
	public static void run(WebDriver driver, RecognizerMain OFR) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
		speak = new MainSpeaker();
		speak.convertToSpeech("What type of fuel does your car run on? You have options petrol, petrol and el pi Gi, "
				+ "petrol and ci en gi ?");
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
		case "petrol":
			driver.findElement(By.xpath("//span[@class='sprite-fuel fuel-petrol']")).click();
			speak.convertToSpeech("You have successfully clicked PETROL");
			speak.freeReference();
			System.out.println("You Clicked Petrol");
			petrolWPage.run(driver,OFR);
			break;
		case "terminate program":
			break;
		default:
			System.out.println("Dude you said something wrong?");
			break;
		}
	}
}

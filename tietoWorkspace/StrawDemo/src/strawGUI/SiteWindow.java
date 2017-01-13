package strawGUI;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import bankBazaarPack.BankBazaarMainClass;
import bankBazaarPack.BankBazaarMainClass;
import javafx.stage.Stage;
import ttsSpeakPack.MainSpeaker;

public class SiteWindow
{
	public static void siteWindowSelect(String siteName)
	{
		MainSpeaker speak = new MainSpeaker();
		speak.convertToSpeech("Initiating the recognition procedure");
		
		speak.convertToSpeech("You have selected "+siteName+", Please Wait for program to load.");
		
		System.setProperty("webdriver.gecko.driver", "D:\\tieto\\SeleniumUtil\\GeckoDriverFile\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//opens site recognition
		
		if(siteName.equalsIgnoreCase("bankbazaar")||siteName.equalsIgnoreCase("bank bazaar")||siteName.equalsIgnoreCase("bankbazaar.com"))
		{
			//call bank bazaar
			
			System.out.println("Loading bankbazaar.com");
			
			driver.get("https://www.bankbazaar.com/");
			//now let's control bank bazaar site first
			
			try {
				BankBazaarMainClass.run(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(siteName.equalsIgnoreCase("policybazaar")||siteName.equalsIgnoreCase("policy bazaar")||siteName.equalsIgnoreCase("policybazaar.com"))
		{
			//call policy bazaar
			
			System.out.println("You have selected Policy Bazaar at policybazaar.com");
			
			driver.get("https://www.policybazaar.com/");
			
			//now let's control policy bazaar site first
		}
		else if(siteName.equalsIgnoreCase("icicilombard")||siteName.equalsIgnoreCase("icici lombard")||siteName.equalsIgnoreCase("icicilombard.com"))
		{
			//call icici lombard
			
			System.out.println("You have selected Bank Bazaar at icicilombard.com");
			
			driver.get("https://www.icicilombard.com/");
			
			//now let's control icici lombard site first
		}
		else if(siteName.equalsIgnoreCase("generalbajajallianz")||siteName.equalsIgnoreCase("general bajaj allianz")||siteName.equalsIgnoreCase("general.bajajallianz.com"))
		{
			//call general bajaj allianz
			
			System.out.println("You have selected General Bajaj Allianz at general.bajajallianz.com");
			
			driver.get("https://general.bajajallianz.com");
			
			//now let's control general bajaj allianz site first
		}
		else if(siteName.equalsIgnoreCase("tataaigmotorinsurance")||siteName.equalsIgnoreCase("tata aig motor insurance")||siteName.equalsIgnoreCase("tataaigmotorinsurance.in"))
		{
			//call tata aig motor insurance
			
			System.out.println("You have selected Tata Aig Motor Insurance at tataaigmotorinsurance.com");
			
			driver.get("http://www.tataaigmotorinsurance.in/");
			
			//now let's control tata aig motor insurance site first
		}
		else if(siteName.equalsIgnoreCase("travelguardworldwide")||siteName.equalsIgnoreCase("Travel Guard Worldwide")||siteName.equalsIgnoreCase("travelguardworlwide.com"))
		{
			//call Travel Guard World Wide
			
			System.out.println("You have selected Travel Guard World Wide Insurance at travelguardworldwide.com");
			
			driver.get("http://travelguardworldwide.com/home");
			
			//now let's control Travel Guard World Wide insurance site first
		}
		else if(siteName.equalsIgnoreCase("pohjola")||siteName.equalsIgnoreCase("pohjola")||siteName.equalsIgnoreCase("pohjola.fi"))
		{
			//call Pohjola
			
			System.out.println("You have selected Pohjola Insurance at pohjola.fi");
			
			driver.get("https://pohjola.fi/");
			
			//now let's control Pohjola insurance site first
		}
		else if(siteName.equalsIgnoreCase("pacificprime")||siteName.equalsIgnoreCase("pracific prime")||siteName.equalsIgnoreCase("pacificprime.com"))
		{
			//call Pohjola
			
			System.out.println("You have selected Pacific Prime Insurance at pacificprime.com");
			
			driver.get("https://www.pacificprime.com/country/europe/finland-health-insurance-pacific-prime-international/");
			
			//now let's control Pohjola insurance site first
		}
	}
	public static void destroy(Stage window)
	{
		window.close();
		window = null;
	}
}

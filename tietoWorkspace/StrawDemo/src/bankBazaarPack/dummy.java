package bankBazaarPack;

import java.io.IOException;

import StrawPack.RecognizerMain;
import edu.cmu.sphinx.util.props.PropertyException;

public class dummy
{
	public static void main(String args[]) throws InterruptedException, InstantiationException, IOException, PropertyException
	{
		RecognizerMain OFR = new RecognizerMain("bankbazaar");
		/*
		 * OFR stands for Object for Recognition*/
		String output = ConfirmationClass.isItConfirmed(OFR);
		
		System.out.println(output);
		//selectWebElementSite(driver,output,OFR);
		
		/*Main crawler code ends over here*/
		
		OFR.stopRecordingMic();
		OFR.deallocateMemoryToRecognizer();
		OFR.freeReferences();
		OFR = null;
	}
}

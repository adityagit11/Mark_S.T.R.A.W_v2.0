package bankBazaarPack;

import StrawPack.RecognizerMain;

public class ConfirmationClass
{
	public static String isItConfirmed(RecognizerMain OFR) throws InterruptedException
	{
		OFR.startRecognition();
		String value = OFR.getRecognizedString();
		if(OFR.confirmationCall(value))
			return value;
		else
			return isItConfirmed(OFR);
	}
}

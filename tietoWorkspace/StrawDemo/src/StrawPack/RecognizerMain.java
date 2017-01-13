package StrawPack;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import ttsSpeakPack.MainSpeaker;

import java.io.IOException;
import java.net.URL;

import com.sun.speech.freetts.en.us.FeatureProcessors.SylOut;

public class RecognizerMain
{
	public String configName;
	public URL url;
	public ConfigurationManager cm;
	public Recognizer recog;
	public Microphone mic;
	public String resultText;
	
	
	
	
	public RecognizerMain(String s) throws InstantiationException, IOException, PropertyException
	{
		setConfigName(s);
		System.out.println("You are in site: "+this.getConfigName());
		setURL();
		System.out.println("Loading Site Recognition Block");
		setConfigurationManager();
		setRecognizer();
		setMicrophone();
		allocateMemoryToRecognizer();
	}
	
	
	
	
	//step 1: 
	//setting up the configuration file inside which the grammar file resides
	public void setConfigName(String s)
	{
		configName = s+".xml";
	}
	public String getConfigName()
	{
		return configName;
	}
	
	
	
	
	//step 2:
	//setting up the url neural network
	public void setURL()
	{
		url = RecognizerMain.class.getResource(getConfigName());
	}
	public  URL getURL()
	{
		return url;
	}	
	
	
	
	
	//step 3: setting up configuration driver
	public  void setConfigurationManager() throws IOException, PropertyException, InstantiationException
	{
		System.out.println("Setting up configuration manager");
		cm = new ConfigurationManager(getURL());
	}
	public  ConfigurationManager getConfigurationManager()
	{
		return cm;
	}
	
	
	
	
	//step 4: setting up recognizer
	public  void setRecognizer() throws InstantiationException, PropertyException
	{
		System.out.println("Setting up recognizer");
		recog = (Recognizer) getConfigurationManager().lookup("recognizer");
	}
	public  Recognizer getRecognizer()
	{
		return recog;
	}
	
	
	
	
	//step 5: setting up microphone
	public  void setMicrophone() throws InstantiationException, PropertyException
	{
		System.out.println("Setting up microphone");
		mic = (Microphone) getConfigurationManager().lookup("microphone");
	}
	public  Microphone getMicrophone()
	{
		return mic;
	}
	public void stopRecordingMic()
	{
		mic.stopRecording();
	}

	
	
	
	//step 6: Allocation memory to recognizer
	//call to this method should only be made in the case of deallocated state
	public  void allocateMemoryToRecognizer() throws IllegalStateException, IOException
	{
        /* allocate the resource necessary for the recognizer */
		getRecognizer().allocate();
	}
	//call to this method should only be made in the allocated state
	public void deallocateMemoryToRecognizer()
	{
		getRecognizer().deallocate();
	}
	
	
	
	
	//step 7: Main Recognition Block
	//1st method you should call for recognizition
	public void startRecognition() throws InterruptedException
	{
		MainSpeaker speak = new MainSpeaker();
		speak.convertToSpeech("Kindly Speak A Nnnuuu Command!");
		
		mic.clear();
		
		mic.startRecording();
		
		Result result = recog.recognize();
		
		resultText = result.getBestFinalResultNoFiller();
		
		System.out.println("You said "+resultText);
		
		mic.stopRecording();
	}
	public Boolean confirmationCall(String value)
	{
		MainSpeaker speak = new MainSpeaker();
		speak.convertToSpeech("Do you confirm? "+value);
		
		mic.clear();
		
		mic.startRecording();
		
		Result result = recog.recognize();
		
		String confirmation = result.getBestFinalResultNoFiller();
		
		System.out.println("You confirmation? "+confirmation);
		
		if(confirmation.equalsIgnoreCase("yes please confirm"))
			return true;
		else if(confirmation.equalsIgnoreCase("not confirmed"))
			return false;
		return false;
	}
	
	
	//redundant method 2: return the string recognized
	public  String getRecognizedString()
	{
		return resultText;
	}
	
	
	
	public void freeReferences()
	{
		cm = null;
		mic = null;
		recog = null;
	}
	
	/*
	public  void startRecognition() throws IllegalStateException, IOException
	{
		if(mic.startRecording())
		{
			while(true)
			{
				resultText = "";
				System.out.println("Start speaking. Press Ctrl-C to quit.\n");
				Result result = recog.recognize();
				if(result!=null)
				{
					resultText = result.getBestFinalResultNoFiller();
					System.out.println(resultText);
				}
				else
				{
					System.out.println("I can't hear what you said.\n");
				}
			}
		}
		else 
	    {
			System.out.println("Cannot start microphone.");
	    }
		//memory allocated to the recognizer must always be de-allocated
		mic.stopRecording();
		deallocateMemoryToRecognizer();
	}
	*/
	
	//this below method startRecognition () is back - up
	/*
	public  void startRecognition() throws IllegalStateException, IOException
	{
		allocateMemoryToRecognizer();
		if(mic.startRecording())
		{
			resultText = "";
			while(resultText.equals("stop")!=true)
			{
				System.out.println("Start speaking. Press Ctrl-C to quit.\n");
				Result result = recog.recognize();
				if(result!=null)
				{
					resultText = result.getBestFinalResultNoFiller();
					System.out.println(resultText);
				}
				else
				{
					System.out.println("I can't hear what you said.\n");
				}
			}
			
		}
		else 
	    {
			System.out.println("Cannot start microphone.");
	    }
		//memory allocated to the recognizer must always be de-allocated
		mic.stopRecording();
		deallocateMemoryToRecognizer();
	}
	*/
}

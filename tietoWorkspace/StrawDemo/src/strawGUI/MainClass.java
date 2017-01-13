package strawGUI;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ttsSpeakPack.MainSpeaker;

public class MainClass
{
	public  static Stage recogWindow;
	public static void SelectSiteWindow()
	{
		recogWindow = new Stage();
		recogWindow.setTitle("Recognition View");
		
		Label enterSiteLabel = new Label();
		enterSiteLabel.setText("Enter Site");
		
		TextField siteNameInput = new TextField();
		siteNameInput.setPromptText("Enter the site Name");
		
		HBox siteNameLayout = new HBox(20);
		siteNameLayout.getChildren().addAll(enterSiteLabel,siteNameInput);
		siteNameLayout.setAlignment(Pos.CENTER);
		
		Button submitButton = new Button("Initiate!");
		submitButton.setOnAction(e -> {
			recogWindow.setIconified(true);
			siteSelector(siteNameInput.getText());
		});
		
		VBox siteNameSelectorLayout = new VBox(30);
		siteNameSelectorLayout.getChildren().addAll(siteNameLayout,submitButton);
		siteNameSelectorLayout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(siteNameSelectorLayout,600,200);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent t) {
	            KeyCode key = t.getCode();
	            if (key == KeyCode.ESCAPE){
	            	Boolean answer = ConfirmationBox.display();
	    			if(answer)
	    				destroy(recogWindow);
	            }
	        }
	    });
		
		recogWindow.setScene(scene);
		
		recogWindow.initStyle(StageStyle.TRANSPARENT);
		
		recogWindow.show();
		
		recogWindow.setOnCloseRequest(e -> {
			Boolean answer = ConfirmationBox.display();
			if(answer)
				destroy(recogWindow);
		});
	}
	public static void siteSelector(String siteName)
	{
		SiteWindow.siteWindowSelect(siteName);
		/*close the window when you say terminate program*/
		recogWindow.close();
	}
	public static void destroy(Stage window)
	{
		window.close();
		window = null;
	}
}

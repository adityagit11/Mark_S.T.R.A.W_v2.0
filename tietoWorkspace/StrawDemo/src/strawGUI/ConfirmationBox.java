package strawGUI;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ttsSpeakPack.MainSpeaker;

public class ConfirmationBox
{
	private static boolean answer;
	
	public static boolean display()
	{
		Stage confirmWindow = new Stage();
		
		Label confirmationLabel = new Label();
		confirmationLabel.setText("Sure You Want To Exit?");
		
		Button yesButton = new Button();
		yesButton.setText("Yes");
		yesButton.setOnAction(e -> {
			answer = true;
			confirmWindow.close();
		});
		
		Button noButton = new Button();
		noButton.setText("No");
		noButton.setOnAction(e -> {
			answer = false;
			confirmWindow.close();
		});
		
		HBox optionBoxLayout = new HBox(50);
		optionBoxLayout.getChildren().addAll(yesButton,noButton);
		optionBoxLayout.setAlignment(Pos.CENTER);
		
		VBox finalLayout = new VBox(50);
		finalLayout.getChildren().addAll(confirmationLabel,optionBoxLayout);
		finalLayout.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(finalLayout,200,200);
		
		confirmWindow.initModality(Modality.APPLICATION_MODAL);
		
		confirmWindow.setScene(myScene);
		
		confirmWindow.showAndWait();
		
		return answer;
	}
}

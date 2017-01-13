package strawGUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
	public static void display(String title, String message)
	{
		Stage window = new Stage();
		
		/*
		 * You see alert boxes don't work like normal windows or stages
		 * When you try to click the background of the alert window, you can't because you need to take care of current window
		 * So we will add that functionality in our alert box*/
		
		Label alertText = new Label();
		alertText.setText(message);
		
		Button cloneButton = new Button("Close");
		cloneButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(40);
		layout.getChildren().addAll(alertText,cloneButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene myScene = new Scene(layout,200,200);
		
		/*
		 * What this below statement is going to do, is basically block all of the user interaction with other windows untill alert window is take care of!*/
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setScene(myScene);
		
		window.setTitle(title);
		
		/*Shows this stage and waits for it to be hidden (close) before returning to the caller.
		 * This method temporarily blocks processing of the current event, and starts a nested
		 * event loop to handle other events. This method must be called on the FX application thread.*/
		window.showAndWait();
		
	}
}

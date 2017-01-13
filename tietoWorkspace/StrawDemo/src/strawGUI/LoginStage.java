package strawGUI;

import java.io.File;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginStage extends Application
{
	Stage window;
	private String user = "ADITYA";
	private String pass = "S.T.R.A.W";
	
	public static void main(String args[])
	{
		launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Log In Stage");
		
		Label userNameLabel = new Label();
		userNameLabel.setText("Enter Username");
		
		TextField userNameInput = new TextField();
		userNameInput.setPromptText("S.T.R.A.W user");
		
		VBox userNameLayout = new VBox(10);
		userNameLayout.getChildren().addAll(userNameLabel,userNameInput);
		
		Label passwordLabel = new Label();
		passwordLabel.setText("Enter Password");
		
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("password");
		
		VBox passwordLayout = new VBox(10);
		passwordLayout.getChildren().addAll(passwordLabel,passwordInput);
		
		VBox inputLayout = new VBox(10);
		inputLayout.getChildren().addAll(userNameLayout, passwordLabel);
		
		Button submitButton = new Button("Submit!");
		submitButton.setOnAction(e -> submitButton(userNameInput.getText(),passwordInput.getText()));
		
		StackPane pane = new StackPane();
		pane.getChildren().add(submitButton);
		pane.setAlignment(Pos.CENTER);
        
		VBox finalLayout = new VBox(20);
		finalLayout.getChildren().addAll(userNameLayout,passwordLayout,pane);
	    finalLayout.setPadding(new Insets(70, 50, 50, 50));
	    finalLayout.setSpacing(20);
		
		Scene loginScene = new Scene(finalLayout,600,400);
		loginScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent t) {
	            KeyCode key = t.getCode();
	            if (key == KeyCode.ESCAPE){
	            	Boolean answer = ConfirmationBox.display();
	    			if(answer)
	    				destroy(window);
	            }
	        }
	    });
		
		window.setScene(loginScene);
		
		window.initStyle(StageStyle.TRANSPARENT);
		
		window.show();
	}
	public void submitButton(String username, String password)
	{
		if(username.length()==0&&password.length()==0)
		{
			AlertBox.display("Empty Fields","Please Enter username and password");
		}
		else if(username.length()==0)
		{
			AlertBox.display("Empty Username", "Please Enter username");
		}
		else if(password.length()==0)
		{
			AlertBox.display("Empty password", "Please enter password");
		}
		else if(username.equalsIgnoreCase(user)!=true&&password.equalsIgnoreCase(pass)!=true)
		{
			AlertBox.display("Error!", "Wrong Password, Please try again");
		}
		else
		{
			//call MainClass
			
			MainClass.SelectSiteWindow();
			window.close();
			
		}
	}
	public void destroy(Stage window)
	{
		window.close();
		window = null;
	}
}

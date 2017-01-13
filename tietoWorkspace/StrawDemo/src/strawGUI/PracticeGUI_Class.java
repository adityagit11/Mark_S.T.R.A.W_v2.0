package strawGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeGUI_Class extends Application
{
	Stage window;
	public static void main(String args[])
	{
		/*
		 * launch() is the first method here which gets executed Whenever we start this PracticeGUI_Class program
		 * it will call launch() method which will setup our program as Java FX application
		 * Now what this application class will do is call a method call start()
		 * Now start () is actually overwritten in our program*/
		launch();
	}
	@Override 
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		//first Tutorial
		/*
		 * Terminologies:
		 * Stage: The entire window is called a stage, like all those max, min and close buttons (all of the window)
		 * primaryStage: It is our main window
		 * Scene: Now the content inside the window is called a scene where we put up all our widgets, like pages of a website
		 * layout: It is essentially how you wanna arrange everything on your screen, like StackPane*/
		Button btn = new Button();
		btn.setText("Wolvie");
		
		/*
		 * Event Handling can be done by two ways:
		 * First way is to implement interface EventHandler (Bucky's 2nd tutorial)
		 * Second way as shown below by using lambda expressions
		 * Third way is to use anonymous inner class
		 * BEST WAY : LAMBDA EXPRESSION : Just use 2nd way i.e. calling setOnAction() method on button object with L.E as parameter
		 * 								: But the problem with this method is L.E was introduced in Java 8 version*/
		btn.setOnAction(e -> print());
		

		StackPane layout = new StackPane();
		layout.getChildren().addAll(btn);
		
		/*Setting the scene size, essentially set the size of the entire window*/
		Scene scene = new Scene(layout, 800, 400);
		
		//second Tutorial
		/*
		 * Switch Scene!: A scene is a specific view of a window as a particular instant, it is like a page of a window
		 * We will make temp stage window, 2 button object, a label and 2 scenes
		 * LABEL: Labels are static texts (widget), a little chunk of text which can't be interacted by the user*/
		Label label1 = new Label("This is static, non-interactive");
		Button btn1 = new Button("Go to scene 2");
		VBox layout1 = new VBox(20); //space 20 pixel between vertical widgets
		layout1.getChildren().addAll(label1,btn1);
		Scene scene1 = new Scene(layout1,200,200);
		Button btn2 = new Button("Go back to scene 1");
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(btn2);
		Scene scene2 = new Scene(layout2,400,600);
		btn1.setOnAction(e -> primaryStage.setScene(scene2));
		btn2.setOnAction(e -> primaryStage.setScene(scene1));
		//primaryStage.setScene(scene1); - basically saying that scene1 is default / main scene
		
		
		
		//third Tutorial
		/*
		 * Popup Windows / Alert Windows / Multiple windows at same time: 
		 * Using scene from first Tutorial*/
		btn.setOnAction(e -> AlertBox.display("Warning!", "Wrong Password"));
		
		
		
		/*
		 * Communicating between windows:
		 * Suppose you popped up a window like alert box and set some action over there,
		 * We need a way to return that action data back to the program
		 * Like in our straw poject, when the user enters his username and password and click on submit.
		 * Now we have two paths, either a wrong password alert window opens or a new window opens where all our data of STRAW is! (recognition)*/
		//study this tutorial
		
		
		/*
		 * Closing and saving the program properly:
		 * Whenever you are making an actual application, most of the time you wanna run a smalla chunk of code
		 * before the user closes out. Like if you are making a game, you might wanna save the current position
		 * or level. So how about the user clicks a button, and then we can hop to some method and saves a chunk
		 * of code and closes out. This chunk of code let's say is in closeProgram() function
		 * But now suppose user clicks the close button on top that means they just bypasses our closeProgram() method
		 * What we can do is actually on this window we can call a method setOnCloseRequest() method
		 * So we saw two ways in which when a user clicks the close button we can call a method*/
		//btn.setOnAction(e -> closeProgram(primaryStage));     -->>> This method is replaced with setOnCloseRequest()
		//primaryStage.setOnCloseRequest(e -> closeProgram(primaryStage));
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("My First Window");
		primaryStage.show();
	}
	public void print()
	{
		System.out.println("OOOooooooo I love it when you touch me there......");
	}
}

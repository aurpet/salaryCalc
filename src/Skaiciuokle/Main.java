package Skaiciuokle;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application  {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        Calculator login = new Calculator(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
package Skaiciuokle;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator {
    private BorderPane bpRoot;
    private Stage primaryStage;

    Calculator(Stage primaryStage) {

        this.primaryStage = primaryStage;

        addElementsToScene();

        primaryStage.show();

    }
    private void addElementsToScene (){
        primaryStage.setTitle("Atlyginimo skaičiuoklė");
        this.bpRoot = new BorderPane();
        Scene scene = new Scene(this.bpRoot,480,300);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.getIcons().add(new Image("file:///C:/Users/Aurimas/IdeaProjects/AtlyginimoSkaiciuokle/src/Img/logo.png"));


        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();



        Button onHand = new Button("Atlyginimas į rankas");
        onHand.setMinWidth(150);
        onHand.setAlignment(Pos.CENTER);
        onHand.setOnAction((ActionEvent e)->{
            AfterTaxes afterTaxes = new AfterTaxes(this.primaryStage);
        });




        Button onPaper = new Button("Atlyginimas popieriuje");
        onPaper.setMinWidth(150);
        onPaper.setAlignment(Pos.CENTER);



        HBox hbLoginText = new HBox();
        hbLoginText.setPadding(new Insets(30,10,20,10));
        hbLoginText.setAlignment(Pos.CENTER);
        Text text = new Text("Pasirinkite atlyginimo skaičiuoklę:");
        hbLoginText.getChildren().add(text);

        GridPane gridPane = new GridPane();
        gridPane.add(onHand, 8, 0);
        gridPane.add(onPaper, 10, 0);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        bpRoot.setTop(hbLoginText);
        bpRoot.setCenter(gridPane);

        //conection with style.css
        bpRoot.setId("bpRoot");
        onHand.setId("buttons");
        onPaper.setId("buttons");
        text.setId("text");


        primaryStage.setScene(scene);
        primaryStage.show();

    }
}






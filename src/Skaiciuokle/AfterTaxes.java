package Skaiciuokle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AfterTaxes {
    private BorderPane root;
    private Stage primaryStage;
    public TextField tfSalary;
    public Label lbSaleryAfter;
    public Label lblTexesCalc;
    public Label lblNpdCalc;
    public  Label lblSveikatosCalc;
    public Label lblFullCalc;


    public AfterTaxes(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.root = new BorderPane();

        Scene scene = new Scene(this.root,400,400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle("Atlyginimas į rankas");
        this.primaryStage.setResizable(false);
        this.primaryStage.centerOnScreen();

        addElementsToScene();

        primaryStage.show();

    }

    private void addElementsToScene (){
        Label labelSalary = new Label("Atlyginimas popieriuje:");
        tfSalary = new TextField();
        tfSalary.setPromptText("Įveskite atlyginimą");
        tfSalary.setAlignment(Pos.CENTER);


        Label labelSaleryAfter = new Label("Atlyginimas į rankas:");
        lbSaleryAfter = new Label();


        Label lblTexesSodrai = new Label("Mokesčiai sodrai:");
        lblTexesCalc = new Label();


        Label lblNpd = new Label("NPD mokesčiai:");
        lblNpdCalc = new Label();

        Label lblSveikatosDr = new Label("Sveikatos draudimas:");
        lblSveikatosCalc = new Label();

        Label lblPNPD = new Label("PNPD:");
        Label labelPNPDCalc = new Label();

        Label lblFullPrice = new Label("Darbo vietos kaina:");
        lblFullCalc = new Label();


        Button calculate = new Button("Skaičiuoti");
        calculate.setMinWidth(100);
        calculate.setAlignment(Pos.CENTER);
        calculate.setOnAction((ActionEvent e)->{ double salary = Double.parseDouble(tfSalary.getText());
        double iRankas = (salary * 0.76);
        double sodrai = (salary * 0.03);
        double sveikatosDr = (salary * 0.06);
        double darboVieta = (salary * 1.318);

        lbSaleryAfter.setText(String.valueOf(iRankas));
        lblTexesCalc.setText(String.valueOf(sodrai));
        lblSveikatosCalc.setText(String.valueOf(sveikatosDr));
        lblFullCalc.setText(String.valueOf(darboVieta));

        });

        Button cancel = new Button("Grįžti");
        cancel.setMinWidth(100);
        cancel.setAlignment(Pos.CENTER);
        cancel.setOnAction((ActionEvent e)->{
            Calculator calculator = new Calculator(this.primaryStage);
        });


        GridPane pane = new GridPane();
        pane.add(labelSalary,0,0);
        pane.add(tfSalary,1,0);
        pane.add(labelSaleryAfter,0,1);
        pane.add(lbSaleryAfter,1,1);
        pane.add(lblTexesSodrai,0,2);
        pane.add(lblTexesCalc,1,2);
        pane.add(lblNpd,0,3);
        pane.add(lblNpdCalc,1,3);
        pane.add(lblSveikatosDr, 0, 4);
        pane.add(lblSveikatosCalc, 1, 4);
        pane.add(lblPNPD, 0,5);
        pane.add(labelPNPDCalc, 1, 5);
        pane.add(lblFullPrice, 0, 6);
        pane.add(lblFullCalc, 1,6);


        pane.add(calculate, 1, 9);
        pane.add(cancel,1,10);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(10);
        pane.setHgap(10);

        this.root.setCenter(pane);

        //pair with css
        lbSaleryAfter.setId("style1");
        lblTexesCalc.setId("style");
        lblNpdCalc.setId("style");
        lblSveikatosCalc.setId("style");
        labelPNPDCalc.setId("style");
        lblFullCalc.setId("style2");
    }


}

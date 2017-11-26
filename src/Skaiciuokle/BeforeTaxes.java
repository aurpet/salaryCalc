package Skaiciuokle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;


public class BeforeTaxes {
    private BorderPane root;
    private Stage primaryStage;
    public TextField tfSalary;
    public Label lbSaleryAfter;
    public Label lblTexesCalc;
    public Label lblNpdCalc;
    public Label lblSveikatosCalc;
    public Label lblFullCalc;
    HBox hBox = new HBox(5);
    GridPane pane;


    public BeforeTaxes(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.root = new BorderPane();

        Scene scene = new Scene(this.root, 360, 480);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle("Atlyginimas popieriuje");
        this.primaryStage.setResizable(false);
        this.primaryStage.centerOnScreen();

        addElementsToScene();

        primaryStage.show();

    }

    private void addElementsToScene() {
        Label labelSalary = new Label("Atlyginimas į rankas");
        tfSalary = new TextField();
        tfSalary.setPromptText("Įveskite atlyginimą");
        tfSalary.setAlignment(Pos.CENTER);

        Label labelVaikai = new Label("Auginami vaikai iki 18:");
        ChoiceBox cb = new ChoiceBox();
        cb.setItems(FXCollections.observableArrayList("0", "1", "2", "3", "4"));
        cb.getSelectionModel().selectFirst();

        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("vienas");
        RadioButton button2 = new RadioButton("su sutuoktiniu");
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);


        Label labelSaleryAfter = new Label("Atlyginimas į popieriuje:");
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
        calculate.setOnAction((ActionEvent e) -> {
            if (tfSalary.getText() == null || tfSalary.getText().trim().isEmpty()) {
                showAlert(Alert.AlertType.INFORMATION, pane.getScene().getWindow(),
                        "Nieko neįvedėte!", "Įveskite gaunamą atlyginimą į rankas!");

            } else {
                double salary = Double.parseDouble(tfSalary.getText());

                double popieriuje = (salary * 1.315);
                double sodrai = (popieriuje * 0.03);
                double sveikatosDr = (popieriuje * 0.06);
                double darboVieta = (popieriuje * 1.315);
                double npd = (310 - (0.5 * salary));

                lbSaleryAfter.setText(String.format("%.2f", popieriuje));
                lblTexesCalc.setText(String.format("%.2f", sodrai));
                lblSveikatosCalc.setText(String.format("%.2f", sveikatosDr));
                lblFullCalc.setText(String.format("%.2f", darboVieta));
                lblNpdCalc.setText(String.format("%.2f", npd));

                if (npd < 1) {
                    lblNpdCalc.setText(String.format("netaikomi"));
                }
            }
        });

        Button cancel = new Button("Grįžti");
        cancel.setMinWidth(100);
        cancel.setAlignment(Pos.CENTER);
        cancel.setOnAction((ActionEvent e) -> {
            Calculator calculator = new Calculator(this.primaryStage);
        });


        //add element on the HBox
        hBox.getChildren().addAll(cb, button1, button2);


        //add element on the gridpane
        pane = new GridPane();
        pane.add(labelSalary, 0, 0);
        pane.add(tfSalary, 1, 0);
        pane.add(labelVaikai, 0, 1);
        pane.add(hBox, 1, 1);
        pane.add(labelSaleryAfter, 0, 2);
        pane.add(lbSaleryAfter, 1, 2);
        pane.add(lblTexesSodrai, 0, 3);
        pane.add(lblTexesCalc, 1, 3);
        pane.add(lblNpd, 0, 4);
        pane.add(lblNpdCalc, 1, 4);
        pane.add(lblSveikatosDr, 0, 5);
        pane.add(lblSveikatosCalc, 1, 5);
        pane.add(lblPNPD, 0, 6);
        pane.add(labelPNPDCalc, 1, 6);
        pane.add(lblFullPrice, 0, 7);
        pane.add(lblFullCalc, 1, 7);
        pane.add(calculate, 1, 10);
        pane.add(cancel, 1, 11);

        pane.setPadding(new Insets(10, 10, 10, 10));
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


    //alert when empty salary inpute textfield
    private void showAlert(Alert.AlertType alerType, Window owner, String title, String message) {
        Alert alert = new Alert(alerType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:///C:/Users/Aurimas/IdeaProjects/AtlyginimoSkaiciuokle/src/Img/alert.png"));
        alert.show();

    }

}

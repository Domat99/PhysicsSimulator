/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.function.UnaryOperator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextFormatter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

/**
 *
 * @author Domat
 */
public class ControlProject {

    //Classes and Variables
    static ViewProject v1;
    Double posDblInitial;
    Double velDblInitial;
    Double accDbl;
    Double posDblFinal;
    Double velDblFinal;
    int timeInt;

    //Create a connection with the database
    DBConnectionProvider connectionProvider = new DBConnectionProvider();
    Connection connection = connectionProvider.getConnection();

    public ControlProject(ViewProject view) {
        
        v1 = view;
        posDblFinal = 0.0;
        velDblFinal = 0.0;
        posDblInitial = 0.0;
        velDblInitial = 0.0;
        accDbl = 0.0;

    }

    //Setting the position Text Field value to the slider's value
    protected ChangeListener sliderControlPosition() {

        ChangeListener listener = (ChangeListener<Number>) (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            posDblInitial = newValue.doubleValue();
            v1.positionTF.setText(String.format("%.2f", posDblInitial));
        };
        return listener;
    }
    
    //Setting the velocity Text Field value to the slider's value
    protected ChangeListener sliderControlVelocity() {

        ChangeListener listener = (ChangeListener<Number>) (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            velDblInitial = newValue.doubleValue();
            v1.velocityTF.setText(String.format("%.2f", velDblInitial));
        };
        return listener;
    }

    //Setting the acceleration Text Field value to the slider's value
    protected ChangeListener sliderControlAcceleration() {

        ChangeListener listener = (ChangeListener<Number>) (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            accDbl = newValue.doubleValue();
            v1.accelerationTF.setText(String.format("%.2f", accDbl));
        };
        return listener;
    }
    
    //Function to set a limit for the number of entered characters in the Text Field
    protected void textFieldChartNumPosition(TextField tf){
        tf.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    
                    if (tf.getText().length() >= 8) {
                        
                        tf.setText(tf.getText().substring(0, 8));
                    }
                }
            }
        });     
    }

    //Returns the entered value in the Text Field
    private Double initialValue(TextField tf1) {

        String input = tf1.getText();
        Double num = Double.parseDouble(input);
        return num;
    }

    //Returns the entered time value
    private int timeValue() {

        int time = (int) v1.sliderTime.getValue();
        return time;
    }

    //Filter TextField Input so it can only take numbers, minus sign, and a coma 
    //for the decimal numbers
    UnaryOperator<TextFormatter.Change> filter = (TextFormatter.Change t) -> {
        if (t.isReplaced()) {
            if (t.getText().matches("[^0-9]")) {
                t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
            }
        }
        if (t.isAdded()) {
            if (t.getControlText().contains(".")) {
                if (t.getText().matches("[^0-9]")) {
                    t.setText("");
                }
            }
            if (t.getControlText().contains("-?")) {
                if (t.getText().matches("[^0-9]")) {
                    t.setText("");
                }
            } else if (t.getText().matches("[^0-9.-]")) {
                t.setText("");
            }
        }
        return t;
    };

    //The main function to get the data in order to build the graphs
    protected void mainFunction(Event e) {
        
        verifyEnteredNum(v1.positionTF, "position");
        verifyEnteredNum(v1.velocityTF, "velocity");
        verifyEnteredNum(v1.accelerationTF, "acceleration");

        posDblInitial = initialValue(v1.positionTF);
        velDblInitial = initialValue(v1.velocityTF);
        accDbl = initialValue(v1.accelerationTF);
        timeInt = timeValue();

        v1.posChart.getData().clear();
        v1.velChart.getData().clear();
        v1.accChart.getData().clear();

        XYChart.Series<Number, Number> posSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> velSeries = new XYChart.Series<>();
        XYChart.Series<Number, Number> accSeries = new XYChart.Series<>();

        if (velDblInitial == 0.0 && accDbl == 0.0) {
            positionGraph(posSeries, velSeries, accSeries);
        }

        if (accDbl == 0.0) {
            velocityGraph(posSeries, velSeries, accSeries);
        } else {
            accelerationGraph(posSeries, velSeries, accSeries);
        }
    }

    //Function to set the position data serie
    private void positionGraph(XYChart.Series<Number, Number> posSeries, Series velSeries, Series accSeries) {

        for (double i = 0; i <= timeInt; i = i + 0.5) {

            posSeries.getData().add(new XYChart.Data<>(i, posDblInitial));
            velSeries.getData().add(new XYChart.Data<>(i, velDblInitial));
            accSeries.getData().add(new XYChart.Data<>(i, accDbl));
        }
        graphDrawer(posSeries, velSeries, accSeries);

        setLabels();
    }

    //Function to set the velocity data serie
    private void velocityGraph(Series posSeries, Series velSeries, Series accSeries) {

        for (double i = 0; i <= timeInt; i = i + 0.5) {

            velSeries.getData().add(new XYChart.Data<>(i, velDblInitial));
            posDblFinal = (i * velDblInitial) + posDblInitial;
            posSeries.getData().add(new XYChart.Data<>(i, posDblFinal));
            accSeries.getData().add(new XYChart.Data<>(i, accDbl));
        }
        graphDrawer(posSeries, velSeries, accSeries);

        setLabels();
    }

    //Function to set the acceleration data serie    
    private void accelerationGraph(Series posSeries, Series velSeries, Series accSeries) {

        for (double i = 0; i <= timeInt; i = i + 0.5) {

            accSeries.getData().add(new XYChart.Data<>(i, accDbl));
            velDblFinal = (i * accDbl) + velDblInitial;
            velSeries.getData().add(new XYChart.Data<>(i, velDblFinal));
            posDblFinal = (i * velDblFinal) + posDblInitial;
            posSeries.getData().add(new XYChart.Data<>(i, posDblFinal));
        }
        graphDrawer(posSeries, velSeries, accSeries);

        setLabels();
    }

    //The function that assighn each data serie to its proper graph
    private void graphDrawer(Series posSeries, Series velSeries, Series accSeries) {

        ObservableList<XYChart.Series<Number, Number>> posData
                = FXCollections.<XYChart.Series<Number, Number>>observableArrayList();

        posData.add(posSeries);

        v1.posChart.setData(posData);

        ObservableList<XYChart.Series<Number, Number>> velData
                = FXCollections.<XYChart.Series<Number, Number>>observableArrayList();

        velData.add(velSeries);

        v1.velChart.setData(velData);

        ObservableList<XYChart.Series<Number, Number>> accData
                = FXCollections.<XYChart.Series<Number, Number>>observableArrayList();

        accData.add(accSeries);

        v1.accChart.setData(accData);

        //set ToolTip for the graphs' data points
        v1.e1.addToolTipChart(v1.posChart, "The Position is ", "m");
        v1.e1.addToolTipChart(v1.velChart, "The Velocity is ", "m/s");
        v1.e1.addToolTipChart(v1.accChart, "The Acceleration is ", "m/s\u00B2");
    }

    //Function to set the values in the Final Values Box (9)
    private void setLabels() {

        DecimalFormat df = new DecimalFormat("0.00");

        if (timeInt == 1) {
            v1.valuesLbl.setText("Final Values after one second:");
        } else {
            v1.valuesLbl.setText("Final Values after " + timeInt + " seconds:");
        }
        v1.posIniValueLbl.setText("Initial Position: " + df.format(posDblInitial) + " m.");
        v1.velIniValueLbl.setText("Initial Velocity: " + df.format(velDblInitial) + " m/s.");
        v1.accValueLbl.setText("Initial Acceleration: " + df.format(accDbl) + " m/s" + '\u00B2' + ".");
        v1.posFinValueLbl.setText("Final Position: " + df.format(posDblFinal) + " m.");
        v1.velFinValueLbl.setText("Final Velocity: " + df.format(velDblFinal) + " m/s.");
    }

    //Function that resets the content of all the graphs, the values in the 
    //Final Values Box (9), and the Text Fields depending on which graph was selected
    protected void clearGraphs(Event e, String stat) {

        if (stat.equals("POS") || stat.equals("ALL")) {
            v1.posChart.getData().clear();
            v1.sliderPosition.setValue(0);
            v1.positionTF.setText("0.00");
        }

        if (stat.equals("VEL") || stat.equals("ALL")) {
            v1.velChart.getData().clear();
            v1.sliderVelocity.setValue(0);
            v1.velocityTF.setText("0.00");
        }

        if (stat.equals("ACC") || stat.equals("ALL")) {
            v1.accChart.getData().clear();
            v1.sliderAcceleration.setValue(0);
            v1.accelerationTF.setText("0.00");
        }

        if (stat.equals("ALL")) {
            v1.sliderTime.setValue(1);
        }

        v1.valuesLbl.setText("Final Values after __ seconds:");
        v1.posIniValueLbl.setText("Initial Position: ");
        v1.velIniValueLbl.setText("Initial Velocity: ");
        v1.accValueLbl.setText("Initial Acceleration: ");
        v1.posFinValueLbl.setText("Final Position: ");
        v1.velFinValueLbl.setText("Final Velocity: ");

        posDblInitial = 0.0;
        velDblInitial = 0.0;
        posDblFinal = 0.0;
        velDblFinal = 0.0;
        accDbl = 0.0;
        timeInt = 0;
    }

    //Function that creates the popup window for the shortcuts
    protected void popUpWindowsShortcuts(Event e) {
        ImageView dinosaurLogo = new ImageView(
                new Image(FinalProject.class.getResourceAsStream("graphics/Dinosaur Icon.png")));

        Label secondLabel = new Label(" Shortcuts:");
        secondLabel.setStyle("-fx-font: 50 Algerian;");

        Separator separator1 = new Separator();

        Label allLbl = new Label("\n   Save: \t\t\t\tCtrl+S\n   Import: \t\t\tCtrl+I\n"
                + "   Start: \t\t\t\tCtrl+A\n   Reset Values: \t\tCrtl+R\n"
                + "   Shortcuts Window: \tF2\n   Reset Settings: \t\tF5\n"
                + "   FAQ's: \t\t\t\tCtrl+H");

        allLbl.setStyle("-fx-font: 25 Harrington;");

        Label lbl3 = new Label("\nMade by: ©!ERROR404 inc. ※2021※");
        lbl3.setStyle("-fx-size: 25;");

        VBox vbox1 = new VBox();
        HBox hbox1 = new HBox();

        hbox1.getChildren().addAll(dinosaurLogo, lbl3);
        vbox1.getChildren().addAll(secondLabel, allLbl, separator1, hbox1);
        StackPane secondaryLayout = new StackPane();

        secondaryLayout.getChildren().add(vbox1);

        Scene secondScene = new Scene(secondaryLayout, 360, 390);

        Stage newWindow = new Stage();
        newWindow.initStyle(StageStyle.UTILITY);
        newWindow.setTitle("Shortcuts");
        newWindow.setScene(secondScene);

        newWindow.show();
    }
    
    //Function to veirfy the entered values in the Text Fields before using them
    private void verifyEnteredNum(TextField tf2, String type){
         
        try{
            Double test = initialValue(tf2);
            Double ans = test / 2;
        }catch(NumberFormatException exp){
            System.err.println("An incompatible value was entered."
                    + "\nThe value of " + type + " has been changed to 0.00");
            tf2.setText("0.00");
        }
    
    }

    //Function to save the data in the Text Fields into the database
    protected void save(Event e) {
        
        verifyEnteredNum(v1.positionTF, "position");
        verifyEnteredNum(v1.velocityTF, "velocity");
        verifyEnteredNum(v1.accelerationTF, "acceleration");

        String query = "UPDATE physicsvalues SET position = ? , "
                + "velocity = ? , " + "acceleration = ? , " + "time = ?";
        
        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, v1.positionTF.getText());
            pstmt.setString(2, v1.velocityTF.getText());
            pstmt.setString(3, v1.accelerationTF.getText());
            pstmt.setString(4, String.valueOf(v1.sliderTime.getValue()));

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            System.out.println("An Error Has Occured With PhysycsValues Update: " + ex.getMessage());
        }
    }

    //Function that imports the data from the database
    protected void importData(Event e) {

        String query = "SELECT * FROM physicsvalues";

        try {

            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            posDblInitial = Double.valueOf(resultSet.getString("position"));
            velDblInitial = Double.valueOf(resultSet.getString("velocity"));
            accDbl = Double.valueOf(resultSet.getString("acceleration"));
            timeInt = Integer.parseInt(String.valueOf(resultSet.getString("time").charAt(0)));

        } catch (NumberFormatException | SQLException ex) {

            System.out.println("An Error Has Occured With PhysycsValues Selecting: " + ex.getMessage());
        }

        v1.positionTF.setText(String.format("%.2f", posDblInitial));

        v1.velocityTF.setText(String.format("%.2f", velDblInitial));

        v1.accelerationTF.setText(String.format("%.2f", accDbl));

        v1.sliderTime.setValue(timeInt);
    }

    //Function to check the data values if they are equal to the saved numbers 
    //in the database before closing the program
    protected void checkData(Event e) {

        String query = "SELECT * FROM physicsvalues";
        String posData = "";
        String velData = "";
        String accData = "";
        double timeData = 0.0;

        try {

            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            posData = resultSet.getString("position");
            velData = resultSet.getString("velocity");
            accData = resultSet.getString("acceleration");
            timeData = Double.parseDouble(resultSet.getString("time"));

        } catch (NumberFormatException | SQLException ex) {

            System.out.println("An Error Has Occured With PhysycsValues Selecting To Check: " + ex.getMessage());
        }

        if (!posData.equals(v1.positionTF.getText())
                || !velData.equals(v1.velocityTF.getText())
                || !accData.equals(v1.accelerationTF.getText())
                || !(timeData == v1.sliderTime.getValue())) {
            closePopUp(e);
        }
    }
    
    //Function to check the saved colors and fonts and apply them to the  
    //radio menu items when the program starts
    protected void checkColorAndFontData() {

        String query1 = "SELECT * FROM backgrounds";
        String query2 = "SELECT * FROM fonts";
        String colorData1 = "";
        String colorData2 = "";
        String fontLabelData = "";

        try {
            
            Statement stmt1 = connection.createStatement();
            Statement stmt2 = connection.createStatement();
            
            ResultSet resultSet1 = stmt1.executeQuery(query1);
            ResultSet resultSet2 = stmt2.executeQuery(query2);
            
            colorData1 = resultSet1.getString("color1");
            colorData2 = resultSet1.getString("color2");
            fontLabelData = resultSet2.getString("label");


        } catch (NumberFormatException | SQLException ex) {

            System.out.println("An Error Has Occured With finding the color, to check: " + ex.getMessage());
        }
        if ((colorData1.equals("#BFBFBF")) && (colorData2.equals("#A1A1A1") && fontLabelData.equals("18 Garamond;"))) {
            v1.subThemes1.setSelected(true);
        } else if ((colorData1.equals("#70AD47")) && (colorData2.equals("#D7BE09") && fontLabelData.equals("15 helvetica;"))) {
            v1.subThemes2.setSelected(true);
        } else if ((colorData1.equals("#C00000")) && (colorData2.equals("#FF7171") && fontLabelData.equals("18 forte;"))) {
            v1.subThemes3.setSelected(true);
        } else {
            if ((colorData1.equals("#deb887")) && (colorData2.equals("#C5DFFB"))) {
                v1.subColorMain.setSelected(true);
            } else if ((colorData1.equals("#BFBFBF")) && (colorData2.equals("#A1A1A1"))) {
                v1.subColorGrey.setSelected(true);
            } else if ((colorData1.equals("#FFFFFF")) && (colorData2.equals("#D7BE09"))) {
                v1.subColorYellow.setSelected(true);
            } else {
                System.out.println("ERROR while retrieving background color");
            }

            switch (fontLabelData) {
                case "15 helvetica;":
                    v1.subFonts1.setSelected(true);
                    break;
                case "18 Garamond;":
                    v1.subFonts1.setSelected(true);
                    break;
                case "18 forte;":
                    v1.subFonts3.setSelected(true);
                    break;
                default:
                    System.out.println("ERROR while retrieving fonts");
                    break;
            }
        }
    }

    //Function that creates the warning popup before closing the program
    private void closePopUp(Event e) {

        ButtonType Save = new ButtonType("Save and Close", ButtonBar.ButtonData.OK_DONE);
        ButtonType Quit = new ButtonType("Close Without Saving", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.FINISH);

        Alert alert = new Alert(Alert.AlertType.WARNING,
                "Do You Want to Save the Program Before Closing?",
                Save,
                Quit,
                Cancel);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initStyle(StageStyle.UNDECORATED);

        alert.setHeaderText("Data Has Not Been Saved");
        alert.getDialogPane().setMinSize(600, 200);
        alert.getDialogPane().setMaxSize(600, 200);

        alert.setTitle("Warning");

        Optional<ButtonType> closeResponse = alert.showAndWait();

        if (closeResponse.get().equals(Save)) {
            save(e);
        }
        if (closeResponse.get().equals(Quit)) {
            Platform.exit();
        }
        if (closeResponse.get().equals(Cancel)) {
            e.consume();
        }
    }

    //OPEN LINKS
    //For Buttons
    protected void OpenLinkBtn(Button b3, String st) {
        b3.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome " + st});
            } catch (IOException ex) {
                Logger.getLogger(ControlProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    //For Pictures
    protected void OpenLinkPic(ImageView iV1, String st1) {
        iV1.setOnMouseClicked(event -> {
            try {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome " + st1});
            } catch (IOException ex) {
                Logger.getLogger(ControlProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    //For Menus
    protected void OpenLinkMenuItem(MenuItem m1, String st2) {
        m1.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome " + st2});
            } catch (IOException ex) {
                Logger.getLogger(ControlProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    //Open Applications (Calculator)
    protected void ButtonOpenApp(Button btn, String s) {
        btn.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec(s);
            } catch (IOException ex) {
                Logger.getLogger(ViewProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    //Function to save the background every time the user changes it
    protected void saveBackgroundChange(String col1, String col2) {

        String query = "UPDATE backgrounds SET color1 = ?, color2 = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, col1);
            pstmt.setString(2, col2);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("An Error Has Occured With Background Update: " + ex.getMessage());
        }
    }

    //Function to import the saved background from the database and apply it when
    //the program starts
    protected void importBackground(Scene sc1) {

        String query = "SELECT * FROM backgrounds";
        String color1 = "";
        String color2 = "";

        try {

            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            color1 = resultSet.getString("color1");
            color2 = resultSet.getString("color2");

        } catch (SQLException ex) {

            System.out.println("An Error Has Occured With background Selecting: " + ex.getMessage());
        }

        v1.e1.changeBackgroundColor(sc1, color1, color2, false);
    }

    //Function to save the Fonts in the database
    protected void saveFontChange(String label, String button1, String button2, String slider, String menu, String chart) {

        String query = "UPDATE fonts SET label = ?, button1 = ?, button2 = ?, slider = ?, menu = ?, chart = ?";

        try {

            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, label);
            pstmt.setString(2, button1);
            pstmt.setString(3, button2);
            pstmt.setString(4, slider);
            pstmt.setString(5, menu);
            pstmt.setString(6, chart);

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            System.out.println("An Error Has Occured With Fonts Update: " + ex.getMessage());
        }
    }

    //Function to import the Fonts from the database and apply them when the 
    //program starts
    protected void importFont() {

        String query = "SELECT * FROM fonts";
        String label = "";
        String button1 = "";
        String button2 = "";
        String slider = "";
        String menu = "";
        String chart = "";

        try {

            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            label = resultSet.getString("label");
            button1 = resultSet.getString("button1");
            button2 = resultSet.getString("button2");
            slider = resultSet.getString("slider");
            menu = resultSet.getString("menu");
            chart = resultSet.getString("chart");

        } catch (SQLException ex) {

            System.out.println("An Error Has Occured With Fonts Selecting: " + ex.getMessage());
        }

        v1.e1.changeFont(v1.labelGroup, label, v1.buttonsGroup1, button1, v1.buttonsGroup2, button2,
                v1.sliderGroup, slider, v1.menuGroup, menu, v1.chartGroup, chart, false);
    }
}
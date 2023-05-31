/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elias
 */
public class FinalProject extends Application {

    Scene scene1;

    @Override
    public void start(Stage stage) throws Exception {
        
        Group root1 = new Group();

        stage.setTitle("Physics Graph Simulator by !ERROR404");

        ViewProject view1 = new ViewProject(this);
        
        root1.getChildren().add(view1);

        scene1 = new Scene(root1, 1500, 865);

        view1.c1.importBackground(scene1);

        view1.c1.importFont();

        view1.c1.checkColorAndFontData();
        
        scene1.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        stage.setOnCloseRequest(event -> view1.c1.checkData(event));

        stage.setScene(scene1);

        stage.show();

    }

    /*
    @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

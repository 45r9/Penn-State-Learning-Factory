/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.components;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author prate
 */
public class RfidDemo extends Application{
    @Override
    public void start(Stage stage) {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        StackPane pane = new StackPane();
        pane.getChildren().add(main);
        StackPane.setMargin(main, new Insets(100));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 800, 200);
        scene.getStylesheets().add(ButtonDemo.class.getResource("/css/jfoenix-components.css").toExternalForm());
        stage.setTitle("JFX Button Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

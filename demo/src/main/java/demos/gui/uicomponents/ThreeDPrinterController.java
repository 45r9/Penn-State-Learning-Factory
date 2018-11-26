/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.gui.uicomponents;

import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
//More imports needed for the line graph
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
//End of more imports

/**
 * FXML Controller class
 *
 * @author prate
 */
@ViewController(value = "/fxml/ui/ThreeDPrinter.fxml", title = "Material Design Example")
public class ThreeDPrinterController implements Initializable{
    
    @FXML
    CategoryAxis xAxis;
    @FXML
    NumberAxis yAxis;
    @FXML
    LineChart<?, ?> printerChart;
    
    //ComboBox FXML's to return choices
    @FXML
    ComboBox<String> jfxComboBox1;
    ObservableList<String> printerList = FXCollections.observableArrayList();
    
    //EventHandler<MouseEvent> onMouseClick = newEventHandler<MouseEvent>()
    //Maybe use a listener?    -> Also a possible solution
    //Multithreading?   -> Possible to implement but difficult
    //runLater?     -> Does not work with setting the name of the axis
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        jfxComboBox1.setValue("Printer 1");
        //Select a Printer to adjust the data
        
        XYChart.Series series = new XYChart.Series();
        
        //Platform.runLater(() -> printerChart.getData().add(series));
        
        
        switch(jfxComboBox1.getSelectionModel().getSelectedItem())
        {
            case "Printer 1":
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series = new XYChart.Series();
                
                series.setName("Printer 1's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 23));
                series.getData().add(new XYChart.Data("Tuesday", 58));
                series.getData().add(new XYChart.Data("Wednesday", 76));
                series.getData().add(new XYChart.Data("Thursday", 10));
                series.getData().add(new XYChart.Data("Friday", 43));
                series.getData().add(new XYChart.Data("Saturday", 26));
                series.getData().add(new XYChart.Data("Sunday", 35));

                printerChart.getData().add(series);
                break;
            case "Printer 2": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series2 = new XYChart.Series();
                series.setName("Printer 2's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 56));
                series.getData().add(new XYChart.Data("Tuesday", 45));
                series.getData().add(new XYChart.Data("Wednesday", 89));
                series.getData().add(new XYChart.Data("Thursday", 100));
                series.getData().add(new XYChart.Data("Friday", 20));
                series.getData().add(new XYChart.Data("Saturday", 15));
                series.getData().add(new XYChart.Data("Sunday", 40));
                
                printerChart.getData().add(series);
                break;
            case "Printer 3": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series3 = new XYChart.Series();
                series.setName("Printer 3's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 86));
                series.getData().add(new XYChart.Data("Tuesday", 45));
                series.getData().add(new XYChart.Data("Wednesday", 99));
                series.getData().add(new XYChart.Data("Thursday", 8));
                series.getData().add(new XYChart.Data("Friday", 5));
                series.getData().add(new XYChart.Data("Saturday", 25));
                series.getData().add(new XYChart.Data("Sunday", 47));
                
                printerChart.getData().add(series);
                break;
            case "Printer 4": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series4 = new XYChart.Series();
                series.setName("Printer 4's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 36));
                series.getData().add(new XYChart.Data("Tuesday", 15));
                series.getData().add(new XYChart.Data("Wednesday", 0));
                series.getData().add(new XYChart.Data("Thursday", 25));
                series.getData().add(new XYChart.Data("Friday", 37));
                series.getData().add(new XYChart.Data("Saturday", 28));
                series.getData().add(new XYChart.Data("Sunday", 54));
                
                printerChart.getData().add(series);
                break;
            case "Printer 5": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series5 = new XYChart.Series();
                series.setName("Printer 5's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 23));
                series.getData().add(new XYChart.Data("Tuesday", 58));
                series.getData().add(new XYChart.Data("Wednesday", 76));
                series.getData().add(new XYChart.Data("Thursday", 10));
                series.getData().add(new XYChart.Data("Friday", 43));
                series.getData().add(new XYChart.Data("Saturday", 26));
                series.getData().add(new XYChart.Data("Sunday", 35));
                
                printerChart.getData().add(series);
                break;
            case "Printer 6": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series6 = new XYChart.Series();
                series.setName("Printer 6's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 56));
                series.getData().add(new XYChart.Data("Tuesday", 45));
                series.getData().add(new XYChart.Data("Wednesday", 89));
                series.getData().add(new XYChart.Data("Thursday", 100));
                series.getData().add(new XYChart.Data("Friday", 20));
                series.getData().add(new XYChart.Data("Saturday", 15));
                series.getData().add(new XYChart.Data("Sunday", 40));
                
                printerChart.getData().add(series);
                break;
            case "Printer 7": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series7 = new XYChart.Series();
                series.setName("Printer 7's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 86));
                series.getData().add(new XYChart.Data("Tuesday", 45));
                series.getData().add(new XYChart.Data("Wednesday", 99));
                series.getData().add(new XYChart.Data("Thursday", 8));
                series.getData().add(new XYChart.Data("Friday", 5));
                series.getData().add(new XYChart.Data("Saturday", 25));
                series.getData().add(new XYChart.Data("Sunday", 47));
                
                printerChart.getData().add(series);
                break;
            case "Printer 8": 
                //Clear old data
                printerChart.getData().clear();
                
                //XYChart.Series series8 = new XYChart.Series();
                series.setName("Printer 8's Vibration Data");
                
                series.getData().add(new XYChart.Data("Monday", 36));
                series.getData().add(new XYChart.Data("Tuesday", 15));
                series.getData().add(new XYChart.Data("Wednesday", 0));
                series.getData().add(new XYChart.Data("Thursday", 25));
                series.getData().add(new XYChart.Data("Friday", 37));
                series.getData().add(new XYChart.Data("Saturday", 28));
                series.getData().add(new XYChart.Data("Sunday", 54));
                
                printerChart.getData().add(series);
                break;
            default:
                XYChart.Series seriesdefault = new XYChart.Series();
                seriesdefault.setName("Please select a Printer");
                break;
        }  
    }
    
    
}

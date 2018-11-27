/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.gui.uicomponents;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.function.Function;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;
import javax.print.Doc;
import javax.swing.text.Document;

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
    
    @FXML
    private JFXTreeTableView UserTableView;
    @FXML
    private TreeTableColumn<Machine, String> assetName;
    @FXML
    private TreeTableColumn<Machine, String> currentPeriod;
    @FXML
    private TreeTableColumn<Machine, String> sinceServiced;
    @FXML
    private TreeTableColumn<Machine, String> serviceInt;
    @FXML
    private TreeTableColumn<Machine, String> usage;	
    @FXML
    private TreeTableColumn<Machine, String> tag;

    @PostConstruct
    public void init() {
        setupUserTableView();
    }
    private <T> void setupCellValueFactory(TreeTableColumn<Machine, T> column, Function<Machine, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Machine, T> param) -> {

                return mapper.apply(param.getValue().getValue());

    });
    }

    private void setupUserTableView() {
        setupCellValueFactory(assetName, Machine::nameProperty);
        setupCellValueFactory(currentPeriod, Machine::opProperty);
        setupCellValueFactory(sinceServiced, Machine::serveProperty);
        setupCellValueFactory(serviceInt, Machine::intProperty);
        setupCellValueFactory(usage, Machine::useProperty);
        setupCellValueFactory(tag, Machine::tagProperty);

        ObservableList<Machine> dummyData = generateDummyData();
        UserTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        UserTableView.setShowRoot(false);
}
        
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
        
    private ObservableList generateDummyData() {
            final ObservableList<Machine> data = FXCollections.observableArrayList();
            data.add(new Machine( "LULZBOT MINI 1" , "2", "15", "60", "500", "1"));
            data.add(new Machine( "LULZBOT MINI 2" , "0", "15", "60", "435", "2"));
            data.add(new Machine( "LULZBOT MINI 3" , "0", "15", "60", "320", "3"));        
            data.add(new Machine( "LULZBOT MINI 4" , "0", "15", "60", "65", "4"));       
            data.add(new Machine( "MCOR ARCE" , "4", "15", "30", "120", "4"));       
            data.add(new Machine( "BJET 60" , "6", "15", "30", "86", "6"));       
            data.add(new Machine( "LASER CUTTER 1" , "1", "30", "90", "240", "7"));       
            data.add(new Machine( "LASER CUTTER 2" , "2", "30", "90", "124", "8"));
            return data;
        }
    
    
        static final class Machine extends RecursiveTreeObject{

            final StringProperty name;
            final StringProperty operatingPeriod;
            final StringProperty serviceDate;
            final StringProperty interval;
            final StringProperty use;
            final StringProperty tagID;

            public Machine(String name, String operatingPeriod, String serviceDate, String interval, String use, String tagID) {
                this.name = new SimpleStringProperty(name);
                this.operatingPeriod = new SimpleStringProperty(operatingPeriod);
                this.serviceDate = new SimpleStringProperty(serviceDate);
                this.interval = new SimpleStringProperty(interval);
                this.use = new SimpleStringProperty(use);
                this.tagID = new SimpleStringProperty(tagID);
                
            }
            public StringProperty nameProperty() {
                return name;
            }
            public StringProperty opProperty() {
                return operatingPeriod;
            }
            public StringProperty serveProperty() {
                return serviceDate;
            }
            public StringProperty intProperty() {
                return interval;
            }
            public StringProperty useProperty() {
                return use;
            }
            public StringProperty tagProperty() {
                return tagID;
            }

        }  
    }


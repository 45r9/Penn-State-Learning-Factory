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
public class ThreeDPrinterController {
/**
     * init fxml when loaded.
     */
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

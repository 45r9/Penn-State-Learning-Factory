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

@ViewController(value = "/fxml/ui/Rfid.fxml", title = "Material Design Example")
public class RfidController {
  /**
     * init fxml when loaded.
     */
    @FXML
    private JFXTreeTableView UserTableView;
    @FXML
    private JFXComboBox<Label> jfxComboBox;
    @FXML
    private TreeTableColumn<RFID, String> DayColumn;
    @FXML
    private TreeTableColumn<RFID, String> DateColumn;
    @FXML
    private TreeTableColumn<RFID, String> UserColumn;
    @FXML
    private TreeTableColumn<RFID, String> CheckinColumn;
    @FXML
    private TreeTableColumn<RFID, String> CheckoutColumn;
    @FXML
    private LineChart<String,Number> graphview;


    @FXML
    private JFXTreeTableView ItemTableView;
    @FXML
    private TreeTableColumn<RFID, String> iDayColumn;
    @FXML
    private TreeTableColumn<RFID, String> iDateColumn;
    @FXML
    private TreeTableColumn<RFID, String> iUserColumn;
    @FXML
    private TreeTableColumn<RFID, String> ItemColumn;
    @FXML
    private TreeTableColumn<RFID, String> iCheckoutColumn;

    @FXML
    private JFXButton reportGraph;
  
       private final String[] names = {"Morley", "Scott", "Kruger", "Lain",
        "Kennedy", "Gawron", "Han", "Hall", "Aydogdu", "Grace",
        "Spiers", "Perera", "Smith", "Connoly",
        "Sokolowski", "Chaow", "James", "June",};
        
       private final String[] dates = {"Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday",};
       
       private final Random random = new SecureRandom();
        int index=random.nextInt(names.length);		

    @PostConstruct
    public void init() {
        setupUserTableView();
        setupItemTableView();
        loadgraph();
        jfxComboBox.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                jfxComboBox.validate();
            }
        });
    }
    private <T> void setupCellValueFactory(TreeTableColumn<RFID, T> column, Function<RFID, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<RFID, T> param) -> {
            
                return mapper.apply(param.getValue().getValue());

       });
    }
    
    private void setupUserTableView() {
        setupCellValueFactory(DayColumn, RFID::DayProperty);
        setupCellValueFactory(DateColumn, RFID::DateProperty);
        setupCellValueFactory(UserColumn, RFID::UserProperty);
        setupCellValueFactory(CheckinColumn, RFID::CheckinProperty);
        setupCellValueFactory(CheckoutColumn, RFID::CheckoutProperty);
         
        ObservableList<RFID> dummyData = generateDummyData(6);
        UserTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        UserTableView.setShowRoot(false);
        
        reportGraph.setOnMouseClicked((e) -> {
             createReport();
        });
  }
    private void setupItemTableView() {
        setupCellValueFactory(iDayColumn, RFID::DayProperty);
        setupCellValueFactory(iDateColumn, RFID::DateProperty);
        setupCellValueFactory(iUserColumn, RFID::UserProperty);
        setupCellValueFactory(ItemColumn, RFID::ItemProperty);
        setupCellValueFactory(iCheckoutColumn, RFID::CheckoutProperty);
      
        ObservableList<RFID> dummyData = generateDummyData(6);
        ItemTableView.setRoot(new RecursiveTreeItem<>(dummyData, RecursiveTreeObject::getChildren));
        ItemTableView.setShowRoot(false);
 
 
  }
    
       private void loadgraph() {

        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        graphview.getData().clear();
        series.setName("RFID DATA");
        series.getData().add(new XYChart.Data<String,Number>("11-9", 11));
        series.getData().add(new XYChart.Data<String,Number>("11-12", 22));
        series.getData().add(new XYChart.Data<String,Number>("11-13", 18));
        series.getData().add(new XYChart.Data<String,Number>("11-14", 7));
        graphview.getData().add(series);

     }
    
   private void   createReport(){
    //JasperReport report= JasperCompileManager.compileReport();
   
   }   
  private ObservableList generateDummyData(final int numberOfEntries) {
        final ObservableList<RFID> dummyData = FXCollections.observableArrayList();
        for (int i = 0; i < numberOfEntries; i++) {
            dummyData.add(createNewRandomData(i));
        }
        return dummyData;
    }

    private RFID createNewRandomData(int i){

        if(i==0){
        return new RFID("Friday",
                        "11-9",
                         "Morley",
                         "screwdriver",
                         "13:01",
                         "16:31");
        }
        if(i==1){
        return new RFID("Monday",
                        "11-12",
                         "Grace",
                         "hammer",
                         "15:21",
                         "17:34");
        }
         if(i==2){
        return new RFID("Monday",
                        "11-12",
                         "Perera",
                         "trad",
                         "17:10",
                         "19:05");
        }
        if(i==3){
        return new RFID("Monday",
                        "11-12",
                         "Smith",
                         "inflator",
                         "17:21",
                         "17:55");
        }
        if(i==4){
        return new RFID("Tuesday",
                        "11-13",
                         "James",
                         "screwdriver",
                         "14:56",
                         "16:55");
        }
        if(i==5){
        return new RFID("Tuesday",
                        "11-13",
                         "Han",
                         "trad",
                         "16:56",
                         "18:22");
        }
        if(i==6){
        return new RFID("Wednesday",
                        "11-14",
                         "Lain",
                         "screwdriver",
                         "15:56",
                         "16:22");
        }
        return new RFID(dates[random.nextInt(dates.length)],
                          names[random.nextInt(names.length)],
                          names[random.nextInt(names.length)],
                          names[random.nextInt(names.length)],
                          names[random.nextInt(names.length)],
                          names[random.nextInt(names.length)]);
    }
  
 
    static final class RFID extends RecursiveTreeObject{

        private final StringProperty Day;
        private final StringProperty Date;
        private final StringProperty User;
        private final StringProperty Item;
        private final StringProperty Checkin;
        private final StringProperty Checkout;
        public  RFID(String Day, String Date,String User,String Item,String Checkin,String Checkout) {
            this.Day = new SimpleStringProperty(Day);
            this.Date = new SimpleStringProperty(Date);
            this.User = new SimpleStringProperty(User);
            this.Item = new SimpleStringProperty(Item);
            this.Checkin = new SimpleStringProperty(Checkin);
            this.Checkout = new SimpleStringProperty(Checkout);
            
        }
        

        public StringProperty DayProperty() {
        
            return Day;
        }

        public StringProperty DateProperty() {
            return Date;
        }

        public StringProperty UserProperty() {
            return User;
        }
        
        public StringProperty ItemProperty() {
            return Item;
        }
        
        public StringProperty CheckinProperty() {
            return Checkin;
        }
        
         public StringProperty CheckoutProperty() {
            return Checkout;
        }

    }
}

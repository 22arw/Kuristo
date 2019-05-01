package kuristo;

import com.fazecast.jSerialComm.SerialPort;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    String chosenPort;
    String chosenBaud;

    @FXML
    private Menu portSelect;

    @FXML
    private Menu baudSelect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup portChoice = new ToggleGroup();

        for (int i = 0; i < SerialPort.getCommPorts().length; i++) {
            RadioMenuItem port = new RadioMenuItem(SerialPort.getCommPorts()[i].getSystemPortName());
            port.setToggleGroup(portChoice);
            port.setUserData(SerialPort.getCommPorts()[i].getSystemPortName());
            portSelect.getItems().add(port);
        }

        portChoice.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println(t1.getUserData());
                chosenPort = t1.getUserData().toString();
            }
        });

        ToggleGroup baudChoice = new ToggleGroup();

        String[] bauds = new String[13];
        bauds[0] = "9600";
        bauds[1] = "300";
        bauds[2] = "600";
        bauds[3] = "1200";
        bauds[4] = "2400";
        bauds[5] = "4800";
        bauds[6] = "9600";
        bauds[7] = "14400";
        bauds[8] = "19200";
        bauds[9] = "28800";
        bauds[10] = "38400";
        bauds[11] = "57600";
        bauds[12] = "115200";

        for (int i = 0; i <bauds.length; i++) {
            RadioMenuItem baud = new RadioMenuItem(bauds[i]);
            baud.setToggleGroup(baudChoice);
            baud.setUserData(bauds[i]);
            baudSelect.getItems().add(baud);
        }

        baudChoice.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println(t1.getUserData());
                chosenBaud = t1.getUserData().toString();
            }
        });

    }

}

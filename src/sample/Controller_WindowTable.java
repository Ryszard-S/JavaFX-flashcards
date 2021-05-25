package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller_WindowTable implements Initializable {
    @FXML
    private TableView<Lista_slowek> table;

    @FXML
    private TableColumn<Lista_slowek,String> word;

    @FXML
    private TableColumn<Lista_slowek,String> translation;

    @FXML
    private TableColumn<Lista_slowek,Integer> know;

    @FXML
    private TableColumn<Lista_slowek,Integer> dontKnow;

    @FXML
    private TextField tWord;
    @FXML
    private TextField tTranslation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableUpdate();
    }

    @FXML
    public void Add(){
        String word = tWord.getText();
        String translation = tTranslation.getText();
        setGetLista.getLista().add(new Lista_slowek(word,translation,0,0));
        TableUpdate();
    }

    public void Delete(){
        int index = table.getSelectionModel().selectedIndexProperty().get();
        setGetLista.getLista().remove(index);
        TableUpdate();
    }

    public void TableUpdate(){
        word.setCellValueFactory(new PropertyValueFactory<>("s_polski"));

        translation.setCellValueFactory(new PropertyValueFactory<>("s_niemiecki"));

        know.setCellValueFactory(new PropertyValueFactory<>("wiem"));

        dontKnow.setCellValueFactory(new PropertyValueFactory<>("nie_wiem"));

        ObservableList Listaa = FXCollections.observableArrayList(setGetLista.getLista());
        table.setItems(Listaa);

    }
}

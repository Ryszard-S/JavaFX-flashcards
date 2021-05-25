package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_NewFile implements Initializable {
    @FXML
    private TableView<Lista_slowek> table;

    @FXML
    private TableColumn<Lista_slowek,String> word;

    @FXML
    private TableColumn<Lista_slowek,String> translation;

    @FXML
    private TextField tWord;
    @FXML
    private TextField tTranslation;

    @FXML
    private TextField curretDir;
    @FXML
    private TextField fileName;

    setGetPath path ;
    String cDir;
    readFile rf = new readFile();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(setGetPath.getDir());
        curretDir.setText(setGetPath.getDir());
        cDir=setGetPath.getDir();
        path = new setGetPath();

        TableUpdate();
    }

    @FXML
    public void Add(){
        String word = tWord.getText();
        String translation = tTranslation.getText();
        setGetLista.getLista().add(new Lista_slowek(word,translation,0,0));
        TableUpdate();
    }
    @FXML
    public void Delete(){
        int index = table.getSelectionModel().selectedIndexProperty().get();
        setGetLista.getLista().remove(index);
        TableUpdate();
    }
    @FXML
    public void Applay(){
        path = new setGetPath();
        String txtName=fileName.getText();
        if(txtName == ""){
            txtName="filename";
        }
        path.setPath(cDir+"\\"+txtName+".txt");
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter(setGetPath.getPath());
            zapis.println();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        assert zapis != null;
        zapis.close();

        System.out.println(setGetPath.getPath());
        rf.read();
        TableUpdate();
    }

    public void TableUpdate(){
        word.setCellValueFactory(new PropertyValueFactory<>("s_polski"));

        translation.setCellValueFactory(new PropertyValueFactory<>("s_niemiecki"));

        ObservableList Listaa = FXCollections.observableArrayList(setGetLista.getLista());
        table.setItems(Listaa);

    }

    public void save(ActionEvent actionEvent) {
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter(setGetPath.getPath());
            for (int i = 0; i<setGetLista.getLista().size();i++) {
                Lista_slowek y = (Lista_slowek) setGetLista.getLista().get(i);
                zapis.println(y.getS_polski() + ";" + y.getS_niemiecki() + ";" + y.getWiem() + ";" + y.getNie_wiem());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        assert zapis != null;
        zapis.close();
    }
}

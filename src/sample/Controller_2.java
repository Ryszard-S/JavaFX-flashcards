package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

public class Controller_2{
    @FXML
    public TextArea text_pl;
    @FXML
    public TextArea text_de;
    @FXML
    public TextArea text_i_know;
    @FXML
    public TextArea text_i_dont_know;
    @FXML
    private MenuBar menuBar;


    int row=0;
    public Lista_slowek y;
    

    public void Controller_2(){
        Collections.sort(setGetLista.getLista());
        y= (Lista_slowek) setGetLista.getLista().get(row);
        text_pl.setText(y.getS_polski());
        text_i_know.setText(String.valueOf(y.getWiem()));
        text_i_dont_know.setText(String.valueOf(y.getNie_wiem()));
    }

    @FXML
    public void I_Know(){
        if (row < setGetLista.getLista().size()){
            int z = y.getWiem() + 1;
            y.setWiem(z);
            next();
        }
        else {
            text_pl.setText("Koniec listy");
            text_de.setText("");
        }

    }
    @FXML
    public void i_dont_know(){
        if (row < setGetLista.getLista().size()){

            y.setNie_wiem(y.getNie_wiem() + 1);
            next();
        }
        else {
            text_pl.setText("Koniec listy");
            text_de.setText("");
        }
    }
    public void show_answer(){
        text_de.setText(y.getS_niemiecki());
    }

    private void next(){
        row++;
        if(row<setGetLista.getLista().size()) {
            y = (Lista_slowek) setGetLista.getLista().get(row);
            text_pl.setText(y.getS_polski());
            text_de.setText("");
            text_i_know.setText(String.valueOf(y.getWiem()));
            text_i_dont_know.setText(String.valueOf(y.getNie_wiem()));
        }
    }
    @FXML
    public void save(){
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter(setGetPath.getPath());
            for (int i = 0; i<setGetLista.getLista().size();i++) {
                y = (Lista_slowek) setGetLista.getLista().get(i);
                zapis.println(y.getS_polski() + ";" + y.getS_niemiecki() + ";" + y.getWiem() + ";" + y.getNie_wiem());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        assert zapis != null;
        zapis.close();

//        for (int i = 0; i<setGetLista.getLista().size();i++) {
//            y=(Lista_slowek) setGetLista.getLista().get(i);
//        }
    }
    @FXML
    public void show_table(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("window_table.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    public void fullScreen(ActionEvent event){
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setFullScreen(true);
    }
    @FXML
    public void exitFullScreen(ActionEvent event){
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setFullScreen(false);
    }
    @FXML
    public void addNewFile(ActionEvent event) throws IOException{
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("window_NewFile.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("window_NewFile.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }
    @FXML
    public void chooseFile() throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("window_1.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("window_1.css").toExternalForm());
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Flashcards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

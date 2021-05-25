package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    public TextField txtF_path;
    public static setGetPath p = new setGetPath();
    FileChooser fileChooser = new FileChooser();
    File file;
    readFile readfile = new readFile();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void Choose(ActionEvent e){
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            txtF_path.setText(file.getAbsolutePath());
            p.setPath(file.getAbsolutePath());
            p.setDir(file.getAbsoluteFile().getParent());
        }
    }
    public void Applay(ActionEvent event) throws IOException {
        readfile.read();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("window_2.fxml"));
        root=loader.load();

        Controller_2 c = loader.getController();
        c.Controller_2();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}

package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Loading  the initial scene

            loadFXML("home.fxml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void home(ActionEvent event) throws IOException {
        loadFXML("home.fxml");
    }

    public void AHD(ActionEvent event) throws IOException {
        loadFXML("Adding_Horse.fxml");
    }

    public void UHD(ActionEvent event) throws IOException {
        loadFXML("Update_Horse_Detail.fxml");
    }

    public void DHD(ActionEvent event) throws IOException {
        loadFXML("Delete_Horse.fxml");
    }

    public void VHD(ActionEvent event) throws IOException {
        loadFXML("View_Horse_Details.fxml");
    }

    public void SHD(ActionEvent event) throws IOException {
        loadFXML("Save_Horses.fxml");
    }

    @FXML
    public void Start(ActionEvent event) throws IOException {
        loadFXML("Start.fxml");
    }


    protected void loadFXML(String fxmlFileName) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource(fxmlFileName));
        contentArea.getChildren().clear();
        contentArea.getChildren().setAll(fxml);
    }


    @FXML
    public void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Press OK to exit or Cancel to stay.");

        // Customizing the buttons in the alert dialog
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, cancelButton);

        // Handling user's choice
        alert.showAndWait().ifPresent(response -> {
            if (response == okButton) {
                // Close the application
                Stage stage = (Stage) contentArea.getScene().getWindow();
                stage.close();
            }
        });
    }
}

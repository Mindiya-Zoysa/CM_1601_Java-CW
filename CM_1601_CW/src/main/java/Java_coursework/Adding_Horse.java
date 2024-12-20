package Java_coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Adding_Horse implements Initializable {

    // FXML Variables
    @FXML
    private ChoiceBox<String> group;
    @FXML
    private TextField id;
    @FXML
    private TextField jockey;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField breed;
    @FXML
    private TextField races;
    @FXML
    private TextField wins;

    private final String[] groups = {"A", "B", "C", "D"};
    int ID, Age, Wins, TotalRace;
    String Name, Jockey, Group, Breed, raceRecord;

    int countA = 0;
    int countB = 0;
    int countC = 0;
    int countD = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initializing Groups A,B,C,D in check box
        group.getItems().addAll(groups);
    }

    // Creating an Arraylist that contain all the details of horses and that arraylist can be access in all classes
    public static ArrayList<ArrayList> WholeHorses = new ArrayList<>();

    public void submit(ActionEvent event) {
        // Getting count of the group in the first
        GroupCount();

        try {
            if (id.getText().isEmpty() || name.getText().isEmpty() || jockey.getText().isEmpty() ||
                    age.getText().isEmpty() || breed.getText().isEmpty() || wins.getText().isEmpty() ||
                    races.getText().isEmpty() || group.getValue() == null) {
                throw new NullPointerException("All fields must be filled and a group must be selected.");
            }

            ID = Integer.parseInt(id.getText());
            Name = name.getText();
            Jockey = jockey.getText();
            Age = Integer.parseInt(age.getText());
            Breed = breed.getText();
            Wins = Integer.parseInt(wins.getText());
            TotalRace = Integer.parseInt(races.getText());
            Group = group.getValue();

            if (ID <= 0) throw new NumberFormatException("ID must be a positive integer.");
            if (Age <= 0 || Age > 30) throw new NumberFormatException("Age must be between 1 and 30.");
            if (Wins < 0 || TotalRace <= 0) throw new NumberFormatException("Wins and Total Races must be positive integers.");
            if (Name.length() > 50 || Jockey.length() > 50 || Breed.length() > 50) throw new IllegalArgumentException("Name, Jockey, and Breed should not exceed 50 characters.");

            boolean idExists = WholeHorses.stream().anyMatch(horse -> (int) horse.get(0) == ID);

            if (idExists) {
                showAlert(Alert.AlertType.WARNING, "ID is already there", "Already that Given id is there. Change the ID ...");
            } else {
                if (WholeHorses.size() < 20) {
                    if (Wins <= TotalRace) {
                        raceRecord = Wins + " Wins in " + TotalRace + " races";
                        switch (Group) {
                            case "A":
                                if (countA < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group);
                                    resetFields();
                                } else {
                                    showAlert(Alert.AlertType.WARNING, "Group A is Full", "Only 5 horses for each group.");
                                }
                                break;
                            case "B":
                                if (countB < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group);
                                    resetFields();
                                } else {
                                    showAlert(Alert.AlertType.WARNING, "Group B is Full", "Only 5 horses for each group.");
                                }
                                break;
                            case "C":
                                if (countC < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group);
                                    resetFields();
                                } else {
                                    showAlert(Alert.AlertType.WARNING, "Group C is Full", "Only 5 horses for each group.");
                                }
                                break;
                            case "D":
                                if (countD < 5) {
                                    HorseList(ID, Name, Jockey, Age, Breed, raceRecord, Group);
                                    resetFields();
                                } else {
                                    showAlert(Alert.AlertType.WARNING, "Group D is Full", "Only 5 horses for each group.");
                                }
                                break;
                        }
                    } else {
                        showAlert(Alert.AlertType.WARNING, "Wrong input", "Wins can't be higher than Total Races.");
                    }
                } else {
                    showAlert(Alert.AlertType.WARNING, "Limit Reached", "Maximum 20 horses can be added.");
                }
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Invalid input", e.getMessage());
        } catch (NullPointerException e) {
            showAlert(Alert.AlertType.WARNING, "Missing input", e.getMessage());
        } catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.WARNING, "Invalid input", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void HorseList(int ID, String Name, String Jockey, int Age, String Breed, String raceRecord, String Group) {
        ArrayList<Object> horseDetails = new ArrayList<>();
        horseDetails.add(ID);
        horseDetails.add(Name);
        horseDetails.add(Jockey);
        horseDetails.add(Age);
        horseDetails.add(Breed);
        horseDetails.add(raceRecord);
        horseDetails.add(Group);
        WholeHorses.add(horseDetails);
    }

    private void resetFields() {
        showAlert(Alert.AlertType.INFORMATION, "Submitted", "Successfully added horse details.");

        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;

        id.clear();
        age.clear();
        wins.clear();
        races.clear();
        name.clear();
        jockey.clear();
        breed.clear();
        group.getSelectionModel().clearSelection();
    }

    private void GroupCount() {
        countA = (int) WholeHorses.stream().filter(horse -> "A".equals(horse.get(6))).count();
        countB = (int) WholeHorses.stream().filter(horse -> "B".equals(horse.get(6))).count();
        countC = (int) WholeHorses.stream().filter(horse -> "C".equals(horse.get(6))).count();
        countD = (int) WholeHorses.stream().filter(horse -> "D".equals(horse.get(6))).count();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

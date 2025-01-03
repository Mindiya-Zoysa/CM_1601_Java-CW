package Java_coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Select_Horses_Randomly implements Initializable {

    @FXML
    private TableColumn<Selected_Horses, Integer> id;

    @FXML
    private TableColumn<Selected_Horses, String> name;

    @FXML
    private TableColumn<Selected_Horses, String> jockey;

    @FXML
    private TableColumn<Selected_Horses, Integer> age;

    @FXML
    private TableColumn<Selected_Horses, String> breed;

    @FXML
    private TableColumn<Selected_Horses, String> record;

    @FXML
    private TableColumn<Selected_Horses, String> group;

    @FXML
    private TableView<Selected_Horses> table;

    public static ArrayList <ArrayList> SelectedHorses = new ArrayList();

    static String Selected_A;
    static String Selected_B;
    static String Selected_C;
    static String Selected_D;


    Random rand = new Random();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id")); // Changed PropertyValueFactory<DataView, Integer>("id") to new PropertyValueFactory<>("id")
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        jockey.setCellValueFactory(new PropertyValueFactory<>("jockey"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        breed.setCellValueFactory(new PropertyValueFactory<>("breed"));
        record.setCellValueFactory(new PropertyValueFactory<>("record"));
        group.setCellValueFactory(new PropertyValueFactory<>("group"));

    }

    private ObservableList<Selected_Horses> initialData = FXCollections.observableArrayList();

    @FXML
    private void populateData() {
        for (ArrayList<Object> horse : SelectedHorses) {
            int ID = (int) horse.get(0);
            String Name = (String) horse.get(1);
            String Jockey = (String) horse.get(2);
            int Age = (int) horse.get(3);
            String Breed = (String) horse.get(4);
            String Record = (String) horse.get(5);
            String Group = (String) horse.get(6);

                        Selected_Horses data = new Selected_Horses(ID, Name, Jockey, Age, Breed, Record, Group);
            initialData.add(data);
        }
        table.setItems(initialData);
    }

    public void select(ActionEvent event) {
        initialData.clear();

        SelectedHorses.clear();

        Selected();
        viewGA();
        viewGB();
        viewGC();
        viewGD();

        populateData();

    }

    public void Selected() {

        int A_length = Start.GroupA.size();
        int B_length = Start.GroupB.size();
        int C_length = Start.GroupC.size();
        int D_length = Start.GroupD.size();

        System.out.println();

        int A_selected = rand.nextInt(A_length);
        int B_selected = rand.nextInt(B_length);
        int C_selected = rand.nextInt(C_length);
        int D_selected = rand.nextInt(D_length);

        Selected_A = (String) Start.GroupA.get(A_selected);
        Selected_B = (String) Start.GroupB.get(B_selected);
        Selected_C = (String) Start.GroupC.get(C_selected);
        Selected_D = (String) Start.GroupD.get(D_selected);

        System.out.println(Selected_A);
        System.out.println(Selected_B);
        System.out.println(Selected_C);
        System.out.println(Selected_D);

    }

    public void viewGA(){
        String input = Selected_A;

        String[] words = input.substring(1, input.length() - 1).split(", ");

        int id = Integer.parseInt(words[0]);
        String name = words[1];
        String jockey  = words[2];
        int age = Integer.parseInt(words[3]);
        String breed= words[4];
        String record= words[5];
        String group = words[6];

        ArrayList horse_GA = new ArrayList();
        horse_GA.add(id);
        horse_GA.add(name);
        horse_GA.add(jockey);
        horse_GA.add(age);
        horse_GA.add(breed);
        horse_GA.add(record);
        horse_GA.add(group);

        SelectedHorses.add(horse_GA);
    }

    public void viewGB(){
        String input = Selected_B;

        String[] words = input.substring(1, input.length() - 1).split(", ");

        int id = Integer.parseInt(words[0]);
        String name = words[1];
        String jockey  = words[2];
        int age = Integer.parseInt(words[3]);
        String breed= words[4];
        String record= words[5];
        String group = words[6];

        ArrayList horse_GB = new ArrayList();
        horse_GB.add(id);
        horse_GB.add(name);
        horse_GB.add(jockey);
        horse_GB.add(age);
        horse_GB.add(breed);
        horse_GB.add(record);
        horse_GB.add(group);

        SelectedHorses.add(horse_GB);
    }

    public void viewGC(){
        String input = Selected_C;

        String[] words = input.substring(1, input.length() - 1).split(", ");

        int id = Integer.parseInt(words[0]);
        String name = words[1];
        String jockey  = words[2];
        int age = Integer.parseInt(words[3]);
        String breed= words[4];
        String record= words[5];
        String group = words[6];

        ArrayList horse_GC = new ArrayList();
        horse_GC.add(id);
        horse_GC.add(name);
        horse_GC.add(jockey);
        horse_GC.add(age);
        horse_GC.add(breed);
        horse_GC.add(record);
        horse_GC.add(group);

        SelectedHorses.add(horse_GC);
    }

    public void viewGD(){
        String input = Selected_D;

        String[] words = input.substring(1, input.length() - 1).split(", ");

        int id = Integer.parseInt(words[0]);
        String name = words[1];
        String jockey  = words[2];
        int age = Integer.parseInt(words[3]);
        String breed= words[4];
        String record= words[5];
        String group = words[6];

        ArrayList horse_GD = new ArrayList();
        horse_GD.add(id);
        horse_GD.add(name);
        horse_GD.add(jockey);
        horse_GD.add(age);
        horse_GD.add(breed);
        horse_GD.add(record);
        horse_GD.add(group);

        SelectedHorses.add(horse_GD);
    }
}

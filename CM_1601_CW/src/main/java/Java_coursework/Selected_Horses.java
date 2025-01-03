package Java_coursework;

import javafx.scene.image.ImageView;

public class Selected_Horses {

    private int id;
    private String name;
    private String jockey;

    private int age;

    private String breed;

    private String record;

    private String group;


    public Selected_Horses(int id, String name, String jockey, int age, String breed, String record, String group) {
        this.id = id;
        this.name = name;
        this.jockey = jockey;
        this.age = age;
        this.breed = breed;
        this.record = record;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}


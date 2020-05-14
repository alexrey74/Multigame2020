package fr.ipac.multigame.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    String name;
    String firstName;
    String age;
    String picture;
    String localisation;
    ArrayList<Game> scores;

    public Player(String name, String firstName, String age, String picture, String localisation) {
        setName(name);
        setFirstName(firstName);
        setAge(age);
        setPicture(picture);
        setLocalisation(localisation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public ArrayList<Game> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Game> scores) {
        this.scores = scores;
    }
}

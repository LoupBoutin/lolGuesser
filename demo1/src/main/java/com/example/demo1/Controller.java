package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static com.example.demo1.Main.*;

public class Controller {
    @FXML
    public void up(ActionEvent e) {
        System.out.println("up");
    }
    @FXML
    public void down(ActionEvent e) {
        System.out.println("down");
    }
    @FXML
    public void right(ActionEvent e) {
        System.out.println("right");
    }
    @FXML
    public void left(ActionEvent e) {
        System.out.println("left");
    }

    @FXML
    public void typeAChampionName(ActionEvent e) throws FileNotFoundException {
        ArrayList<Champion> championsReadFromFile = new ArrayList<Champion>();
        championsReadFromFile = readChampFromFile("src\\main\\java\\com\\example\\demo1\\champText.txt");
        ArrayList<String> champNameList = champNameListString(championsReadFromFile);

        //isInTheList(champNameListString(championsReadFromFile));

        //getRandomItem(championsReadFromFile);

        Champion aatrox = championsReadFromFile.get(0);
        Champion ahri = championsReadFromFile.get(1);
        Champion akali = championsReadFromFile.get(2);
        Champion akshan = championsReadFromFile.get(3);


        //System.out.println(scFindObject(isInTheList(champNameList), championsReadFromFile));

        Champion actualChampion = scFindObject(isInTheList(champNameList), championsReadFromFile);
        Champion guessChampion = getRandomItem(championsReadFromFile);

        while (!winCondition(actualChampion, guessChampion)) {

            if (actualChampion.getGender().equals(guessChampion.getGender())) {
                System.out.println("Gender : Correct");
            } else {
                System.out.println("Gender : Incorrect");
            }

            if (actualChampion.getPosition().equals(guessChampion.getPosition())) {
                System.out.println("Position : Correct");
            } else {
                System.out.println("Position : Incorrect");
            }
            actualChampion = scFindObject(isInTheList(champNameList), championsReadFromFile);
        }
    }

}
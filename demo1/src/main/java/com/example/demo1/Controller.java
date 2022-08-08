package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.example.demo1.Main.*;

public class Controller {
    @FXML
    ImageView myImageView = new ImageView("file:src\\main\\resources\\Image\\beemo.png");
    @FXML
    Label myLabel;
    @FXML
    TextField myTextField;
    @FXML
    public Button myButton;

    @FXML
    Text nameText;
    @FXML
    Text genderText;
    @FXML
    Text positionText;

    @FXML
    VBox nameBox;
    @FXML
    VBox genderBox;
    @FXML
    VBox positionBox;

    String sc;
    String[] similitude = {"NAME", "GENDER", "POSITION"};

    /**
     * Renvoie un String. -> input de myTextField.
     * Prend en paramètre:
     * Un event -> ENTER.
     * @param event
     * @return
     */
    @FXML
    public void handle(KeyEvent event) throws FileNotFoundException {
        if (event.getCode() == KeyCode.ENTER) {
            sc = myTextField.getText();
            System.out.println(sc);
            ArrayList<Champion> championsReadFromFile; // la liste des champions sous forme de reference.
            championsReadFromFile = readChampFromFile("src\\main\\java\\com\\example\\demo1\\champText.txt"); // lit le text qui donne la liste de champions.
            ArrayList<String> champNameList = champNameListString(championsReadFromFile); // la liste des noms de champions.
            sc = myTextField.getText();
            if (champNameList.contains(sc)) {
                System.out.println("c'est valide");
                Champion actualChampion = scFindObject(sc, championsReadFromFile); // renvoie le champion qui était dans myTextField.
                Champion guessChampion = getRandomItem(championsReadFromFile);

                if (actualChampion.getName().equals(guessChampion.getName())) {
                    System.out.println("Name : Correct");
                    similitude[0] = (actualChampion.getName());
                    nameText.setText(actualChampion.getName());
                } else {
                    System.out.println("Name : Incorrect");
                }

                if (actualChampion.getGender().equals(guessChampion.getGender())) {
                    System.out.println("Gender : Correct");
                    similitude[1] = (actualChampion.getGender());
                    genderText.setText(actualChampion.getGender());
                } else {
                    System.out.println("Gender : Incorrect");
                }

                if (actualChampion.getPosition().equals(guessChampion.getPosition())) {
                    System.out.println("Position : Correct");
                    similitude[2] = (actualChampion.getPosition());
                    positionText.setText(actualChampion.getPosition());
                } else {
                    System.out.println("Position : Incorrect");
                }

                System.out.println(Arrays.toString(similitude));

            } else { System.out.println("c'est pas valide"); }
        }
    }
    @FXML
    public void submit(ActionEvent event) {
        try {
            ArrayList<Champion> championsReadFromFile; // la liste des champions sous forme de reference.
            championsReadFromFile = readChampFromFile("src\\main\\java\\com\\example\\demo1\\champText.txt"); // lit le text qui donne la liste de champions.
            ArrayList<String> champNameList = champNameListString(championsReadFromFile); // la liste des noms de champions.
            sc = myTextField.getText();
            if (champNameList.contains(sc)) {
                System.out.println("c'est valide");
                Champion actualChampion = scFindObject(sc, championsReadFromFile); // renvoie le champion qui était dans myTextField.
                Champion guessChampion = getRandomItem(championsReadFromFile);

                    if (actualChampion.getGender().equals(guessChampion.getGender())) {
                        System.out.println("Gender : Correct");
                        similitude[2] = (actualChampion.getGender());
                    } else {
                        System.out.println("Gender : Incorrect");
                    }

                    if (actualChampion.getPosition().equals(guessChampion.getPosition())) {
                        System.out.println("Position : Correct");
                    } else {
                        System.out.println("Position : Incorrect");
                    }


            } else { System.out.println("c'est pas valide"); }

        } catch (Exception e) { System.out.println(e); }
    }


            /*System.out.println(champNameList);
            //System.out.println(championsReadFromFile);
            try {

                Champion actualChampion = scFindObject(isInTheList(sc, champNameList), championsReadFromFile);
                if (!(champNameList.contains(sc))) {
                    myTextField.setPromptText("Type a valid champion name... ");
                }
                System.out.println(actualChampion);
            } catch (Exception e) {
                System.out.println("error frerot");
            }





        /*Champion aatrox = championsReadFromFile.get(0);
        Champion ahri = championsReadFromFile.get(1);
        Champion akali = championsReadFromFile.get(2);
        Champion akshan = championsReadFromFile.get(3);*/

        /*Champion actualChampion = scFindObject(isInTheList( champNameList), championsReadFromFile); // ici isInTheList fait appel au shell pour justement scanner un nom et voir
        // si il est dans la liste des noms de champions, ensuite scFindObject transforme le String scanner en object.
        Champion guessChampion = getRandomItem(championsReadFromFile);

        while (!winCondition(actualChampion, guessChampion)) {

            if (actualChampion.getGender().equals(guessChampion.getGender())) {
                System.out.println("Gender : Correct");
                similitude[2] = (actualChampion.getGender());
            } else {
                System.out.println("Gender : Incorrect");
            }

            if (actualChampion.getPosition().equals(guessChampion.getPosition())) {
                System.out.println("Position : Correct");
            } else {
                System.out.println("Position : Incorrect");
            }
            actualChampion = scFindObject(isInTheList( champNameList), championsReadFromFile);
        }*/
    /**
     * Renvoie un String. -> si le scanner est bien dans la liste, alors on revoie le String scanner.
     * Compare le scanner ( variable locale à la fonction ) et l'arrayList prit en paramètre.
     * Prend en paramètre:
     * ArrayList de String the List -> l'arrayList de champNameListString(ArraList Champion theList).
     * @param sc
     * @param theList
     * @return
    */
   /*public static String isInTheList(String sc, ArrayList<String> theList) {
        if (!(theList.contains(sc))) {
            myTextField.setText("Type a valid champion name... ");
        }
        return sc;
    }*/
}
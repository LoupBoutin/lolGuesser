package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static com.example.demo1.Main.*;

public class Controller {
    @FXML
    ImageView myImageView = new ImageView("file:src\\main\\resources\\Image\\beemo.png");
    @FXML
    Text myText;
    @FXML
    TextField myTextField;
    @FXML
    public Button myButton;
    @FXML
    Text nameOfActualChampText;
    @FXML
    Text genderOfActualChampText;
    @FXML
    Text positionOfActualChampText;
    @FXML Text nameText;
    @FXML Text genderText;
    @FXML Text positionText;
    @FXML VBox nameBoxOfAC;
    @FXML VBox genderBoxOfAC;
    @FXML VBox positionBoxOfAC;
    @FXML VBox nameBox;
    @FXML VBox genderBox;
    @FXML VBox positionBox;
    String sc;
    String[] similitude = {"NAME", "GENDER", "POSITION"};
    String[] actualChampChar = {"NAME", "GENDER", "POSITION"};
    Champion guessTheChamp;

    /**
     * Renvoie un String. -> input de myTextField.
     * Prend en paramètre:
     * Un event -> ENTER.
     * @param event
     * @return
     */
    @FXML
    public void handle(KeyEvent event) throws FileNotFoundException {

        ArrayList<Champion> championsReadFromFile; // la liste des champions sous forme de reference.
        championsReadFromFile = readChampFromFile("src\\main\\java\\com\\example\\demo1\\champText.txt"); // lit le text qui donne la liste de champions.
        ArrayList<String> champNameList = champNameListString(championsReadFromFile); // la liste des noms de champions.
        if (guessTheChamp == null) {
            guessTheChamp = getRandomItem(championsReadFromFile);
        }

        if (event.getCode() == KeyCode.ENTER) {
            sc = myTextField.getText();
            //System.out.println(sc);

            sc = myTextField.getText();
            if (champNameList.contains(sc)) {
                //System.out.println("c'est valide");
                myText.setText(null);
                Champion actualChampion = scFindObject(sc, championsReadFromFile); // renvoie le champion qui était dans myTextField.
                nameOfActualChampText.setText(actualChampion.getName());
                genderOfActualChampText.setText(actualChampion.getGender());
                positionOfActualChampText.setText(actualChampion.getPosition());

                if (actualChampion.getName().equals(guessTheChamp.getName())) {
                    //System.out.println("Name : Correct");
                    similitude[0] = (actualChampion.getName());
                    nameText.setText(actualChampion.getName());
                    nameBoxOfAC.setBackground(Background.fill(Color.GREEN));
                    nameBox.setBackground(Background.fill(Color.GREEN));
                } else {
                    //System.out.println("Name : Incorrect");
                    nameBoxOfAC.setBackground(Background.fill(Color.RED));
                }

                if (actualChampion.getGender().equals(guessTheChamp.getGender())) {
                    //System.out.println("Gender : Correct");
                    similitude[1] = (actualChampion.getGender());
                    genderText.setText(actualChampion.getGender());
                    genderBoxOfAC.setBackground(Background.fill(Color.GREEN));
                    genderBox.setBackground(Background.fill(Color.GREEN));
                } else {
                    //System.out.println("Gender : Incorrect");
                    genderBoxOfAC.setBackground(Background.fill(Color.RED));
                }

                if (actualChampion.getPosition().equals(guessTheChamp.getPosition())) {
                    //System.out.println("Position : Correct");
                    similitude[2] = (actualChampion.getPosition());
                    positionText.setText(actualChampion.getPosition());
                    positionBoxOfAC.setBackground(Background.fill(Color.GREEN));
                    positionBox.setBackground(Background.fill(Color.GREEN));
                } else {
                    //System.out.println("Position : Incorrect");
                    positionBoxOfAC.setBackground(Background.fill(Color.RED));
                }
            } else {
                //System.out.println("c'est pas valide");
                myText.setText("Invalid champion name");
            }
        }
    }
    @FXML
    public void submit(ActionEvent event) throws FileNotFoundException {
        ArrayList<Champion> championsReadFromFile; // la liste des champions sous forme de reference.
        championsReadFromFile = readChampFromFile("src\\main\\java\\com\\example\\demo1\\champText.txt"); // lit le text qui donne la liste de champions.
        ArrayList<String> champNameList = champNameListString(championsReadFromFile); // la liste des noms de champions.
        guessTheChamp = getRandomItem(championsReadFromFile);

        nameText.setText("NAME");
        nameBox.setBackground(Background.fill(Color.BLACK));
        genderText.setText("GENDER");
        genderBox.setBackground(Background.fill(Color.BLACK));
        positionText.setText("POSITION");
        positionBox.setBackground(Background.fill(Color.BLACK));
        Image myImage = new Image(getClass().getResourceAsStream("file:src\\main\\resources\\Image\\beemo.png"));
        myImageView.setImage(myImage);
    }
}
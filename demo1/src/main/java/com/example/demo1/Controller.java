package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.demo1.Main.*;

public class Controller {
    @FXML
    ImageView myImageView = new ImageView("file:src\\main\\resources\\Image\\beemo.png");
    @FXML
    public Label myLabel;
    @FXML
    public TextField myTextField;
    @FXML
    public Button myButton;

    String sc;

    /**
     * Renvoie un String. -> input de myTextField.
     * Prend en paramètre:
     * Un event -> ENTER.
     * @param event
     * @return
     */
    @FXML
    public String handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            sc = myTextField.getText();
            System.out.println(sc);
            return sc;
        }
        return sc;
    }
    
    public void submit(ActionEvent event) {
        try {
            myLabel.setText("hello");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void typeAChampionName(ActionEvent e) throws FileNotFoundException {
        ArrayList<Champion> championsReadFromFile;
        championsReadFromFile = readChampFromFile("src\\main\\java\\com\\example\\demo1\\champText.txt");
        ArrayList<String> champNameList = champNameListString(championsReadFromFile);

        Champion aatrox = championsReadFromFile.get(0);
        Champion ahri = championsReadFromFile.get(1);
        Champion akali = championsReadFromFile.get(2);
        Champion akshan = championsReadFromFile.get(3);


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
package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image iconImage = new Image("file:src\\beemo.png");
        stage.getIcons().add(iconImage);

        stage.setTitle("Lol guesser");
        stage.setScene(scene);
        stage.show();
    }

    private static Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);

        /*ArrayList<Champion> championsReadFromFile = new ArrayList<Champion>();
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
        }*/
        System.out.println("finito");
    }
    //similitudes((scFindObject(isInTheList(champNameList), championsReadFromFile)), getRandomItem(championsReadFromFile));

    public static ArrayList<Champion> readChampFromFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner s = new Scanner(file);

        ArrayList<Champion> champList = new ArrayList<Champion>();

        while (s.hasNextLine()) {
            String line = s.nextLine();

            String[] items = line.split(" ");

            String name = items[0];
            String gender = items[1];
            String position = items[2];

            Champion newChampion = new Champion(name, gender, position);
            champList.add(newChampion);
        }
        return champList;
    }

    public static Champion scFindObject(String name, ArrayList<Champion> theList) {

        for (int index = 0; index < theList.size(); index++) {
            if (name.equals(theList.get(index).getName())) {
                // System.out.println(theList.get(index).getGender());
                return theList.get(index);
            }
        }
        return theList.get(0);
    }

    public static ArrayList<String> champNameListString(ArrayList<Champion> theList) {

        ArrayList<String> newList = new ArrayList<String>();

        for (int index = 0; index < theList.size(); index++) {
            newList.add(theList.get(index).getName());
        }
        return newList;
    }

    public static String isInTheList(ArrayList<String> theList) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Type a champion name... ");
        String input = sc.nextLine();

        while (!(theList.contains(input))) {
            System.out.print("Type a valid champion name... ");
            input = sc.nextLine();
        }
        return input;
    }

    static Champion getRandomItem(ArrayList<Champion> theList) {
        int index = ThreadLocalRandom.current().nextInt(theList.size());
        // System.out.println(index + " " + theList.get(index).getName());
        return theList.get(index);
    }

    public static boolean winCondition(Champion actualChampion, Champion guessChampion) {
        if ((actualChampion.getName()).equals(guessChampion.getName())) {
            return true;
        }
        return false;
    }

    public static void similitudes(Champion actualChampion, Champion guessChampion) {
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
    }
}


package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("myDisplay.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image iconImage = new Image("file:src\\main\\resources\\Image\\beemo.png");
        stage.getIcons().add(iconImage);

        stage.setResizable(false);
        stage.setTitle("Lol guessR");
        stage.setScene(scene);
        stage.show();
    }

    private static Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        Application.launch(args);

       // System.out.println("finito");
    }

    /**
     * renvoie la liste des Champions sous forme de arraylist de Champion.
     * Prend en paramètre:
     * String fileName -> le fichier texte qui va être lu contenant les caractéristiques des champions.
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
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

    /**
     * utilisé pour connecter le scanner à mon arraylist<Champion> pour renvoyer le scanner sous forme de Champion.
     * prend en paramètre:
     * String name -> l'input String.
     * ArrayList de Champion theList -> l'arrayList de readChampFromFile(String fileName).
     * @param name
     * @param theList
     * @return
     * */
    public static Champion scFindObject(String name, ArrayList<Champion> theList) {

        for (int index = 0; index < theList.size(); index++) {
            if (name.equals(theList.get(index).getName())) {
                // System.out.println(theList.get(index).getGender());
                return theList.get(index);
            }
        }
        return theList.get(0);
    }

    /**
     * Renvoie une ArrayList de String contenant les noms des champions.
     * Sert à comparer le scanner et tous les éléments de cette ArrayList de String pour savoir si le scanner est un
     * champion valide. -> fonction isInTheList(ArrayList String theList).
     * Prend en paramètre:
     * ArrayList de Champion theList ->  l'arrayList de readChampFromFile(String fileName).
     * @param theList
     * @return
     */
    public static ArrayList<String> champNameListString(ArrayList<Champion> theList) {

        ArrayList<String> newList = new ArrayList<String>();

        for (int index = 0; index < theList.size(); index++) {
            newList.add(theList.get(index).getName());
        }
        return newList;
    }

    // ANCIENNE VERSION DE ISINTHELIST AVEC LE SCANNER DANS LE SHELL. NOUVELLE VERSION AVEC FXML DANS CONTROLLER.
    public static String isInTheList(ArrayList<String> theList) {

        Scanner sc = new Scanner(System.in);
        //System.out.print("Type a champion name... ");
        String input = sc.nextLine();

        while (!(theList.contains(input))) {
            //System.out.print("Type a valid champion name... ");
            input = sc.nextLine();
        }
        return input;
    }

    /**
     * Renvoie un objet Champion au HASARD.
     * Prend en paramètre:
     * ArrayList de Champion theList -> arrayList lu par readChampFromFile(String fileName).
     * @param theList
     * @return
     */
    static Champion getRandomItem(ArrayList<Champion> theList) {
        int index = ThreadLocalRandom.current().nextInt(theList.size());
        // System.out.println(index + " " + theList.get(index).getName());
        return theList.get(index);
    }

    /**
     * Renvoie un boolean.
     * Prend en paramètre:
     * Un object Champion -> le scanner renvoyé par isInTheList(ArrayList String theList).
     * scanner - isInTheList - champNameListString - readChampFromFile.
     * Un object Champion guessChampion -> prit au hasard par la fonction getRandimItem.
     * @param actualChampion
     * @param guessChampion
     * @return
     */
    public static boolean winCondition(Champion actualChampion, Champion guessChampion) {
        if ((actualChampion.getName()).equals(guessChampion.getName())) {
            return true;
        }
        return false;
    }

    /**
     * Renvoie rien
     * Affiche si oui ou non le champion choisis possède des similitudes avec le champions à deviner.
     * Prend en paramètre:
     * Un object Champion actualChampion -> scFindObject.
     * Un object Champion guessChampion -> getRandomItem.
     * @param actualChampion
     * @param guessChampion
     */
   /* public static void similitudes(Champion actualChampion, Champion guessChampion) {
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
    }*/
}


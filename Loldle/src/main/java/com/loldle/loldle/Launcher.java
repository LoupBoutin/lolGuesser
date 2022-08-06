package com.loldle.loldle;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws IOException {
        //Display display = new Display(800,600);
        ArrayList<Champion> championsReadFromFile;
        championsReadFromFile = readChampFromFile("src\\main\\java\\com\\loldle\\loldle\\champText.txt");
        //System.out.println(championsReadFromFile);
        isInTheList(champNameListString(championsReadFromFile));

        /*Scanner sc = new Scanner(System.in);
        System.out.print("type ");
        String input = sc.nextLine();
        String hello = "hello";
        ArrayList<String> hey = new ArrayList<String>();
        hey.add("hello");
        hey.add("uwu");
        System.out.println(hey);
        System.out.println(hey.contains(input));*/

        //System.out.println(champNameListString(championsReadFromFile));
        //System.out.println(champNameListString(championsReadFromFile).contains("akali"));
    }

    public static ArrayList<Champion> readChampFromFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner s = new Scanner(file);

        ArrayList<Champion> champList = new ArrayList<Champion>();

        while (s.hasNextLine()) {
            String line = s.nextLine();

            String[] items = line.split(" ");
            /*System.out.println(items[0]);
            System.out.println(items[1]);
            System.out.println(items[2]);*/

            String name = items[0];
            String gender = items[1];
            String position = items[2];

            Champion newChampion = new Champion(name, gender, position);
            champList.add(newChampion);
        }
        return champList;
    }
    public static ArrayList<String> champNameListString(ArrayList<Champion> theList) {

        ArrayList<String> newList = new ArrayList<String>();

        for (int index = 0; index < theList.size(); index++) {
            newList.add(theList.get(index).getName());
        }
        return newList;
    }
    public static boolean isInTheList(ArrayList<String> theList) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Type a champion name... ");
        String input = sc.nextLine();

        while (!(theList.contains(input))) {
            System.out.print("Type a valid champion name... ");
            input = sc.nextLine();
        }

        return true;
    }
}
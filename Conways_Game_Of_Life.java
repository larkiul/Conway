/** 
 * John Conway's Game of Life is a cellular automaton created by John Conway. 
 * It requires no players as it evolves after each tick meaning each state is determined 
 * by its intial state.
 * 
 * Ultan Larkin
 * 23/10/23
 */

import java.util.ArrayList; //Array lists
import java.util.Scanner; //Keyboard input
import java.io.IOException; // handle errors
import java.io.File;  //File handles
import java.io.FileWriter; //External file editing
import java.util.Objects; //Methods for operating on objects

public class Conways_Game_Of_Life
{
    //Constants
    final int SIZE = 21;
    
    //Variables
    private int xCoordinate;
    private int yCoordinate;
    private int z = 1;
    private char table[][] = new char[SIZE][SIZE];
    private int generations;
    private int units;
    ArrayList<Integer> unitBirth = new ArrayList<Integer>();
    ArrayList<Integer> unitDeath = new ArrayList<Integer>();
    Scanner keyboard;

    public Conways_Game_Of_Life() {
        System.out.print('\u000C'); //Clears terminal at method call
        for (int y = 0; y < SIZE - 1; y++){ //Sets every cell as dead at the start
            for (int x = 0; x < SIZE - 1; x++){
                table[y][x] = '□';
            }
        }
        keyboard = new Scanner (System.in); //Creates new scanner 'keyboard'
        System.out.println("Welcome to Conway's Game of Life!");
        System.out.println("Would you like to load a CSV file? (yes / no)");
        String loadCSV = keyboard.nextLine();
        if (Objects.equals(loadCSV, "yes")){
            selectFile(); //Displays existing files, loads selected file
        } else if (Objects.equals(loadCSV, "no")){
            placeCells(); //Manual placement of cells
            System.out.println("Would you like to save this as a file? (yes / no)");
            String saveFile = keyboard.next();
            if (Objects.equals(saveFile, "yes")) {
                createFile(); //Saves current setup as a new CSV file
            } else if (Objects.equals(saveFile, "no")){
            } else {
                invalidAnswer(); //Error message if program doesn't understand answer
            }
        } else {
            invalidAnswer(); //Error message if program doesn't understand answer
        }
        z = 1;
        System.out.println("How many generations?");
        try { //Making sure the user enters a valid answer
            generations = keyboard.nextInt();
            while (generations <= 0 || generations > 100) {
                if (generations <= 0) {
                    System.out.println("Please enter a number greater than 0");
                    generations = keyboard.nextInt();
                }
                if (generations > 100) {
                    System.out.println("That number is too high (max 100)");
                    generations = keyboard.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Please make sure your answer is a positive number below 100");
            System.out.println("Please reload the program");
            System.exit(0);
        }
        for (int i = 1; i <= generations; i++) {
            System.out.println("Gen " + i);
            drawTable(); //Draws a table at each new generation
            nextGen(); //Updates status of each cell after each generation
        }
    }
    
    public void selectFile() { //Displays existing files, loads selected file
        System.out.println("What is the name of the file? (Exclude '.csv' from your answer)");
        System.out.println("Avaliable files:");
        File fileList = new File("c:");
        String[] files = fileList.list();
        for (int i = 0; i < files.length; i++){ //Displays all CSV files in directory
            String fileFound = files[i];
            if (fileFound.contains(".csv")){
                System.out.println(files[i]);
            }
        }
        String fileName = keyboard.nextLine();
        try { //Scans selected file for coordinates
            if (fileName.contains(".csv")){
                System.out.println("Make sure your answer does not contain '.csv'");
            }
            File file = new File(fileName + ".csv");
            System.out.println(file);
            Scanner readTheFile = new Scanner(file);
            readTheFile.useDelimiter(",");
            while (readTheFile.hasNext()){ //Places cells from CSV file
                int x = readTheFile.nextInt();
                int y = readTheFile.nextInt();
                table[y][x] = '■';
            }
        } catch(IOException e) {
            System.out.println("File not found");
            System.out.println("Please reload the program");
            System.exit(0);
        }
    }
    
    public void placeCells() { //Manual placement of cells
        System.out.println("How many cells would you like to place?");
        try { //Making sure the user enters a valid answer
            units = keyboard.nextInt();
            while (units <= 0 || units > 360) {
                if (units <= 0) {
                    System.out.println("Please enter a number greater than 0");
                    units = keyboard.nextInt();
                }
                if (units > 400) {
                    System.out.println("Please enter a number less than 360");
                    units = keyboard.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Please make sure your answer is a positive number below 360");
            System.out.println("Please reload the program");
            System.exit(0);
        }
        while (z <= units){ //Asks user where to place new cells
            System.out.println("Enter coordinates to place a unit");
            System.out.println("X coordinate:");
            try {
                xCoordinate = keyboard.nextInt();
                while (xCoordinate <= 0 || xCoordinate > 19) {
                    System.out.println("Please enter a number from 1 to 19");
                    xCoordinate = keyboard.nextInt();
                }
            } catch (Exception e) {
                System.out.println("Please make sure your answer is a positive number from 1 to 19");
                System.out.println("Please reload the program");
                System.exit(0);
            }
            System.out.println("Y coordinate:");
            try {
                yCoordinate = keyboard.nextInt();
                while (yCoordinate <= 0 || yCoordinate > 19) {
                    System.out.println("Please enter a number from 1 to 19");
                    yCoordinate = keyboard.nextInt();
                }
            } catch (Exception e) {
                System.out.println("Please make sure your answer is a positive number from 1 to 19");
                System.out.println("Please reload the program");
                System.exit(0);
            }

            drawTable(); //Updates cells accordingly

            z++;
        }
    }

    public void createFile() { //Saves current setup as a new CSV file
        System.out.println("Choose a name for this file");
        String fileName = keyboard.next();
        try {
            File newFile = new File(fileName + ".csv");
            if (newFile.createNewFile()) {
                System.out.println("New file created: " + newFile.getName());
                FileWriter writer = new FileWriter(fileName + ".csv");
                for (int y = 1; y < SIZE - 1; y++){ //Writes living cells into new file
                    for (int x = 1; x < SIZE - 1; x++){
                        if (table[y][x] == '■'){
                            writer.write(x + ",");
                            writer.write(y + ",");
                        }
                    }
                }
                writer.flush();
                writer.close();
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void drawTable() { //Draws a table at each new generation
        for (int y = 1; y < SIZE - 1; y++){
            for (int x = 1; x < SIZE - 1; x++) {
                for (int i = 1; i < generations; i++) { //Checks which cells should die and which should be born
                    int count = 0;
                    if (table[y + 1][x + 1] == '■') {
                        count++;
                    }
                    if (table[y][x + 1] == '■') {
                        count++;
                    }
                    if (table[y + 1][x] == '■') {
                        count++;
                    }
                    if (table[y - 1][x + 1] == '■') {
                        count++;
                    }
                    if (table[y + 1][x - 1] == '■') {
                        count++;
                    }
                    if (table[y - 1][x - 1] == '■') {
                        count++;
                    }
                    if (table[y][x - 1] == '■') {
                        count++;
                    }
                    if (table[y - 1][x] == '■') {
                        count++;
                    }
                    if (table[y][x] == '■'){
                        if (count < 2 || count > 3) {
                            unitDeath.add(x);
                            unitDeath.add(y);
                        }
                    }
                    if (table[y][x] == '□'){
                        if (count == 3) {
                            unitBirth.add(x);
                            unitBirth.add(y);
                        }
                    }
                    yCoordinate = 0;
                    xCoordinate = 0;
                }
                if (x != xCoordinate || y != yCoordinate) { //Shows user updated table when new cells are placed
                    System.out.print(table[y][x] + " ");
                }
                else {
                    table[y][x] = '■';
                    System.out.print(table[y][x] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public void nextGen() { //Updates status of each cell after each generation
        while (unitDeath.size() > 0){ //Upates cells that die
                table[unitDeath.get(1)][unitDeath.get(0)] = '□';
                unitDeath.remove(0);
                unitDeath.remove(0);
            }
        while (unitBirth.size() > 0) { //Updates cells that are born
            table[unitBirth.get(1)][unitBirth.get(0)] = '■';
            unitBirth.remove(0);
            unitBirth.remove(0);
        }
        try { //Adds a delay between every generation for a smoother view
            Thread.sleep((long) (300));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void invalidAnswer() { //Error message if program doesn't understand answer
        System.out.println("Sorry, that is not a valid answer");
        System.out.println("Please reload the program");
        System.exit(0); //Executes program
    }
}

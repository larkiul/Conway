  /**
 * Write a description of class Conways_Game_Of_Life here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList; 
import java.util.Scanner; //Keyboard input
public class Conways_Game_Of_Life
{
    // instance variables - replace the example below with your own
    /*public static void main(String[] args) {
        Conways_Game_Of_Life game = new Conways_Game_Of_Life(new Scanner(kb));
    }*/

    
    private int xCoordinate;

    private int yCoordinate;

    private int size = 21;

    private int z;
    private char table[][] = new char[size][size];
    Scanner keyboard;
    
    private int generations;
    private int units;

    ArrayList<Integer> unitBirth = new ArrayList<Integer>();
    ArrayList<Integer> unitDeath = new ArrayList<Integer>();
    //private int count;


    /**
     * Constructor for objects of class Conways_Game_Of_Life
     */

    public Conways_Game_Of_Life()
    {
        // initialise instance variables
        keyboard = new Scanner (System.in);

        z = 1;
        
        
        

        System.out.println("Welcome to Conway's Game of Life!");
        System.out.println("How many units would you like to place?");
        units = keyboard.nextInt();


        for (int y = 0; y < size - 1; y++){
            for (int x = 0; x < size - 1; x++){
                table[y][x] = '□';
            }
        }
        while (z <= units){

            System.out.println("Enter coordinates to place a unit");
            System.out.println("X coordinate:");
            xCoordinate = keyboard.nextInt();
            System.out.println("Y coordinate:");
            yCoordinate = keyboard.nextInt();

            drawTable();

            z++;
        }
        System.out.println("How many generations?");
        generations = keyboard.nextInt();
        z = 1;
        for (int c = 1; c < generations; c++) {
            
            System.out.println("Gen " + c);
            drawTable();
            //c++;
            
            while (unitDeath.size() > 0){
                table[unitDeath.get(1)][unitDeath.get(0)] = '□';
                unitDeath.remove(0);
                unitDeath.remove(0);
            }
            while (unitBirth.size() > 0) {
                table[unitBirth.get(1)][unitBirth.get(0)] = '■';
                unitBirth.remove(0);
                unitBirth.remove(0);
            }
        }

    }

    public void drawTable(){

        for (int y = 1; y < size - 1; y++){

            for (int x = 1; x < size - 1; x++) {
                
                for (int c = 1; c < generations; c++) {
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
                
                if (x != xCoordinate || y != yCoordinate) {

                    System.out.print(table[y][x] + " ");
                }
                else{

                    table[y][x] = '■';
                    System.out.print(table[y][x] + " ");

                }
            }
            System.out.println();
        }
    }
}

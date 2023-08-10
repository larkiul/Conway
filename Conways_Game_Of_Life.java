package Conway; /**
 * Write a description of class Conways_Game_Of_Life here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner; //Keyboard input
public class Conways_Game_Of_Life
{
    // instance variables - replace the example below with your own
    private int xCoordinate;

    private int yCoordinate;

    private int size = 21;

    private int z;
    private String table[][] = new String[size][size];
    Scanner keyboard;
    
    private int generations;
    private int units;

    private int unitBirth;
    private int unitDeat;
    private int count = 0;


    /**
     * Constructor for objects of class Conways_Game_Of_Life
     */

    public Conways_Game_Of_Life(Scanner kb)
    {
        // initialise instance variables
        z = 1;
        keyboard = kb;

        System.out.println("Welcome to Conway's Game of Life!");
        System.out.println("How many units would you like to place?");
        units = keyboard.nextInt();


        for (int y = 0; y < size - 1; y++){
            for (int x = 0; x < size - 1; x++){
                table[y][x] = " □";
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
        while (z <= generations){

            System.out.println("Gen " + z);
            drawTable();
            z++;
        }
        System.out.println(count);
    }

    public void drawTable(){

        for (int y = 0; y < size - 1; y++){

            for (int x = 0; x < size - 1; x++){

                if (z <= generations){

                    if (table[y + 1][x + 1] == "■"
                        || table[y][x + 1] == "■"
                        || table[y + 1][x] == "■"
                        || table[y - 1][x - 1] == "■"
                        || table[y - 1][x] == "■"
                        || table[y][x - 1] == "■"
                        || table[y - 1][x + 1] == "■"
                        || table[y + 1][x - 1] == "■"){
                        count++;
                        System.out.println(count);
                    }
                }
                if (x != xCoordinate - 1 || y != yCoordinate - 1) {

                    System.out.print(table[y][x] + " ");
                }
                else{

                    table[y][x] = " ■";
                    System.out.print(table[y][x] + " ");

                }
            }
            System.out.println();
        }

    }
}

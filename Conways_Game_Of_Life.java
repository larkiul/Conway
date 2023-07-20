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

    private int z;
    private int dimension = 20;
    private String table[][] = new String[dimension][dimension];  
    Scanner keyboard;
    
    private int generations;
    private int units;

    private int unitBirth;
    private int unitDeath;
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
        System.out.println("How many generations?");
        generations = keyboard.nextInt();
        System.out.println("How many units would you like to place?");
        units = keyboard.nextInt();

        for (int y = 0; y < dimension; y++){
            for (int x = 0; x < dimension; x++){
                table[y][x] = " □";
            }
        }
        while (z <= units){

            System.out.println("Enter coordinates to place a unit");
            System.out.println("X coordinate:");
            xCoordinate = keyboard.nextInt();
            System.out.println("Y coordinate:");
            yCoordinate = keyboard.nextInt();
            /*bruno*/
            for (int y = 0; y < dimension; y++){

                for (int x = 0; x < dimension; x++){
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
            z++;
        }

        z = 1;
        while (z <= generations){


            System.out.println("Gen " + z);
            for (int y = 0; y < dimension; y++){

                for (int x = 0; x < dimension; x++){

                    if (x != xCoordinate - 1 || y != yCoordinate - 1) {

                        System.out.print(table[y][x] + " ");
                    }
                    else{
                        table[y][x] = " ■";
                        System.out.print(table[y][x] + " ");
                    }
                    if (table[y + 1][x] == "■"){
                        count++;
                    }

                }
                System.out.println();

            }
            z++;
        }
        System.out.println(count);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    /*public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }*/
}

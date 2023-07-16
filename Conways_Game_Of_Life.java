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
    private int x;

    private int y;

    private int z;
    private int dimension = 20;
    private String table[][] = new String[dimension][dimension];  
    Scanner keyboard;
    private int xAxis = 1;
    private int yAxis = 1;
    
    int generations;
    private int units;
    String start = new String("start");
    private boolean begin = false;

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

        for (int m = 0; m < dimension; m++){
            for (int n = 0; n < dimension; n++){
                table[m][n] = " □";
            }
        }
        while (z <= units){

            System.out.println("Enter coordinates to place a unit");
            System.out.println("X coordinate:");
            x = keyboard.nextInt();
            System.out.println("Y coordinate:");
            y = keyboard.nextInt();
            /*bruno*/
            for (int m = 0; m < dimension; m++){

                for (int n = 0; n < dimension; n++){
                    if (n != x - 1 || m != y - 1) {

                        System.out.print(table[m][n] + " ");
                    }
                    else{
                        table[m][n] = " ■";
                        System.out.print(table[m][n] + " ");
                    }

                }
                System.out.println();

            }
            z++;
        }

        z = 1;
        while (z <= generations){


            System.out.println("Gen " + z);
            for (int m = 0; m < dimension; m++){

                for (int n = 0; n < dimension; n++){
                    if (n != x - 1 || m != y - 1) {

                        System.out.print(table[m][n] + " ");
                    }
                    else{
                        table[m][n] = " ■";
                        System.out.print(table[m][n] + " ");
                    }

                }
                System.out.println();

            }
            z++;
        }
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

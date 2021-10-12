package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Luis Figueroa
 */

import java.util.*;
import java.io.*;

public class App42 {

    //function for printing the properly formatted results
    public void formattedResults(String exercise42)
    {
        //use try and catch and scan the input file
        try 
        {
            //finds the input file
            File outF = new File("src/main/java/ex42/exercise42_input.txt");
            Scanner scan = new Scanner(outF); //scans the input file contents

            //while loop to keep scanning the data until the next
            while (scan.hasNext())
            {
                //cans the input file
                String inF = scan.nextLine();
                //creates the temporals for the comas
                String[] temporalA = inF.split(",");
                //replaces the comas for the space
                System.out.printf("%-20s%-20s%-20s\n", temporalA[0], temporalA[1], temporalA[2]);
            }

        }
        //if something odd happens then use the exception
        catch (FileNotFoundException miss)
        {
            System.out.println(miss);;
        }
    }

    //main function
    public static void main(String[] args) 
    {
        //creates the list output
        App42 list = new App42();
        //prints the formatted list and header
        System.out.printf("%-20s%-20s%-20s\n", "Last", "First", "Salary");
        System.out.printf("----------------------------------------------\n");
        list.formattedResults("exercise42_input.txt");
    }
}

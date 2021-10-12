package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Luis Figueroa
*/

import java.util.*;
import java.io.*;

public class App45 {

    //main function
    public static void main(String[] args) throws IOException
    {
        //input file is located
        File inF = new File("src/main/java/ex45/exercise45_input.txt");
        //scan the input file
        Scanner scan = new Scanner(inF);
        //scans the user input
        Scanner scanUser = new Scanner(System.in);

        //prompts the user for input
        System.out.print("Please input the name of the output file: ");
        String outF = scanUser.next();

        //generates the outfile
        FileWriter generate = new FileWriter(outF);

        try //use try to print function to generate the output file
        {
            //while loop to keep scanning the data until the next
            while(scan.hasNext())
            {
                String uInput = scan.nextLine();//scans the line
                uInput = uInput.replaceAll("utilize", "use"); //replaces the prompted
                generate.write(uInput); //generates the output File
                generate.write("\n");
            }
        }

        finally //for clean up code
        {
            scan.close(); //closes the scan to avoid memory leaks
        }
        generate.close(); //closes the generated file to avoid memory leak
        System.out.print("output file generated.");
    }
}

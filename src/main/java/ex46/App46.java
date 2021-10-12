package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Luis Figueroa
 */

import java.util.*;
import java.io.*;

public class App46 {

    //main function
    public static void main(String array[]) throws IOException
    {
        //the input file is canned and mapped
        Scanner inF = new Scanner(new File("src/main/java/ex46/exercise46_input.txt"));
        //the tree map stores the key value pairs
        Map <String,Integer> hashMap = new TreeMap <String,Integer> ();

        //while loop to keep scanning the data until the next
        while(inF.hasNext())
        {
            //the input is set to the infile
            String input = inF.next();
            //if the hashMap contains the key assigned
            if (hashMap.containsKey(input))
            {
                hashMap.put(input, hashMap.get(input) + 1); //add 1 to the counter
            }
            else
            {
                hashMap.put(input, 1); //dont add anything
            }
        }

        //for loop that generates the histogram
        for(String key:hashMap.keySet())
        {
            System.out.printf("%-12s",key+":");//formats the histogram

            //for loop for printing the "*" in the histogram
            for(int temp = hashMap.get(key); temp > 0; temp--)
                System.out.print("*"); //prints the symbol
                System.out.print("\n"); //prints a new line after the *s
        }
    }
}

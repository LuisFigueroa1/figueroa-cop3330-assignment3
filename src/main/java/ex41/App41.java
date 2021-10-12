package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Luis Figueroa
 */

import java.util.*;
import java.io.*;

public class App41 {

        //public function for scanning the names
        public static void nameScan(Scanner scan, ArrayList<String> nameList)
        {
            //while loop to keep scanning the data until the next line
            while (scan.hasNextLine()) {
                //adds the line that was read in the loop
                nameList.add(scan.nextLine());
            }
        }

        //public function for printing the list
        public static void printList(ArrayList<String> nameList) throws IOException
        {
            //FileWriter for creating the output.txt
            FileWriter outF = new FileWriter("exercise41_output.txt");

            //prints the format of the output list
            outF.write("Total of" + " " + nameList.size() + " " + "names\n");
            outF.write("-----------------\n");

            //for loop for printing the actual list
            for (String i : nameList) {
                //writes the element and a new line
                outF.write(i + "\n");
            }
            outF.close(); //closes the output.txt
        }

        //public main function
        public static void main(String[] args) throws FileNotFoundException
        {
            //scans for the input.txt
            Scanner inF = new Scanner(new File("src/main/java/ex41/exercise41_input.txt"));
            //this array stores the the names in the list
            ArrayList<String> nameList = new ArrayList<String>();
            //scans the contents of the input file
            nameScan(inF, nameList);
            //finally I used the sort function collections.sort to sort the contents of the input.txt
            Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
            inF.close(); //close the output.txt

            //use try and catch and the print function to generate the output file
            try
            {
                printList(nameList); //uses the print function
            }
            //if something odd happens then use the exception
            catch (Exception miss)
            {
                System.out.println(miss);
            }
        }
   }

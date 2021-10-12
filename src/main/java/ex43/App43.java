package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Luis Figueroa
 */

import java.util.*;
import java.io.*;

public class App43 {

    public static void main(String[] args)
    {
        //get String names
        Scanner scan = new Scanner(System.in);
        String path;
        String nameOfSite;
        String author;


        //initialize JavaScript and CSS
        char JavaScript = 'N';
        char CSS = 'N';

        //prints the prompts for the user and
        //scans the user input

        System.out.print("Site name: ");
        nameOfSite = scan.nextLine();

        System.out.print("Author: ");
        author = scan.nextLine();

        System.out.print("Do you want a folder for JavaScript?(y/n) ");
        JavaScript = scan.next().charAt(0);

        System.out.print("Do you want a folder for CSS?(y/n) ");
        CSS = scan.next().charAt(0);

        //path and we use getProperty to get the user directory
        path = System.getProperty("user.dir");
        path += "\\"+ nameOfSite;
        //file for site
        File site = new File(path);

        //boolean operator for site directory
        boolean createSite = site.mkdir();

        //start of the if loop
        if(createSite)
        {
            //prints the path
            System.out.print("Created " + path + "\n");

            try //try start of the skeleton website
            {
                FileWriter siteSkeleton = new FileWriter(new File(path + "\\index.html"));
                siteSkeleton.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                siteSkeleton.write("\t<meta author=\"" + author + "\">\n");
                siteSkeleton.write("\t<title>" + nameOfSite + "</title>\n");
                siteSkeleton.write("</head>\n<body>\n\n</body>\n</html>");

                //close the skeleton file to avoid memory leak
                siteSkeleton.close();

                System.out.print("Created " + path + "\\index.html" + "\n");

                //if uses capital and not capital letters
                if(JavaScript == 'Y' || JavaScript == 'y')
                {
                    File FolderJavaScript = new File(path+"\\JavaScript");
                    boolean generateJavaScript = FolderJavaScript.mkdir();

                    if(generateJavaScript) //generates the javascript folder
                    {
                        System.out.println("Created " + FolderJavaScript+"\\");
                    }
                    else //doesn't generate the javascript folder
                    {
                        System.out.println("JavaScript folder not generated.");
                    }
                }

                //if uses capital and not capital letters
                if(CSS == 'Y' || CSS == 'y')
                {
                    File FolderCCS = new File(path+"\\CSS");
                    boolean generateCCS = FolderCCS.mkdir();

                    if(generateCCS) //generates the CCS folder
                    {
                        System.out.println("Created " + FolderCCS+"\\");
                    }
                    else //doesn't generate CCS folder
                    {
                        System.out.println("CSS folder not generated.");
                    }
                }
            }
            catch(IOException miss) //doesn't generate the index
            {
                System.out.println("index not generated.");
            }
        }
        else //doesn't generate any website folder
        {
            System.out.println("Website folder not generated.");
        }
        scan.close();
    }

}

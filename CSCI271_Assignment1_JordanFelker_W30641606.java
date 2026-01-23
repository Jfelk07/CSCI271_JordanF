/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Jordan Felker
* OS: Ubuntu Debian Linux 21.1
* Compiler: javac 25.0.1
* Date: January 22, 2016
*
* Purpose
* This program reads a list of scores from an input file, counts how many
* scores there are in the list, and computes their sum and average.
*
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Jordan Felker>
* <40641606>
********************************************************************/


import java.util.Scanner;

public class CSCI271_Assignment1_JordanFelker_W30641606 {
    /*<Function Name>**
Description: Calculates a CSCI 271 student's grade by prompting them for input of their 7 
* assignments and tests scores one by one then calculates the average of them. Then asks
* the student for their midterm and final exam grades. Depending on their answer their grade is
* calculated based on the rules provided in the syllabus and prints all 4 category of grades
*
*
*
Parameters: takes input at the command line from the user by using the scanner class.
*
Pre: User needs to enter numerical values for their grade or else it wont work because 
* I didn't write any if else statements to handle the exception (were lazy around here)
* Scores need to be within the grading range to be accurate, if the user enters something over 
* the range it will still work however it wouldn't be accurate. 
*
*
Post: if the pre condtions are true the 4 grade categories are calculated correctly and returned
* back to the user and the scanner is closed to prevent memory leaks.
*
Returns: nothing is returned other than printing the final grades
*
Called: 
Calls: Scanner.nextDouble() SOURCE : w3schools.com this method lets you read the next double 
*                                   number in a string.
*      System.out.print() SOURCE : Page 6 Week 1 Friday Practice slides
*                                   System out print is Java's equivalent of Cout/Cin 
*      Scanner.close() SOURCE : Week 2 Examples Input example
*                                Just closes the scanner since were done
*
*        
*
*
**/
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        // open the scanner
            double sumAssignments = 0.0;
        System.out.println("Please enter your 7 assignment scores (0-100 only):");
        for (int i = 1; i <= 7; i++) {
            System.out.print("Assignment " + i + ": ");
            sumAssignments += myScanner.nextDouble();
        }
            double A = sumAssignments / 7.0; // average of assignments

            double sumTests = 0.0;
        System.out.println("\nPlease enter your 7 test scores (0-100 only):");
        for (int i = 1; i <= 7; i++) {
            System.out.print("Test " + i + ": ");
            sumTests += myScanner.nextDouble();
        }
            double T = sumTests / 7.0; // average of tests

        System.out.print("\nPlease enter your midterm score (0-100 only): ");
            double M = myScanner.nextDouble();

        System.out.print("Please enter your final exam score (0-100 only): ");
            double F = myScanner.nextDouble();

            double E = ((0.4 * F + 0.2 * M + 0.1 * T) / 0.7); 
        
        double G;
        if (E < 60.0) { // if the student gets less than 60 cap their final grade to 60
            G = E;
        } else if (E < 80.0) {
            double W = ((E - 60.0) / 20.0) * 0.3;
            G = (1.0 - W) * E + W * A;
        } else {
            G = 0.4 * F + 0.2 * M + 0.1 * T + 0.3 * A;
        }
        // output the results to user
        System.out.printf("A assignment avg: %.2f%n", A);
        System.out.printf("T test avg: %.2f%n", T);
        System.out.printf("E exams: %.2f%n", E);
        System.out.printf("G Final Grade: %.2f%n", G);

        // close the scanner
        myScanner.close();
    }
}
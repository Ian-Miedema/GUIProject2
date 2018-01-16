package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception  {
        // write your code here

        Calculations AreaOrVolume = new Calculations();

        Scanner sc = new Scanner(System.in);

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        boolean cont = true;
        String ans;
        //initialize variables needed for the main while

        boolean wrongQuadrant;
        //initialize variable to be used to check the domain values

        double gx;
        double d1;
        double d2;
        double a;                       //the slope of the linear equation, the a-value of the quadratic equation, and the vertical stretch/compression of the sine and cosine functions
        double b;                       //the vertical shift of the linear equation, the b-value of the quadratic equation, the horizontal stretch/compression of the sine and cosine functions
        double c;                       //the c-value of the quadratic equation and the horizontal translation of the sine and cosine functions
        double d;                       //the vertical translation of the sine and cosine functions
        double slice;
        double zero;
        EnumeratedType f;                  //allows the enumerated type to be used in the main class
        //initialize variables needed to for gathering user input

        int WIDTH = 500;
        int HEIGHT = 250;
        //initialize variables needed for the JFrame

        JFrame Intro = new JFrame("Calculations");
        Intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Intro.setDefaultLookAndFeelDecorated(true);
        //initialize frame

        String choice[] = {"Calculate Linear Area", "Calculate Quadratic Area", "Calculate Area of a Sine Function",
                "Calculate Area of a Cosine Function", "Calculate Volume of Rotation of a Linear Function"};

        JComboBox options = new JComboBox(choice);

        JLabel infoLabel1 = new JLabel("Do you want to calculate the area of a function or the volume of rotation of a function");
        JButton clickMe = new JButton("Submit");
        //initialize components for the frames

        Intro.setLayout(new FlowLayout());
        //initialize layout

        Intro.add(infoLabel1);
        Intro.add(options);
        Intro.add(clickMe);
        //adds labels to the frame

        Intro.setSize(WIDTH, HEIGHT);
        //sets the dimensions of the frame

        clickMe.addActionListener();

        Intro.setVisible(true);
        //sets frame to visible



        String input = "a";

        while (cont) {
            //while loop that continues until the user says that they want to stop



            if (input.equalsIgnoreCase("a")) {

                while (cont) {

                    System.out.println("Please enter the type of function you wish to use for your f(x) function\n" +
                            "The options are:\n" +
                            "1: Linear\n" +
                            "2: Quadratic\n" +
                            "3: Sine\n" +
                            "4: Cosine");
                    String Num = br.readLine();
                    //-------------------------------------------------------------------
                    //first asks which type of function the user wants and provides them options, then reads their answer
                    //

                    switch (Num){
                        case "1":
                            f = EnumeratedType.LINEAR;
                            break;
                        case "2":
                            f = EnumeratedType.QUADRATIC;
                            break;
                        case "3":
                            f = EnumeratedType.SINE;
                            break;
                        case "4":
                            f = EnumeratedType.COSINE;
                            break;
                        default:
                            f = EnumeratedType.INVALID;
                            break;
                    }
                    //changes the number answer to the enumerated

                    switch (f) {
                        case LINEAR:

                            System.out.println("For the equation f(x) = mx + b");

                            System.out.println("Please enter the slope (m value) of the f(x) function");
                            a = sc.nextDouble();
                            //------------------------------------------------------------
                            //The block above asks for and then sets the slope of the function based on user input
                            //

                            System.out.println("Please enter the vertical shift (b value) of the f(x) function");
                            b = sc.nextDouble();
                            //------------------------------------------------------------
                            //The block above asks for and then sets the vertical shift of the function based on user input
                            //

                            System.out.println("Please enter the domain of which the area should be calculated.\nthe lower domain: ");
                            d1 = sc.nextDouble();
                            System.out.println("the upper domain: ");
                            d2 = sc.nextDouble();
                            if (d1 >= d2){
                                System.out.println("the lower domain must be a lower value than the upper domain");
                                break;
                            }
                            //------------------------------------------------------------
                            //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                            //

                            System.out.println("Please enter the value of the g(x) function");
                            gx = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the g(x) value based on user input
                            //

                            System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                            slice = sc.nextInt();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the number of iterations based on user input
                            //

                            AreaOrVolume.SetRestrictions(d1, d2, gx, slice);

                            System.out.println("Your f(x) equation is: f(x) = " + a + "x + " + b +
                                    " and your g(x) equation is: g(x) = " + gx);
                            System.out.println("The area between the two functions is " + AreaOrVolume.CalcAreaBetween(a, b) + " units squared");
                            //------------------------------------------------------------
                            //confirms the equation then states the area under the line between the domain
                            //

                            break;
                        case QUADRATIC:

                            System.out.println("For the equation y = a(x-h)^2 + c");

                            System.out.println("Please enter the a-value of the equation");
                            a = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the a-value based on user input
                            //

                            System.out.println("Please enter the h-value of the equation");
                            b = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the b-value based on user input
                            //

                            System.out.println("Please enter the c-value of the equation");
                            c = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the c-value based on user input
                            //

                            System.out.println("Please enter the domain of which the area should be calculated.\nthe lower value: ");
                            d1 = sc.nextDouble();
                            System.out.println("the upper value: ");
                            d2 = sc.nextDouble();
                            if (d1 >= d2){
                                System.out.println("the lower domain must be a lower value than the upper domain");
                                break;
                            }
                            //------------------------------------------------------------
                            //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                            //

                            System.out.println("Please enter the value of the g(x) function");
                            gx = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the g(x) value based on user input
                            //

                            System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                            slice = sc.nextInt();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the number of iterations based on user input
                            //

                            AreaOrVolume.SetRestrictions(d1, d2, gx, slice);

                            System.out.println("Your f(x) equation is: f(x) = " + a + "x^2 + " + b + "x + " + c +
                                    " and your g(x) equation is: g(x) = " + gx);
                            System.out.println("The area between the two functions is " + AreaOrVolume.CalcAreaBetween(a, b, c) + " units squared");
                            //------------------------------------------------------------
                            //confirms the equation then states the area under the line between the domain
                            //

                            break;
                        case SINE:

                            System.out.println("For the equation y = a*sin(k(x-d)) + c");

                            System.out.println("Please enter the a-value of the equation");
                            a = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the a-value based on user input
                            //

                            System.out.println("Please enter the k-value of the equation");
                            b = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the b-value based on user input
                            //

                            System.out.println("Please enter the d-value of the equation");
                            c = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the c-value based on user input
                            //

                            System.out.println("Please enter the c-value of the equation");
                            d = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the c-value based on user input
                            //

                            System.out.println("Please enter the domain of which the area should be calculated.\nthe lower value: ");
                            d1 = sc.nextDouble();
                            System.out.println("the upper value: ");
                            d2 = sc.nextDouble();
                            if (d1 >= d2){
                                System.out.println("the lower domain must be a lower value than the upper domain");
                                break;
                            }


                            //------------------------------------------------------------
                            //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                            //It then looks at if the user is using radians or degrees, if they are using degrees it sets the values of the domains and the d variable to radians
                            //

                            System.out.println("Please enter the value of the g(x) function");
                            gx = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the g(x) value based on user input
                            //

                            System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                            slice = sc.nextInt();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the number of iterations based on user input
                            //

                            AreaOrVolume.SetRestrictions(d1, d2, gx, slice);

                            System.out.println("Your f(x) equation is: f(x) = " + a + "x*sin(" + b + "(x - " + d + ") + " + c +
                                    " and your g(x) equation is: g(x) = " + gx);
                            System.out.println("The area under the function is " + AreaOrVolume.CalcAreaBetween(f, a, b, c, d) + " units squared");
                            //------------------------------------------------------------
                            //confirms the equation then states the area under the line between the domain
                            //

                            break;
                        case COSINE:

                            System.out.println("For the equation y = a*sin(k(x-d)) + c");

                            System.out.println("Please enter the a-value of the equation");
                            a = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the a-value based on user input
                            //

                            System.out.println("Please enter the k-value of the equation");
                            b = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the b-value based on user input
                            //

                            System.out.println("Please enter the d-value of the equation");
                            c = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the c-value based on user input
                            //

                            System.out.println("Please enter the c-value of the equation");
                            d = sc.nextDouble();
                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the c-value based on user input
                            //

                            System.out.println("Please enter the domain of which the area should be calculated.\nthe lower value: ");
                            d1 = sc.nextDouble();
                            System.out.println("the upper value: ");
                            d2 = sc.nextDouble();
                            if (d1 >= d2){
                                System.out.println("the lower domain must be a lower value than the upper domain");
                                break;
                            }



                            //------------------------------------------------------------
                            //The block above asks for and then sets the two values of the domain based on user input and makes sure they are in the proper sequence
                            //It then looks at if the user is using radians or degrees, if they are using degrees it sets the values of the domains and the d variable to radians
                            //

                            System.out.println("Please enter the value of the g(x) function");
                            gx = sc.nextDouble();

                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the g(x) value based on user input
                            //

                            System.out.println("Please enter the number of iterations you want; the larger the value, the more accurate the calculation");
                            slice = sc.nextInt();

                            //-------------------------------------------------------------------
                            //The block above asks for and then sets the number of iterations based on user input
                            //

                            AreaOrVolume.SetRestrictions(d1, d2, gx, slice);

                            System.out.println("Your f(x) equation is: f(x) = " + a + "x*sin(" + b + "(x - " + d + ") + " + c +
                                    " and your g(x) equation is: g(x) = " + gx);
                            System.out.println("The area under the function is " + AreaOrVolume.CalcAreaBetween(f, a, b, c, d) + " units squared");
                            //------------------------------------------------------------
                            //confirms the equation then states the area under the line between the domain
                            //

                            break;
                        case INVALID:
                            System.out.println("Error, number chosen is not an option");
                            break;
                        // The default deals with all options aside from the ones given. It tells the user that their choice is invalid then breaks
                    }// end of switch

                    System.out.println("Do you want to continue?");
                    //asks if the user wishes to go through the program again

                    ans = br.readLine();
                    //gets the users answer

                    if (ans.equalsIgnoreCase("no")){
                        cont = false;
                        //checks to see if the user said to stop
                    }// end of if

                    AreaOrVolume.resetData();

                }// end of while

            }//end of if statement\

            else if (input.equalsIgnoreCase("v")){

                do {

                    JOptionPane.showMessageDialog(null, "This program calculates the volume of rotation of a linear function" +
                            " bound in the first quadrant");

                    input = JOptionPane.showInputDialog(null, "For the function f(x) = mx + b, please enter the m value");

                    a = Double.parseDouble(input);
                    //collects user input for the slope of the linear function

                    //------------------------------------------------------------------------------------------------------
                    input = JOptionPane.showInputDialog(null, "For the function f(x) = mx + b, please enter the b value");
                    b = Double.parseDouble(input);
                    //collects user input for the vertical shift of the linear function

                } while (a <= 0 && b <= 0);
                //This block of code below makes sure that if the slope is negative then the vertical shift is not negative
                //a negative slope and vertical shift would result in a function that completely misses the first quadrant

                //end do while loop


                //----------------------------------------------------------------------------------------------------------
                if (a != 0) {
                    zero = -b / a;
                    //finds the zero (where of the equation if the slope is not zero

                    if (a < 0) {
                        System.out.println("Please have your domains less than or equal to: " + zero);
                        //if the slope is negative then the domain values must be less than or equal to the zero
                    } else if (zero < 0) {
                        System.out.println("Please have your domains greater than or equal to: 0");
                        //otherwise if the zero is negative then the domain values must be greater than or equal to 0
                    } else {
                        System.out.println("Please have your domains greater than or equal to: " + zero);
                        //otherwise the domain values must be greater than or equal to zero

                    }//end of if statement

                } else {
                    zero = 0;
                    System.out.println("Please have your domains greater than or equal to: 0");
                    //if the slope is 0 then the domain values must be greater than or equal to 0

                }
                //This if statement determines if there are any restrictions on the domain based on the slope and v. shift

                //end of if statement


                //----------------------------------------------------------------------------------------------------------
                do {
                    System.out.println("Your domain must correspond to values in the first quadrant");
                    //a reminder to the user

                    //------------------------------------------------------------------------------------------------------
                    do {
                        System.out.println("Enter the lower domain value where the function is in the first quadrant");
                        d1 = sc.nextDouble();

                        System.out.println("Enter the higher domain value where the function is in the first quadrant");
                        d2 = sc.nextDouble();
                        //asks the user to input the domain values

                        wrongQuadrant = AreaOrVolume.Check(d1, d2);

                    } while (wrongQuadrant);
                    //uses a method from the other class to check if the domain values are acceptable
                    //if they aren't then re-asks the user for them until they enter proper values

                    //end of do while loop

                } while ((a < 0 && (d1 >= zero || d2 > zero)) || (b < 0 && (d1 < zero || d2 <= zero)));
                //this do while loop makes sure that the user followed the instructions pertaining to the domain values

                //end of do while loop


                //----------------------------------------------------------------------------------------------------------
                System.out.println("For the function g(x) please enter the value");
                gx = sc.nextDouble();
                //collects user input for the g(x) function

                //----------------------------------------------------------------------------------------------------------
                if (gx < 0) {
                    gx = 0;

                }//end of if statement

                //this if statement causes any negative values for the g(x) function to be equal to zero so that they don't skew

                //----------------------------------------------------------------------------------------------------------
                System.out.println("Enter the number of iterations you would like");
                slice = sc.nextDouble();
                //collects user input for the number of iterations required

                //----------------------------------------------------------------------------------------------------------
                AreaOrVolume.SetRestrictions(d1, d2, gx, slice);
                //sets these values in the CalculateVolume class

                //----------------------------------------------------------------------------------------------------------
                System.out.println("The volume of the function f(x) between " + d1 + " and " + d2 +
                        " with the function g(x) as a restriction is: ");
                //displays the calculated volume

                //----------------------------------------------------------------------------------------------------------
                System.out.println("Do you want to continue? (type 'no' to quit)");
                ans = br.readLine();
                //asks if the user wants to continue

                if (ans.equalsIgnoreCase("no")) {
                    cont = false;

                } else {
                    System.out.println("\n-------------------------------------------------------------------------------");

                }//end of if statement

                //if the user answers no then the main while loop breaks


                //----------------------------------------------------------------------------------------------------------
                AreaOrVolume.ResetVolume();
                //this resets the volume in the CalculateVolume class so that it does not add onto the previous calculation
            }

        }//end of while loop


    }
}

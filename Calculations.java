package com.company;

/**
 * Created by 55346mie on 12/01/2018.
 */
public class Calculations {

    //variables that define the f(x) equation
    private double a_value;                 //the slope of the linear equation, the a-value of the quadratic equation, and the vertical stretch/compression of the sine and cosine functions
    private double b_value;                 //the vertical shift of the linear equation, the b-value of the quadratic equation, the horizontal stretch/compression of the sine and cosine functions
    private double c_value;                 //the c-value of the quadratic equation and the horizontal translation of the sine and cosine functions
    private double d_value;                 //the vertical translation of the sine and cosine functions

    //variables that act as restrictions
    private double dom1;                    //the first domain
    private double dom2;                    //the second domain
    private double iterations;              //the variable used to gather the number of iterations wanted
    private double g;                       //the variable used for the g(x) function

    //variables used to calculate the area
    private double area;                    //the variable used to add all of the rectangles together and then return the area
    private double rect;                    //the variable used to calculate the area of each iteration
    private double height;                  //the variable used to calculate the height
    private double base;                    //the variable used to calculate the base
    private double volume;




    public void SetRestrictions (double d1, double d2, double gx, double slice){
        dom1 = d1;
        dom2 = d2;
        g = gx;
        iterations = slice;

    }
    //sets values from the main class

    //------------------------------------------------------------------------------------------------------------------

    public boolean Check (double d1, double d2){

        //initialize local variable
        boolean wrongQuadrant;

        if (d1 < 0){
            System.out.println("The domain values must be in greater than or equal to zero");
            wrongQuadrant = true;
            //if the first domain value is negative then prints out what the user did wrong sets wrongQuadrant to true
        }
        else if (d2 <= d1){
            System.out.println("The first domain must be less than the second domain value");
            wrongQuadrant = true;
            //if the second domain value is less than the first corrects the user and sets wrongQuadrant to true
        }
        else {
            wrongQuadrant = false;
            //if there is nothing wrong with the domain values then sets wrongQuadrant to false

        }//end of if statement

        return wrongQuadrant;
        //returns the boolean wrongQuadrant to the main class
    }
    //this method makes sure that the domain values are in the first quadrant

    //------------------------------------------------------------------------------------------------------------------

    public double CalcVolume (double m, double b){

        Volume(m, b);

        return volume;
    }
    //calls a private method within the class then returns the calculated volume

    //------------------------------------------------------------------------------------------------------------------

    private void Volume (double m, double b){

        //initializing local variables
        double height;
        double x;
        double thickness;

        for (int i = 0; i < iterations; i++){

            thickness = (dom2 - dom1)/iterations;
            //calculates the length of each iteration by finding the range of the domain
            //Then this range is divided by the number of iterations needed

            x = dom2 - thickness*i;
            //Allows current iteration to be accounted for in the overall calculated volume
            //Does so by finding the x value at that iteration (the second value of the domain minus the thickness of
            //Each iteration times which iteration is being calculated

            height = m*x + b - g;
            //calculates the height for the current x value using y = mx + b and subtracting the g(x) function

            volume += Math.abs(2*Math.PI*x*height*thickness);
            //Calculates the volume of each iteration by calculating the volume of a rectangular prism
            //The rectangular prism is created by "peeling" off a layer of the cylinder-like shape
            //the base of the prism is the circumference of the cylinder at that iteration (2*Math.PI*x)
            //the height of the prism is the y value at that iteration (height)
            //the width of the prism is the width of each iteration (thickness)
            //This shape is what is created by the rotation of the linear function around the y axis
            //Then adds all the volumes of the iterations together to get the total

        }
        //this for loop runs the number of iterations wanted
    }
    //calculates the volume

    //------------------------------------------------------------------------------------------------------------------

    public void ResetVolume (){
        volume = 0;
    }
    //resets the volume so that if multiple calculations occur they do not accumulate and skew results


    //------------------------------------------------------------------------------------------------------------------

    //Methods for Area

    public double CalcAreaBetween (double a, double b) {
        SetLineData(a, b);
        calcAreaLinear();
        return area;
    }
    //calculates the are underneath a linear function and returns the area

    public double CalcAreaBetween (double a, double b, double c) {
        SetQuadraticData(a, b, c);
        calcAreaQuadratic();
        return area;
    }
    //calculates the area underneath a quadratic function and returns the area

    public double CalcAreaBetween (EnumeratedType f, double a, double b, double c, double d) {
        SetSinusoidalData(a, b, c, d);
        if (f == EnumeratedType.SINE){
            calcAreaSine();
        }//if the value chosen was 3 then the user wanted to use a sine function
        else {
            calcAreaCosine();
        }//if the value chosen was not 3 then the user wanted to use a cosine function because the only other option is 4
        return area;
        //returns the calculated area
    }
    //calculates the area underneath a sinusoidal function and returns the area

    private void SetLineData (double a, double b) {
        a_value = a;
        b_value = b;
    }
    //sets the linear equation values

    private void SetQuadraticData (double a, double b, double c) {
        a_value = a;
        b_value = b;
        c_value = c;
    }
    //sets the quadratic equation values

    private void SetSinusoidalData (double a, double b, double c, double d) {
        a_value = a;
        b_value = b;
        c_value = c;
        d_value = d;
    }
    //sets the sinusoidal equation values

    private double calcAreaLinear () {

        height = a_value*dom1 + b_value - g;
        //finds the y-value at the beginning of the domain

        base = (dom2 - dom1) / iterations;
        //find how big each base there are

        for (int x = 0; x < iterations; x++){
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height*base);
            //calculates the area of the rectangle by multiplying the base, which is calculated  by the height, the y-value

            dom1 += base;
            //finds the x-value for the next iteration

            height = a_value*dom1 + b_value - g;
            //recalculates the y-value based on the new x-value

            area += rect;
            //adds all of the areas of the rectangles together
        }//end for loop
        return area;
        //returns the area to the main class
    }
    //calculates the area under a linear function

    private double calcAreaQuadratic () {

        height = a_value*(dom1 - b_value)*(dom1 - b_value) + c_value - g;
        //finds the y-value at the beginning of the domain

        base = (dom2 - dom1) / iterations;
        //this finds the width of the slices

        for (int i = 0; i < iterations; i++) {
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height * base);
            //calculates the area of the rectangle

            dom1 += base;
            //moves on to the next iteration

            height = a_value*(dom1 - b_value)*(dom1 - b_value) + c_value - g;
            //recalculates the base of the new iteration

            area += rect;
            //adds all of the areas of the rectangles together to get the total area
        }//end of for loop
        return area;
        //returns the total area
    }
    //calculates the area under a quadratic function

    private double calcAreaSine () {

        height = a_value * Math.sin((b_value * (dom1 - c_value))) + d_value - g;
        //finds the y-value at the beginning of the domain


        base = (dom2 - dom1) / iterations;
        //this finds the width of the slices


        for (int i = 0; i < iterations; i++) {
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height * base);
            //calculates the area of the rectangle

            dom1 += base;
            //moves on to the next iteration

            height = a_value * Math.sin((b_value * (dom1 - c_value))) + d_value - g;
            //recalculates the base of the new


            area += rect;
            //adds all of the areas of the rectangles together to get the total area
        }//end of for loop
        return area;
        //returns the total area
    }
    //calculates the area under a sine function

    private double calcAreaCosine (){

        height = a_value * Math.cos((b_value * (dom1 - c_value))) + d_value - g;
        //finds the y-value at the beginning of the domain

        base = (dom2 - dom1) / iterations;
        //this finds the width of the slices

        for (int i = 0; i < iterations; i++) {
            //how many rectangle/slice area to calculate
            //restricts number of areas to find

            rect = Math.abs(height * base);
            //calculates the area of the rectangle

            dom1 += base;
            //moves on to the next iteration

            height = a_value * Math.cos((b_value * (dom1 - c_value))) + d_value - g;
            //recalculates the base of the new

            area += rect;
            //adds all of the areas of the rectangles together to get the total area
        }//end of for loop
        return area;
        //returns the total area
    }
    //calculates the area under a cosine function

    public void resetData () {

        area = 0;
        rect = 0;
        height = 0;
        base = 0;

    }
    //resets all of the variables in the class


}//end of class



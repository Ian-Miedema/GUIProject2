package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 55346mie on 18/01/2018.
 */
public class LinearArea extends JFrame{

    final int WIDTH = 250;
    final int LENGTH = 500;



    public LinearArea () {

        super("Linear Area Calculation");

        JFrame LinearArea = new JFrame("Linear Area Calculation");
        setSize(WIDTH, LENGTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);


        JLabel instructions = new JLabel("Please enter the following information");
        JLabel ValueA = new JLabel("The slope");
        JLabel ValueB = new JLabel("The vertical shift");
        JLabel ValueG = new JLabel("The restrictive function");
        JLabel ValueD1 = new JLabel("The lower domain");
        JLabel ValueD2 = new JLabel("The upper domain");
        JLabel ValueSlice = new JLabel("The number of iterations");
        JLabel answer = new JLabel("");

        JTextField EnterA = new JTextField(12);
        JTextField EnterB = new JTextField(12);
        JTextField EnterG = new JTextField(12);
        JTextField EnterD1 = new JTextField(12);
        JTextField EnterD2 = new JTextField(12);
        JTextField EnterSlice = new JTextField(12);

        JButton submit = new JButton("Submit Information");

        setLayout(new FlowLayout());

        add(instructions);
        add(ValueA);
        add(EnterA);
        add(ValueB);
        add(EnterB);
        add(ValueG);
        add(EnterG);
        add(ValueD1);
        add(EnterD1);
        add(ValueD2);
        add(EnterD2);
        add(ValueSlice);
        add(EnterSlice);
        add(submit);
        add(answer);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double a_value;
                double b_value;
                double gx;
                double D1;
                double D2;
                double iterations;
                double rect;
                double area = 0;

                a_value = Double.parseDouble(EnterA.toString());
                b_value = Double.parseDouble(EnterB.toString());
                gx = Double.parseDouble(EnterG.toString());
                D1 = Double.parseDouble(EnterD1.toString());
                D2 = Double.parseDouble(EnterD2.toString());
                iterations = Double.parseDouble(EnterSlice.toString());


                double height = a_value * D1 + b_value - gx;
                //finds the y-value at the beginning of the domain

                double base = (D2 - D1) / iterations;
                //find how big each base there are

                for (int x = 0; x < iterations; x++) {
                    //how many rectangle/slice area to calculate
                    //restricts number of areas to find

                    rect = Math.abs(height * base);
                    //calculates the area of the rectangle by multiplying the base, which is calculated  by the height, the y-value

                    D1 += base;
                    //finds the x-value for the next iteration

                    height = a_value * D1 + b_value - gx;
                    //recalculates the y-value based on the new x-value

                    area += rect;
                    //adds all of the areas of the rectangles together
                }//end for loop


                answer.setText(String.valueOf(area));
            }
        });

    }


}

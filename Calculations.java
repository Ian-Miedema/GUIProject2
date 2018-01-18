package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 55346mie on 18/01/2018.
 */
public class IntroScreen extends JFrame{

    final int WIDTH = 500;
    final int LENGTH = 250;

    public IntroScreen (){

        super("Calculation GUI");

        LinearArea Calculation = new LinearArea();

        JFrame Intro = new JFrame("Calculation GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

        JLabel label1 = new JLabel("Choose one of the following programs");

        String choice[] = {"Calculate Linear Area", "Calculate Quadratic Area", "Calculate Area of a Sine Function",
                "Calculate Area of a Cosine Function", "Calculate Volume of Rotation of a Linear Function"};

        JComboBox options = new JComboBox(choice);

        JButton clickMe = new JButton("Submit");

        Intro.setSize(WIDTH, LENGTH);

        Intro.setLayout(new FlowLayout());

        Intro.add(label1);
        Intro.add(options);
        Intro.add(clickMe);

        Intro.setVisible(true);

        clickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String selected = (String) options.getSelectedItem();

                switch (selected){
                    case "Calculate Linear Area": Calculation.setVisible(true);
                        dispose();
                        break;
                    case "Calculate Quadratic Area":
                        dispose();
                        break;
                    case "Calculate Area of a Sine Function":
                        dispose();
                        break;
                    case "Calculate Area of a Cosine Function":
                        dispose();
                        break;
                    case "Calculate Volume of Rotation of a Linear Function":
                        dispose();
                        break;
                }
            }
        });
    }

}

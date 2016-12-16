package ch.gibmit.insidersoundboard.gui;

import javax.swing.*;

public class Frame extends JFrame {

    private JFrame frame;

    public Frame() {

        frame = new JFrame();

        initFrame();


    }

    private void initFrame() {

        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

}

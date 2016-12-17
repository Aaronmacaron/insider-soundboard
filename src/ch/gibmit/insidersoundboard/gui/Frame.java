package ch.gibmit.insidersoundboard.gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Frame extends JFrame {

    private JFrame frame;

    public Frame() {

        frame = new JFrame();

        setLookAndFeel();
        initFrame();
        addHeader();
    }

    /**
     * Sets the LookAndFeel to the System-Look
     */
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Initializes the JFrame
     */
    private void initFrame() {

        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Insider Soundboard");
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setVisible(true);

    }

    /**
     * Adds the Header of the JFrame
     */
    private void addHeader() {

        // Panel
        JPanel header = new JPanel();
        header.setBounds(0, 0, frame.getWidth(), 50);
        header.setLayout(null);
        frame.getContentPane().add(header);

        // Label
        JLabel headerText = new JLabel("Insider Soundboard", JLabel.CENTER);
        headerText.setBounds(0, 0, frame.getWidth(), 50);
        headerText.setFont(new Font(headerText.getFont().getName(), Font.PLAIN, 25));
        header.add(headerText);

        // Button
        JButton headerInfoBtn = new JButton("i");
        headerInfoBtn.setBounds(frame.getWidth() - 50, 5, 40, 40);
        headerInfoBtn.setFont(new Font(headerInfoBtn.getFont().getName(), Font.PLAIN, 30));
        headerInfoBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, "Placeholder"));
        header.add(headerInfoBtn);

    }

}

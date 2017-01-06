package ch.gibmit.insidersoundboard.gui;

import ch.gibmit.insidersoundboard.Sound;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame {

    private final String infoMessage = "Program made by Aaron Ebnöther and Kay Mattern";
    private ArrayList<Sound> sounds;

    public Frame(ArrayList<Sound> sounds) {
        this.sounds = sounds;

        setLookAndFeel();
        initFrame();
        addHeader();
        addBody();
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
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Insider Soundboard");
        getContentPane().setBackground(new Color(255,255,255));
        getContentPane().setLayout(null);
        setVisible(true);
    }

    /**
     * Adds the Header of the JFrame
     */
    private void addHeader() {
        // Panel
        JPanel header = new JPanel();
        header.setBounds(0, 0, getContentPane().getWidth(), 50);
        getContentPane().add(header);
        header.setLayout(null);

        // Label
        JLabel headerText = new JLabel("Insider Soundboard", JLabel.CENTER);
        headerText.setBounds(0, 0, getContentPane().getWidth(), 50);
        headerText.setFont(new Font(headerText.getFont().getName(), Font.PLAIN, 25));
        header.add(headerText);

        // Button
        JButton headerInfoBtn = new JButton("i");
        headerInfoBtn.setBounds(getContentPane().getWidth() - 50, 5, 40, 40);
        headerInfoBtn.setFont(new Font(headerInfoBtn.getFont().getName(), Font.PLAIN, 30));
        headerInfoBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, infoMessage,
                "Info:", JOptionPane.PLAIN_MESSAGE, new ImageIcon(getClass().getResource("/ch/gibmit/insidersoundboard/gui/icon.png"))));
        header.add(headerInfoBtn);
    }

    /**
     * Adds the body
     */
    private void addBody() {
        // JPanel
        JPanel body = new JPanel();
        body.setBackground(Color.WHITE);
        body.setBounds(0, 50, getContentPane().getWidth(), getContentPane().getHeight() - 100);
        body.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(body);
        body.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Buttons
        int btnWidth = getContentPane().getWidth() / 5 - 20;
        int btnHeight = getContentPane().getHeight() / 5 - 20;
        System.out.println(btnWidth + " " + btnHeight);
        for (Sound s : sounds) {
            JButton btn = new JButton(s.getName());
            btn.setFont(new Font(btn.getFont().getName(), Font.PLAIN, 16));
            btn.addActionListener(e -> s.play());
            btn.setPreferredSize(new Dimension(btnWidth, btnHeight));
            body.add(btn);
        }
    }

}

package HMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HomePage extends JFrame implements ActionListener {
    JPanel mainPanel;
    JButton patientButton;
    JButton doctorButton;
    public HomePage() {
        setTitle("Appointment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setLayout(null);
        setSize(500, 500);

        patientButton = new JButton("patient Panel");
        patientButton.setBounds(150,120,150,50);
        patientButton.setFocusable(false);
        patientButton.addActionListener(this);
        patientButton.setBackground(new Color(238, 121, 80 ));

        doctorButton = new JButton("Doctor Panel");
        doctorButton.setBounds(150,200,150,50);
        doctorButton.setFocusable(false);
        doctorButton.addActionListener(this);
        doctorButton.setBackground(new Color(53, 165, 79));

        mainPanel.setBackground( new Color(205, 205, 225 ));

//        ImageIcon wallpaper = new ImageIcon("wallpaper.jpeg"); // Load the image
//        JLabel wallpaperLabel = new JLabel(wallpaper); // Create a JLabel and set the image as its icon
//        wallpaperLabel.setBounds(0,0,500,500);
//        wallpaperLabel.setVisible(true);
//        wallpaperLabel.setOpaque(true); // behind other components
        //mainPanel.add(wallpaperLabel);


        mainPanel.add(patientButton);
        mainPanel.add(doctorButton);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==patientButton){
            Patient patient = new Patient();
            patient.setVisible(true);
        }
        if (e.getSource()==doctorButton){
            Doctor doctor = new Doctor();
            doctor.setVisible(true);
        }
    }
}


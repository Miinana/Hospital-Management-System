package HMS.view;

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
        mainPanel.setLayout(null);
        setSize(500, 500);

        //mainPanel.setBackground( new Color(205, 205, 225 ));

        mainPanel.setLayout(new BorderLayout());
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addTab( "Patients", new Patient());
        tabPane.addTab( "Doctors", new Doctor());
        add(tabPane);

        setLocationRelativeTo(null); //center the HomePage on the screen
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


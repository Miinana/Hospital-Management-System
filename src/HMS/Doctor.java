package HMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctor extends JFrame implements ActionListener {
    JPanel panel;
    JTextField fetchText;
    JButton fetchButton;
    JButton prescriptionButton;
    JButton commentsButton;
    JButton nextCheckUpButton;
    JTextField prescriptionText;
    JTextField commentsText;
    Patient patientInstance;

    public Doctor(){
    setSize(500, 500);
    setTitle("Doctor Information");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);

    panel = new JPanel(new GridLayout(3,3));
    fetchText = new JTextField("fetchText");
    fetchButton = new JButton("Fetch Patient Details");
    fetchButton.addActionListener(this);

    prescriptionButton = new JButton("Prescription");
    commentsButton = new JButton("Comments");
    nextCheckUpButton = new JButton("  Next CheckUp");
    prescriptionText = new JTextField(" prescription");
    commentsText = new JTextField("commentsText");

    panel.add(fetchText);
    panel.add(fetchButton);
    panel.add(prescriptionButton);
    panel.add(commentsButton);
    panel.add(nextCheckUpButton);
    panel.add(prescriptionText);
    panel.add(commentsText);


    panel.setBounds(0,0,500,500);
    add(panel);
    panel.setPreferredSize(new Dimension(500,500));
    panel.setVisible(true);
    setVisible(true);
        patientInstance = new Patient();

}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchButton) {
            PatientInfo patientInfo = patientInstance.searchPatientById();
            if (patientInfo != null) {
                String result = patientInstance.getPatientInfo(patientInfo.getId());
                fetchText.setText(result);
            }
        }
    }
}
package HMS.view;

import HMS.controller.PatientService;
import HMS.model.PatientInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doctor extends JPanel implements ActionListener {
    JTextArea fetchText;
    JButton fetchButton;
    JButton prescriptionButton;
    JButton commentsButton;
    JButton nextCheckUpButton;
    JTextArea prescriptionText;
    JTextArea commentsText;
    JTextArea nextCheckUpText;
    Patient patientInstance;

    public Doctor() {
        setSize(500, 500);
        setLayout(new GridLayout(3, 3));


        fetchButton = new JButton("Fetch Patient Details");
        fetchButton.addActionListener(this);

        fetchText = new JTextArea("fetchText");
        fetchText.setLineWrap(true);
        fetchText.setWrapStyleWord(true);

        prescriptionButton = new JButton("Prescription");
        prescriptionButton.addActionListener(this);

        commentsButton = new JButton("Comments");
        commentsButton.addActionListener(this);

        nextCheckUpButton = new JButton("  Next CheckUp");
        nextCheckUpButton.addActionListener(this);

        prescriptionText = new JTextArea(" prescription");
        prescriptionText.setLineWrap(true);
        prescriptionText.setWrapStyleWord(true);

        commentsText = new JTextArea("comments Text");
        commentsText.setLineWrap(true);
        commentsText.setWrapStyleWord(true);

        nextCheckUpText = new JTextArea("next CheckUp Text");
        nextCheckUpText.setLineWrap(true);
        nextCheckUpText.setWrapStyleWord(true);

        add(fetchText);
        add(fetchButton);
        add(prescriptionButton);
        add(commentsButton);
        add(nextCheckUpButton);
        add(prescriptionText);
        add(commentsText);
        add(nextCheckUpText);

        setBounds(0, 0, 500, 500);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);

        patientInstance = new Patient();
    }

    public void actionPerformed(ActionEvent e) {
        //fetchButton******************fetchButton
        if (e.getSource() == fetchButton) {
            PatientInfo patientInfo = patientInstance.searchPatientById();
            if (patientInfo != null) {
                String result = Patient.getPatientInfo(patientInfo.getId());
                fetchText.setText(result);
            }
        }

        //prescriptionButton*******************prescriptionButton
        if (e.getSource() == prescriptionButton) {
            try {
                PatientInfo patientInfo = patientInstance.searchPatientById();
                String prescriptionForPatient = JOptionPane.showInputDialog(this,
                        "Enter the prescription for this patient", "prescription", JOptionPane.QUESTION_MESSAGE);

                if (prescriptionForPatient != null && !prescriptionForPatient.isEmpty()) {
                    patientInfo.setPrescription(prescriptionForPatient);
                }
                prescriptionText.setText("Patient ID: " + patientInfo.getId() + " prescription: " + patientInfo.getPrescription());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input for patient prescription. Please enter a valid text.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //commentsButton************commentsButton
        if (e.getSource() == commentsButton) {
            try {
                PatientInfo patientInfo = patientInstance.searchPatientById();
                String commentForPatient = JOptionPane.showInputDialog(this,
                        "Enter the comment for this patient", "Comment", JOptionPane.QUESTION_MESSAGE);

                if (commentForPatient != null && !commentForPatient.isEmpty()) {
                    patientInfo.setComment(commentForPatient);
                }
                prescriptionText.setText("Patient ID: " + patientInfo.getId() + " Comment: " + patientInfo.getComment());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input for patient Comment. Please enter a valid text.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //commentsButton************commentsButton
        if (e.getSource() == commentsButton) {
            try {
                PatientInfo patientInfo = patientInstance.searchPatientById();
                String nextCheckUpForPatient = JOptionPane.showInputDialog(this,
                        "Enter the next Check Up time and date for this patient DD-MM-YY HH:MM", "next Check Up", JOptionPane.QUESTION_MESSAGE);

                if (nextCheckUpForPatient != null && !nextCheckUpForPatient.isEmpty()) {
                    patientInfo.setNextCheckUp(nextCheckUpForPatient);
                }
                nextCheckUpText.setText("Patient ID: " + patientInfo.getId() + " Next Check Up: " + patientInfo.getNextCheckUp());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input for patient next Check Up. Please enter a valid text.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
package HMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Patient extends JFrame implements ActionListener {
    JPanel upPanel;
    JPanel downPanel;
    JButton submitButton;
    JButton updateButton;
    JButton deleteButton;
    Font labelFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField6;
    JTextArea patientTextArea;
    static Map<Integer, PatientInfo> patientsMap;

    public Patient() {

        //patient page:
        setSize(500, 500);
        setTitle("Patient Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // up Panel
        upPanel = new JPanel(new GridLayout(1, 2));
        // up Panel right side:
        JPanel upRight = new JPanel(new GridLayout(13, 1));

        String[] labelsText = {"Name:", "Surname:", "Age:", "Contact info:", "Gender:", "Doctor category:"};
        JLabel[] labels = new JLabel[labelsText.length];

        for (int i = 0; i < labelsText.length; i++) {
            labels[i] = new JLabel(labelsText[i]);
            labels[i].setFont(labelFont);
            upRight.add(labels[i]);

            // Add an empty line
            if (i < labelsText.length - 1) {
                upRight.add(new JLabel("  "));
            }
        }

        // up Panel left side:
        JPanel upLeft = new JPanel();
        upLeft.setLayout(new GridLayout(6, 1));
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();

        upLeft.add(textField1);
        upLeft.add(textField2);
        upLeft.add(textField3);
        upLeft.add(textField4);
        upLeft.add(textField5);
        upLeft.add(textField6);

        upPanel.add(upRight);
        upPanel.add(upLeft);


        //Down Panel
        downPanel = new JPanel(new GridLayout(2, 2));
        downPanel.setPreferredSize(new Dimension(500, 150));
        submitButton = new JButton("submit");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        patientTextArea = new JTextArea();
        patientTextArea.setFont(new Font("Arial", Font.PLAIN, 10));

        downPanel.add(submitButton);
        downPanel.add(updateButton);
        downPanel.add(deleteButton);
        downPanel.add(patientTextArea);

        submitButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

        add(upPanel, BorderLayout.NORTH);
        add(downPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        //Create a hash map to store objects
        patientsMap = new HashMap<>();
    }

    private boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            //submitButton****************************submitButton
        if (e.getSource() == submitButton) {
            // Check for empty fields
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty() ||
                    textField3.getText().isEmpty() || textField4.getText().isEmpty() ||
                    textField5.getText().isEmpty() || textField6.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Empty Fields", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Check for invalid input format
            if (!isString(textField1.getText()) || !isString(textField2.getText())
                    || !isString(textField4.getText()) ||
                    !isString(textField5.getText()) || !isString(textField6.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid input format. Please enter valid information.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                // Create PatientInfo object
                PatientInfo patientInfo = new PatientInfo(textField1.getText(), textField2.getText(),
                        Integer.parseInt(textField3.getText()), textField4.getText(),
                        textField5.getText(), textField6.getText());

                // Add object to the HashMap
                patientsMap.put(patientInfo.getId(), patientInfo);

                JOptionPane.showMessageDialog(this, "patient Information has been saved successfully");

                // Update patient area and clear fields
                updatePatientArea();
                clearFields();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid age.", "Invalid Age", JOptionPane.ERROR_MESSAGE);
            }
        }

        //updateButton*****************************************updateButton
        if (e.getSource() == updateButton) {
            try {
                String userIdInput = JOptionPane.showInputDialog(this,
                        "Enter the patient ID number", "Updating", JOptionPane.QUESTION_MESSAGE);
                if (userIdInput != null && !userIdInput.isEmpty()) {

                    int patientId = Integer.parseInt(userIdInput);
                    // Retrieve the existing patient info
                    PatientInfo existingPatient = patientsMap.get(patientId);
                    if (existingPatient != null) {
                        existingPatient.setName(textField1.getText());
                        existingPatient.setSurname(textField2.getText());
                        existingPatient.setAge(Integer.parseInt(textField3.getText()));
                        existingPatient.setContactInfo(textField4.getText());
                        existingPatient.setGender(textField5.getText());
                        existingPatient.setDoctorCategory(textField6.getText());
                        SwingUtilities.invokeLater(() -> {
                            // Update the patient information in the text area
                            patientTextArea.setText(getPatientInfo(patientId));
                            patientTextArea.setCaretPosition(0);
                            patientTextArea.requestFocusInWindow();
                        });
                        JOptionPane.showMessageDialog(this, "Patient information updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Patient with ID " + patientId + " not found.",
                                "Patient Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input for patient ID. Please enter a valid integer.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() ==deleteButton){
            try {
                String userIdInput = JOptionPane.showInputDialog(this,
                        "Enter the patient ID number", "Updating", JOptionPane.QUESTION_MESSAGE);
                int patientIdToRemove = Integer.parseInt(userIdInput);

                if (!userIdInput.isEmpty()) {
                    patientsMap.remove(patientIdToRemove);
                    JOptionPane.showMessageDialog(this, "patient Information has been successfully deleted!");

                } else {
                    JOptionPane.showMessageDialog(this,
                            "Patient with ID " + patientIdToRemove +
                                    " not found.", "Patient Not Found", JOptionPane.ERROR_MESSAGE);

                }
            } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid input for patient ID. Please enter a valid integer.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    }

    // In upper left part
    private void updatePatientArea() {
        patientTextArea.setText(""); // Clear the text area
        for (PatientInfo patient : patientsMap.values()) {
            patientTextArea.append(patient.toString() + "\n"); // Display each patient's info
        }
    }
    // clear all input fields upper right
    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
    }
    private static String getPatientInfo(int patientId) {
        PatientInfo patientInfo = patientsMap.get(patientId);
        if (patientInfo != null) {
            return "Patient ID: " + patientId +
                    ", Name: " + patientInfo.getName() +
                    ", Surname: " + patientInfo.getSurname() +
                    ", Age: " + patientInfo.getAge() +
                    ", Contact Info: " + patientInfo.getContactInfo() +
                    ", Gender: " + patientInfo.getGender() +
                    ", Doctor Category: " + patientInfo.getDoctorCategory();
        } else {
            return "Patient not found.";
        }
    }
}


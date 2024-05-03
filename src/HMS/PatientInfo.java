package HMS;

import java.util.HashMap;
import java.util.Random;

public class PatientInfo {
    private String name;
    private int id;
    private String surname;
    private int age;
    private String contactInfo;
    private String gender;
    private String doctorCategory;
    HashMap<String, PatientInfo> patientInfoHashMap;

    public PatientInfo(String name, String surname, int age, String contactInfo, String gender, String doctorCategory) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.contactInfo = contactInfo;
        this.gender = gender;
        this.doctorCategory = doctorCategory;
        this.id = createID();
        patientInfoHashMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public String getDoctorCategory() {
        return doctorCategory;
    }
    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }
    public int getId() {
        return this.createID();
    }

    // generate a 3 digits number as ID
    public int createID() {
        Random random = new Random();
        return random.nextInt(900) + 100;
    }

    public String toString() {
        return "Patient Information:" +
                " ID: " + getId() +
                " Name: " + name +
                " Surname: " + surname +
                " Age: " + age +
                " Contact Info: " + contactInfo +
                " Gender: " + gender +
                " Doctor Category: " + doctorCategory;
    }
}



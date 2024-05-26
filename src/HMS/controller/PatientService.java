package HMS.controller;

import HMS.model.PatientInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PatientService {
    private final Map<Integer, PatientInfo> patientsMap = new HashMap<>();
    private final Random random = new Random();

    private PatientService() {
    }

    public void addNew(PatientInfo patientInfo) {
        patientsMap.put(patientInfo.getId(), patientInfo);
    }
    public void remove(PatientInfo patientInfo) {
        patientsMap.remove(patientInfo.getId());
    }
    public PatientInfo get(int i) {
        return patientsMap.get(i);
    }

    public Collection<PatientInfo> getAll() {
        return patientsMap.values();
    }

    public void update(PatientInfo patientInfo, String name, String surname, int age,
                       String contactInfo, String gender, String doctorCategory) {
        patientInfo.setName(name);
        patientInfo.setSurname(surname);
        patientInfo.setAge(age);
        patientInfo.setContactInfo(contactInfo);
        patientInfo.setGender(gender);
        patientInfo.setDoctorCategory(doctorCategory);
    }

//Generate 3 digits id number
    public int createID() {
        int i = random.nextInt(900) + 100;
        while (patientsMap.get(i) != null) {
            i = random.nextInt(900) + 100;
        }
        return i;
    }

    private static final PatientService instance = new PatientService();

    public static PatientService getInstance() {
        return instance;
    }


}

package peaksoft.services.impl;

import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dao.PatientDao;
import peaksoft.models.Patient;
import peaksoft.services.HospitalServices;
import peaksoft.services.PatientServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class PatientServicesImpl implements PatientServices {

    private final PatientDao patientDao;
    private final HospitalServices hospitalServices;
    @Override
    public void savePatient(Patient patient) {
        patientDao.savePatient(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientDao.getAllPatient();
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientDao.getPatientById(patientId);
    }

    @Override
    public void deletePatientById(Long patientId) {
        patientDao.deletePatientById(patientId);
    }

    @Override
    public void updatePatientId(Long id,Patient patient) {
        patient.setHospital(hospitalServices.getHospitalById(patient.getHospitalId()));
        patientDao.updatePatientId(id,patient);
    }
}

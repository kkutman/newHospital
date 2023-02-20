package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dao.DoctorDao;
import peaksoft.models.Doctor;
import peaksoft.services.DepartmentServices;
import peaksoft.services.DoctorServices;
import peaksoft.services.HospitalServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class DoctorServicesImpl implements DoctorServices {
    private final DoctorDao doctorDao;
    private final DepartmentServices departmentServices;
    private final HospitalServices hospitalServices;
    @Override
    public void saveDoctor(Doctor doctor) {
        doctor.setDepartments(List.of(departmentServices.getDepartmentById(doctor.getDepartmentId())));
        doctorDao.saveDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorDao.getAllDoctor();
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorDao.getDoctorById(doctorId);
    }

    @Override
    public void deleteDoctorById(Long doctorId) {
        doctorDao.deleteDoctorById(doctorId);
    }

    @Override
    public void updateDoctorId(Long id,Doctor doctor) {
        doctor.setHospital(hospitalServices.getHospitalById(doctor.getHospitalId()));
        doctor.setDepartments(List.of(departmentServices.getDepartmentById(doctor.getDepartmentId())));
        doctorDao.updateDoctorId(id,doctor);
    }
}

package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dao.DepartmentDao;
import peaksoft.models.Department;
import peaksoft.services.DepartmentServices;
import peaksoft.services.HospitalServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@RequiredArgsConstructor
public class DepartmentServicesImpl implements DepartmentServices {
    private final DepartmentDao departmentDao;
    private final HospitalServices hospitalServices;
    @Override
    public void saveDepartment(Department department) {
        departmentDao.saveDepartment(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentDao.getDepartmentById(departmentId);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentDao.deleteDepartmentById(departmentId);
    }

    @Override
    public void updateDepartmentId(Long id, Department department) {
        department.setHospital(hospitalServices.getHospitalById(department.getHospitalId()));
        departmentDao.updateDepartmentId(id,department);
    }
}

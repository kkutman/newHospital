package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.services.DepartmentServices;
import peaksoft.services.DoctorServices;
import peaksoft.services.HospitalServices;
import peaksoft.services.PatientServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalServices hospitalServices;
    private final DepartmentServices departmentServices;
    private final DoctorServices doctorServices;
    private final PatientServices patientServices;


    @GetMapping
    public String getAllHospital(Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        return "hospital";
    }

    @DeleteMapping("{id}/deleteHospital")
    public String deleteHospital(@PathVariable("id")Long id){
        hospitalServices.deleteHospitalById(id);
        return "redirect:/hospital";
    }

    @GetMapping("/saveHospital")
    public String saveHospital(Model model){
        model.addAttribute("newHospital",new Hospital());
        return "saveHospital";
    }

    @PostMapping("/createHospital")
    public String createHospital(@ModelAttribute("newHospital")Hospital hospital){
        hospitalServices.saveHospital(hospital);
        return "redirect:/hospital";
    }

    @GetMapping("{hospitalId}/editHospital")
    public String editHospital(@PathVariable("hospitalId")Long hospitalId,Model model){
        model.addAttribute("newUpdateHospital",hospitalServices.getHospitalById(hospitalId));
        return "updateHospital";
    }

    @PatchMapping("{hospitalId}/updateHospital")
    public String updateHospital(@PathVariable("hospitalId")Long id,@ModelAttribute("newUpdateHospital")Hospital hospital){
        hospitalServices.updateHospitalId(hospital,id);
        return "redirect:/hospital";
    }


    @GetMapping("{id}/saveDepartment")
    public String saveDepartment(Model model){
        model.addAttribute("department",new Department());
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        return "saveDepartment";
    }

    @PostMapping("{hospitalId}/createDepartment")
    public String createDepartment(@PathVariable("hospitalId")Long id,@ModelAttribute("department")Department department){
        department.setHospital(hospitalServices.getHospitalById(id));
        departmentServices.saveDepartment(department);
        return "redirect:/hospital";
    }

    @GetMapping("{id}/saveDoctor")
    public String saveDoctor(Model model){
        model.addAttribute("newDoctor",new Doctor());
        model.addAttribute("getAllDepartment",departmentServices.getAllDepartment());
        return "saveDoctor";
    }

    @PostMapping("{hospitalId}/createDoctor")
    public String createDoctor(@PathVariable("hospitalId")Long id,@ModelAttribute("newDoctor")Doctor doctor){
        doctor.setHospital(hospitalServices.getHospitalById(id));
        doctorServices.saveDoctor(doctor);
        return "redirect:/doctor";
    }



    @GetMapping("{id}/savePatient")
    public String savePatient(Model model){
        model.addAttribute("newPatient",new Patient());
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        return "savePatient";
    }

    @PostMapping("{hospitalId}/createPatient")
    public String createPatient(@PathVariable("hospitalId")Long id,@ModelAttribute("newPatient")Patient patient){
        patient.setHospital(hospitalServices.getHospitalById(id));
        patientServices.savePatient(patient);
        return "redirect:/patient";
    }


}

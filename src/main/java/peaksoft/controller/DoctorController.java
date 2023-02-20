package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.services.DepartmentServices;
import peaksoft.services.DoctorServices;
import peaksoft.services.HospitalServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorServices doctorServices;
    private final HospitalServices hospitalServices;
    private final DepartmentServices departmentServices;

    @GetMapping
    public String getAllDoctor(Model model){
        model.addAttribute("getAllDoctor",doctorServices.getAllDoctor());
        return "doctor";
    }
    @DeleteMapping("{id}/deleteDoctor")
    public String deleteHospital(@PathVariable("id")Long id){
        doctorServices.deleteDoctorById(id);
        return "redirect:/doctor";
    }

    @GetMapping("{id}/editDoctor")
    public String editDoctor(@PathVariable("id")Long id,Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        model.addAttribute("getAllDepartment",departmentServices.getAllDepartment());
        model.addAttribute("newUpdateDoctor",doctorServices.getDoctorById(id));
        return "updateDoctor";
    }
    @PostMapping("{doctorId}/updateDoctor")
    public String updateDoctor(@PathVariable("doctorId")Long id, @ModelAttribute("newUpdateDoctor")Doctor doctor){
        doctorServices.updateDoctorId(id, doctor);
        return "redirect:/doctor";
    }
}

package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Patient;
import peaksoft.services.HospitalServices;
import peaksoft.services.PatientServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientServices patientServices;
    private final HospitalServices hospitalServices;
    @GetMapping
    public String getAllPatient(Model model){
        model.addAttribute("getAllPatient",patientServices.getAllPatient());
        return "patient";
    }

    @DeleteMapping("{id}/deletePatient")
    public String deleteHospital(@PathVariable("id")Long id) {
        patientServices.deletePatientById(id);
        return "redirect:/patient";
    }



    @GetMapping("{id}/editPatient")
    public String editPatient(@PathVariable("id")Long id,Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        model.addAttribute("newUpdatePatient",patientServices.getPatientById(id));
        return "updatePatient";
    }
    @PostMapping("{id}/updatePatient")
    public String updatePatient(@PathVariable("id")Long id, @ModelAttribute("newUpdatePatient")Patient patient){
        patientServices.updatePatientId(id,patient);
        return "redirect:/patient";
    }
}

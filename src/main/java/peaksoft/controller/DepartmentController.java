package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.services.DepartmentServices;
import peaksoft.services.HospitalServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentServices departmentServices;
    private final HospitalServices hospitalServices;

    @GetMapping
    public String getAllDepartment(Model model){
        model.addAttribute("getAllDepartment",departmentServices.getAllDepartment());
        return "department";
    }

    @DeleteMapping("{departmentId}/deleteDepartment")
    public String deleteHospital(@PathVariable("departmentId")Long id) {
        departmentServices.deleteDepartmentById(id);
        return "redirect:/department";
    }

    @GetMapping("{departmentId}/editDepartment")
    public String editDepartment(@PathVariable("departmentId")Long id,Model model){
        model.addAttribute("getAllHospital",hospitalServices.getAllHospital());
        model.addAttribute("newUpdateDepartment",departmentServices.getDepartmentById(id));
        return "updateDepartment";
    }
    @PostMapping("{departmentId}/updateDepartment")
    public String updateDepartment(@PathVariable("departmentId")Long id,@ModelAttribute("newUpdateDepartment") Department department){
        departmentServices.updateDepartmentId(id,department);
        return "redirect:/department";
    }
}

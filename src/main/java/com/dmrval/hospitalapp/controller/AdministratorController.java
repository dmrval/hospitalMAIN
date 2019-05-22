package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Patient;
import com.dmrval.hospitalapp.entity.Visit;
import com.dmrval.hospitalapp.service.DoctorServise;
import com.dmrval.hospitalapp.service.PatientServise;
import com.dmrval.hospitalapp.service.VisitServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    VisitServise visitServise;

    @Autowired
    PatientServise patientServise;

    @Autowired
    DoctorServise doctorServise;

    //Mainpanel
    @GetMapping("")
    public String allVisistsMain() {
        return "adm_MainPanel";
    }




    //Visits
    @GetMapping("/allVisit")
    public String allVisists(Model model) {
        List<Visit> result = visitServise.sortByTime();
        model.addAttribute("lstvst", result);
        return "adm_allVisit";
    }

    @GetMapping("/allVisit/{id}")
    public String getVisitById(@PathVariable("id") int id, Model model) {
        model.addAttribute("visit", visitServise.getVisit(id));
        return "adm_visit";
    }

    @GetMapping("/delete/{id}")
    public String deleteVisitGET(@PathVariable("id") int id) {
        visitServise.removeVisit(id);
        return "redirect:/administrator/allVisit";
    }
    @GetMapping("/addVisit")
    public String addVisit() {
        return "addVisit";
    }

    @GetMapping("/update/{id}")
    public String updateVisit(@PathVariable("id") int id, Model model) {
        model.addAttribute("doclist", doctorServise.getAllDoctor());
        model.addAttribute("patlist", patientServise.getAllPatient());
        model.addAttribute("visit", visitServise.getVisit(id));
        return "adm_editVisit";
    }

    @GetMapping("/allVisit/{id}/setDiagosis")
    public String setDiagnisis(@PathVariable("id") int id, Model model) {
        model.addAttribute("visit", visitServise.getVisit(id));
        model.addAttribute("diag", visitServise.getVisit(id).getDiagnosis());
        return "setDiagnosis";
    }




    //Patient
    @GetMapping("/allPatient")
    public String allPatients(Model model) {
        List<Patient> result = patientServise.getAllPatient();
        model.addAttribute("lstpatient", result);
        return "adm_allPatient";
    }

    @GetMapping("/addPatient")
    public String addPatientGet() {
        return "addPatient";
    }

    @GetMapping("/allPatient/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        patientServise.removePatient(id);
        return "redirect:/administrator/allPatient";
    }

    @GetMapping("/allPatient/update/{id}")
    public String editPatient(@PathVariable("id") int id, Model model) {
        model.addAttribute("patient", patientServise.getPatient(id));
        return "adm_editPatient";
    }





    //Doctor
    @GetMapping("/allDoctor")
    public String allDoctor(Model model) {
        List<Doctor> result = doctorServise.getAllDoctor();
        model.addAttribute("lstdoctor", result);
        return "adm_allDoctor";
    }

    @RequestMapping(value = "/administrator/addDoctor", method = RequestMethod.GET)
    public String addDoctorGet() {
        return "addDoctor";
    }

    @GetMapping("/allDoctor/delete/{id}")
    public String deleteDoctor(@PathVariable("id") int id) {
        doctorServise.removeDoctor(id);
        return "redirect:/administrator/allDoctor";
    }

    @GetMapping("/allDoctor/update/{id}")
    public String editDoctor(@PathVariable("id") int id, Model model) {
        model.addAttribute("doctor", doctorServise.getDoctor(id));
        return "adm_editDoctor";
    }


}

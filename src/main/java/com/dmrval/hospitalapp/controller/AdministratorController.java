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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String allVisistsMain(Model model) {
        List<Visit> result = visitServise.sortByTime();
        model.addAttribute("lstvst", result);
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
        return "redirect:/administrator";
    }

    //Patient
    @GetMapping("/allPatient")
    public String allPatients(Model model) {
        List<Patient> result = patientServise.getAllPatient();
        model.addAttribute("lstpatient", result);
        return "adm_allPatient";
    }


    //Doctor
    @GetMapping("/allDoctor")
    public String allDoctor(Model model) {
        List<Doctor> result = doctorServise.getAllDoctor();
        model.addAttribute("lstdoctor", result);
        return "adm_allDoctor";
    }


}

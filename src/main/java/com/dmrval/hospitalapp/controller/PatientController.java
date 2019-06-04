package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.service.PatientService;
import com.dmrval.hospitalapp.service.UserDetailsImpl;
import com.dmrval.hospitalapp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitService visitService;

    @GetMapping("/patient")
    public String getMainpanelPatient() {
        return "pat_MainPanel";
    }

    @GetMapping("/patient/patSettings")
    public String getPatSettings(Model model, Principal principal) {
        model.addAttribute("patient", patientService.getPatientbyLogin(principal.getName()));
        return "pat_patSettings";
    }

    @GetMapping("/patient/newPassword")
    public String getnewPasswordPage(Model model, Principal principal) {
        model.addAttribute("patient", patientService.getPatientbyLogin(principal.getName()));
        return "pat_newPassword";
    }

    @GetMapping("/patient/allVisits")
    public String getPatientAllVisits(Model model) {
        return "pat_allVisit";
    }
}

package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.service.PatientService;
import com.dmrval.hospitalapp.service.UserDetailsImpl;
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

    @GetMapping("/patient")
    public String getMainpanelPatient() {
        return "pat_MainPanel";
    }

    @GetMapping("/patient/patSettings")
    public String getPatSettings(Model model, Principal principal) {
        model.addAttribute("patient", patientService.findPatByLogin(principal.getName()));
        return "pat_patSettings";
    }

    @GetMapping("/patient/newPassword")
    public String getnewPasswordPage(Model model, Principal principal) {
        model.addAttribute("patient", patientService.findPatByLogin(principal.getName()));

        return "pat_newPassword";
    }
}

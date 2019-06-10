package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.service.DoctorService;
import com.dmrval.hospitalapp.service.PatientService;
import com.dmrval.hospitalapp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DoctorController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/doctor")
    public String getMainpanelDoctor() {
        return "doc_MainPanel";
    }

    @GetMapping("/doctor/allVisits")
    public String getAllVisitByDoctor(Model model, Principal principal) {
        model.addAttribute("lstvst", visitService.getAllVisit_ByOneDoctor(
                doctorService.getDoctorbyLogin(principal.getName())));
        return "doc_allVisit";
    }

    @GetMapping("/doctor/newPassword")
    public String getChangePassword(Model model, Principal principal) {
        model.addAttribute("doctor", doctorService.getDoctorbyLogin(principal.getName()));
        return "doc_newPassword";
    }

    @GetMapping("/doctor/docSettings")
    public String getDocSettings(Model model, Principal principal) {
        model.addAttribute("doctor", doctorService.getDoctorbyLogin(principal.getName()));
        return "doc_docSettings";
    }


    @GetMapping("/doctor/addVisit")
    public String getDocAddVisit(Model model, Principal principal) {
        model.addAttribute("lstpatient", patientService.getAllPatient());
        return "doc_addVisit";
    }





}

package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.Visit;
import com.dmrval.hospitalapp.service.DoctorService;
import com.dmrval.hospitalapp.service.PatientService;
import com.dmrval.hospitalapp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/patient")
    public String getMainpanelPatient(Model model, Principal principal) {
        String currpass = patientService.getPatientbyLogin(principal.getName()).getUser().getPassword();
        if (passwordEncoder.matches("123456", currpass)) {
            model.addAttribute("plschangepass", true);
        }
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
    public String getPatientAllVisits(Model model, Principal principal) {
        List<Visit> list = visitService.getAllVisit_ByOnePatient(patientService.getPatientbyLogin(principal.getName()));
        list.sort((o1, o2) -> o2.getDayofvisit().compareTo(o1.getDayofvisit()));
        model.addAttribute("lstvst", list);
        return "pat_allVisit";
    }

    @GetMapping("/patient/addVisit")
    public String getPatientAddVisits(Model model) {
        model.addAttribute("lstdoctor", doctorService.getAllDoctor());
        return "pat_addVisit";
    }

    @GetMapping("/patient/addVisit/{id}/getFreeTimes")
    public String getFreeTimes(@PathVariable int id, Model model) {
        //для минуса занятых посещений
        List<Timestamp> getFreeTime = visitService.getTimestampByDoctor(doctorService.getDoctor(id));
        model.addAttribute("calendarDay", visitService.getWorkCalendar());
        model.addAttribute("doc", doctorService.getDoctor(id));
        model.addAttribute("lstdoctor", doctorService.getAllDoctor());
        return "pat_addVisit";
    }

}

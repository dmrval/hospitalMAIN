package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.Doctor;
import com.dmrval.hospitalapp.entity.Visit;
import com.dmrval.hospitalapp.service.DoctorService;
import com.dmrval.hospitalapp.service.PatientService;
import com.dmrval.hospitalapp.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

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
        List<Visit> visitList = visitService.getAllVisit_ByOneDoctor(
                doctorService.getDoctorbyLogin(principal.getName()));

        visitList.sort((o1, o2) -> o2.getDayofvisit().compareTo(o1.getDayofvisit()));
        model.addAttribute("lstvst", visitList);
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


    @GetMapping("/doctor/addVisit/{id}/getFreeTimes")
    public String getFreeTimes(@PathVariable int id, Model model, Principal principal) {
        //для минуса занятых посещений
        Doctor current = doctorService.getDoctorbyLogin(principal.getName());
        List<Timestamp> getFreeTime = visitService.getTimestampByDoctor(current);
        model.addAttribute("calendarDay", visitService.getWorkCalendar());
        model.addAttribute("pat", patientService.getPatient(id));
        model.addAttribute("lstpatient", patientService.getAllPatient());
        return "doc_addVisit";
    }


}

package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.*;
import com.dmrval.hospitalapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    DoctorlicenseServise doctorlicenseServise;

    @Autowired
    AddressServise addressServise;

    @Autowired
    DoctorServise doctorServise;

    @Autowired
    PatientServise patientServise;

    @Autowired
    MedicalpolicyServise medicalpolicyServise;

    @Autowired
    VisitServise visitServise;

    @Autowired
    DiagnosisServise diagnosisServise;

    @GetMapping("/")
    public String index() {
        return "adm_MainPanel";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("licenses", doctorlicenseServise.getAllDoctorlicense());
        return "hello";
    }

    @GetMapping("/createDoctorlicense")
    public String createDoctorlicense() {
        return "createDoctorlicense";
    }


    @PostMapping("/addDoctorlicensePage")
    public String addDoctorlicensePage(@ModelAttribute("tmplicense") Doctorlicense doctorlicense) {
        doctorlicenseServise.addDoctorlicense(doctorlicense);
        return "redirect:/hello";
    }


    @PostMapping("/updateDoctorlicensePage")
    public String updateDoctorlicensePage(@ModelAttribute("updateLicense") Doctorlicense doctorlicense) {
        doctorlicenseServise.updateDoctorlicense(doctorlicense);
        return "redirect:/hello";
    }

    //Doctor
    @RequestMapping(value = "/addDoctorPost", method = RequestMethod.POST)
    public String addDoctorPost(
            @RequestParam("birthday") String birthday,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("specialization") String specialization,
            @RequestParam("number") String licensenumber,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("house") String house,
            @RequestParam("flat") String flat

    ) {
        Doctorlicense lic_tmp = new Doctorlicense(Long.parseLong(licensenumber));
        Address address_tmp = new Address(country, city, street, Integer.parseInt(house), Integer.parseInt(flat));
        Doctor doctor = new Doctor(birthday, firstname, lastname, specialization, address_tmp, lic_tmp);
        doctorServise.addDoctor(doctor);
        return "redirect:/administrator/allDoctor/";
    }


    @RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
    public String editDoctor(
            @RequestParam("doctorid") String doctorid,
            @RequestParam("birthday") Date birthday,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("specialization") String specialization,
            @RequestParam("doctorlicense") String licensenumber,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("house") String house,
            @RequestParam("flat") String flat) {
        Doctor tmp;
        tmp = doctorServise.getDoctor(Integer.parseInt(doctorid));
        try {
            tmp.setBirthday(birthday);
        } catch (Exception x) {
            x.toString();
            System.err.println("Не правильный формат даты. Дата не изменена");
        }
        tmp.setLastname(lastname);
        tmp.setFirstname(firstname);
        tmp.getDoctorlicense().setNumber(Long.parseLong(licensenumber));
        tmp.getAddress().setCountry(country);
        tmp.setSpecialization(specialization);
        tmp.getAddress().setCity(city);
        tmp.getAddress().setStreet(street);
        tmp.getAddress().setHouse(Integer.parseInt(house));
        tmp.getAddress().setFlat(Integer.parseInt(flat));
        doctorServise.updateDoctor(tmp);
        return "redirect:/administrator/allDoctor";
    }

    //Patient
    @RequestMapping(value = "/addPatientPost", method = RequestMethod.POST)
    public String addPatientPost(
            @RequestParam("birthday") String birthday,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("medicalpolicy") String medicalpolicy,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("house") String house,
            @RequestParam("flat") String flat

    ) {
        Medicalpolicy med_tmp = new Medicalpolicy(Long.parseLong(medicalpolicy));
        Address address_tmp = new Address(country, city, street, Integer.parseInt(house), Integer.parseInt(flat));
        Patient patient = new Patient(firstname, lastname, birthday, address_tmp, med_tmp);
        patientServise.addPatient(patient);
        return "redirect:/administrator/allPatient";
    }

    @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
    public String editPatient(
            @RequestParam("patientid") String patientid,
            @RequestParam("birthday") Date birthday,
            @RequestParam("lastname") String lastname,
            @RequestParam("firstname") String firstname,
            @RequestParam("medicalpolicy") String medicalpolicy,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("house") String house,
            @RequestParam("flat") String flat) {
        Patient tmp;
        tmp = patientServise.getPatient(Integer.parseInt(patientid));
        try {
            tmp.setBirthday(birthday);
        } catch (Exception x) {
            x.toString();
            System.err.println("Не правильный формат даты. Дата не изменена");
        }
        tmp.setLastname(lastname);
        tmp.setFirstname(firstname);
        tmp.getMedicalpolicy().setNumber(Long.parseLong(medicalpolicy));
        tmp.getAddress().setCountry(country);
        tmp.getAddress().setCity(city);
        tmp.getAddress().setStreet(street);
        tmp.getAddress().setHouse(Integer.parseInt(house));
        tmp.getAddress().setFlat(Integer.parseInt(flat));
        patientServise.updatePatient(tmp);
        return "redirect:/administrator/allPatient";
    }

    //Visit
    @GetMapping("/allVisit")
    public String allVisists(Model model) {
        List<Visit> result = visitServise.sortByTime();
        model.addAttribute("lstvst", result);
        return "allVisit";
    }

    @GetMapping("/allVisit/{id}")
    public String getVisitById(@PathVariable("id") int id, Model model) {
        model.addAttribute("visit", visitServise.getVisit(id));
        return "visit";
    }

    @PostMapping("/editVisit")
    public String updateVisit(
            @RequestParam("visitid") String visitid,
            @RequestParam("dayofvisit") String dayofvisit,
            @RequestParam("doctor") String doctor,
            @RequestParam("patient") String patient

    ) {
        dayofvisit+=":00.00";
        Timestamp new_time = Timestamp.valueOf(dayofvisit.replace("T"," "));
        Visit result;
        result = visitServise.getVisit(Integer.parseInt(visitid));
        result.setDayofvisit(new_time);
        result.setDoctor(doctorServise.getDoctor(Integer.parseInt(doctor)));
        result.setPatient(patientServise.getPatient(Integer.parseInt(patient)));
        visitServise.updateVisit(result);
        return "redirect:/administrator/allVisit/" + result.getVisitid();
    }


    @PostMapping("/setDiagosis")
    public String setDiagnosis(
            @RequestParam("textdiag") String textdiag,
            @RequestParam("visitid") String visitid
    ) {
        Visit tmp = visitServise.getVisit(Integer.parseInt(visitid));
        Diagnosis tmpdiag = diagnosisServise.addDiagnosis(new Diagnosis(textdiag));
        tmp.setDiagnosis(tmpdiag);
        visitServise.updateVisit(tmp);
        return "redirect:/administrator/allVisit/" + Integer.parseInt(visitid);
    }

    @PostMapping("/updateDiagosis")
    public String updateDiagnosis(
            @RequestParam("textdiag") String textdiag,
            @RequestParam("visitid") String visitid,
            @RequestParam("diagid") String diagid
    ) {
        Visit tmp = visitServise.getVisit(Integer.parseInt(visitid));
        Diagnosis tmpdiag = diagnosisServise.getDiagnosis(Integer.parseInt(diagid));
        tmpdiag.setResultofdiagnosis(textdiag);
        tmp.setDiagnosis(tmpdiag);
        diagnosisServise.updateDiagnosis(tmpdiag);
        visitServise.updateVisit(tmp);
        return "redirect:/administrator/allVisit/" + Integer.parseInt(visitid);
    }

    @PostMapping("/addVisit")
    public String updateVisit(
            @RequestParam("dayofvisit") String dayofvisit,
            @RequestParam("doctor") String doctor,
            @RequestParam("patient") String patient

    ) {
        dayofvisit+=":00.00";
        Timestamp new_time = Timestamp.valueOf(dayofvisit.replace("T"," "));
        Visit tmp = new Visit(new_time,doctorServise.getDoctor(Integer.parseInt(doctor)),
                patientServise.getPatient(Integer.parseInt(patient)));
        visitServise.addVisit(tmp);
        return "redirect:/administrator/allVisit/" + tmp.getVisitid();
    }




}

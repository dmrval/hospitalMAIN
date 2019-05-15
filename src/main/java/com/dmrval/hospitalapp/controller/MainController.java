package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.*;
import com.dmrval.hospitalapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
@Validated
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

    @GetMapping("/")
    public String index() {
        return "allVisit";
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

    /**
     * /==================/addDoctor
     */
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
        return "redirect:/hello";
    }

    @RequestMapping(value = "/addDoctor", method = RequestMethod.GET)
    public String addDoctorGet() {
        return "addDoctor";
    }

    /**
     * /==================/addPatient
     */
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
        return "redirect:/hello";
    }

    @GetMapping("/addPatient")
    public String addPatientGet() {
        return "addPatient";
    }


    /**
     * /==================/allVisit
     */
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

}

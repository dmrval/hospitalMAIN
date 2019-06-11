package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.*;
import com.dmrval.hospitalapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Controller
@RequestMapping
public class MainController {
    @Autowired
    private DoctorlicenseService doctorlicenseService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicalpolicyService medicalpolicyService;

    @Autowired
    private VisitService visitService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private UserService UserService;

    @Autowired
    private RoleSevice roleSevice;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("licenses", doctorlicenseService.getAllDoctorlicense());
        return "hello";
    }

    @GetMapping("/createDoctorlicense")
    public String createDoctorlicense() {
        return "createDoctorlicense";
    }


    @PostMapping("/addDoctorlicensePage")
    public String addDoctorlicensePage(@ModelAttribute("tmplicense") Doctorlicense doctorlicense) {
        doctorlicenseService.addDoctorlicense(doctorlicense);
        return "redirect:/hello";
    }


    @PostMapping("/updateDoctorlicensePage")
    public String updateDoctorlicensePage(@ModelAttribute("updateLicense") Doctorlicense doctorlicense) {
        doctorlicenseService.updateDoctorlicense(doctorlicense);
        return "redirect:/hello";
    }

    //Doctor
    @RequestMapping(value = "/addDoctorPost", method = RequestMethod.POST)
    public String addDoctorPost(
            @RequestParam("birthday") String birthday,
            @RequestParam("login") String login,
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
        User user = new User(login, passwordEncoder.encode("123456"), roleSevice.findById(9));
        userService.saveUser(user);
        Doctor doctor = new Doctor(birthday, firstname, lastname, specialization, address_tmp, lic_tmp,user);
        doctorService.addDoctor(doctor);
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
        tmp = doctorService.getDoctor(Integer.parseInt(doctorid));
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
        doctorService.updateDoctor(tmp);
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
            @RequestParam("flat") String flat,
            @RequestParam("login") String login
    ) {
        Medicalpolicy med_tmp = new Medicalpolicy(Long.parseLong(medicalpolicy));
        Address address_tmp = new Address(country, city, street, Integer.parseInt(house), Integer.parseInt(flat));
        User userForPatient = new User(login, passwordEncoder.encode("123456"), roleSevice.findById(7));
        Patient patient = new Patient(firstname, lastname, birthday, address_tmp, med_tmp, userForPatient);
        patientService.addPatient(patient);
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
        tmp = patientService.getPatient(Integer.parseInt(patientid));
        try {
            tmp.setBirthday(birthday);
        } catch (Exception x) {
            x.toString();
            System.err.println("Не правильный формат даты. Дата не изменена");
        }
        tmp.setLastname(lastname);
        tmp.setFirstname(firstname);
        tmp.getMedicalpolicy().setNumber(Long.parseLong(medicalpolicy));
        Address tmpAddress = new Address();
        tmp.setAddress(tmpAddress);
        tmp.getAddress().setCountry(country);
        tmp.getAddress().setCity(city);
        tmp.getAddress().setStreet(street);
        tmp.getAddress().setHouse(Integer.parseInt(house));
        tmp.getAddress().setFlat(Integer.parseInt(flat));
        patientService.updatePatient(tmp);
        return "redirect:/administrator/allPatient";
    }

    //Visit
    @GetMapping("/allVisit")
    public String allVisists(Model model) {
        List<Visit> result = visitService.sortByTime();
        model.addAttribute("lstvst", result);
        return "allVisit";
    }

    @GetMapping("/allVisit/{id}")
    public String getVisitById(@PathVariable("id") int id, Model model) {
        model.addAttribute("visit", visitService.getVisit(id));
        return "visit";
    }

    @PostMapping("/editVisit")
    public String updateVisit(
            @RequestParam("visitid") String visitid,
            @RequestParam("dayofvisit") String dayofvisit,
            @RequestParam("doctor") String doctor,
            @RequestParam("patient") String patient

    ) {
        Visit result = visitService.getVisit(Integer.parseInt(visitid));
        try {
            result.setDayofvisit(Timestamp.valueOf(dayofvisit));
        } catch (Exception e) {
            dayofvisit += ":00.00";
            Timestamp new_time = Timestamp.valueOf(dayofvisit.replace("T", " "));
            result.setDayofvisit(new_time);
        }
        result.setDoctor(doctorService.getDoctor(Integer.parseInt(doctor)));
        result.setPatient(patientService.getPatient(Integer.parseInt(patient)));
        visitService.updateVisit(result);
        return "redirect:/administrator/allVisit/" + result.getVisitid();
    }


    @PostMapping("/setDiagosis")
    public String setDiagnosis(
            @RequestParam("textdiag") String textdiag,
            @RequestParam("visitid") String visitid
    ) {
        Visit tmp = visitService.getVisit(Integer.parseInt(visitid));
        Diagnosis tmpdiag = diagnosisService.addDiagnosis(new Diagnosis(textdiag));
        tmp.setDiagnosis(tmpdiag);
        visitService.updateVisit(tmp);
        return "redirect:/administrator/allVisit/" + Integer.parseInt(visitid);
    }

    @PostMapping("/updateDiagosis")
    public String updateDiagnosis(
            @RequestParam("textdiag") String textdiag,
            @RequestParam("visitid") String visitid,
            @RequestParam("diagid") String diagid
    ) {
        Visit tmp = visitService.getVisit(Integer.parseInt(visitid));
        Diagnosis tmpdiag = diagnosisService.getDiagnosis(Integer.parseInt(diagid));
        tmpdiag.setResultofdiagnosis(textdiag);
        tmp.setDiagnosis(tmpdiag);
        diagnosisService.updateDiagnosis(tmpdiag);
        visitService.updateVisit(tmp);
        return "redirect:/administrator/allVisit/" + Integer.parseInt(visitid);
    }

    @PostMapping("/addVisit")
    public String updateVisit(
            @RequestParam("dayofvisit") String dayofvisit,
            @RequestParam("doctor") String doctor,
            @RequestParam("patient") String patient

    ) {
        dayofvisit += ":00.00";
        Timestamp new_time = Timestamp.valueOf(dayofvisit.replace("T", " "));
        Visit tmp = new Visit(new_time, doctorService.getDoctor(Integer.parseInt(doctor)),
                patientService.getPatient(Integer.parseInt(patient)));
        visitService.addVisit(tmp);
        return "redirect:/administrator/allVisit/" + tmp.getVisitid();
    }


    //signUp

    @PostMapping("/signUp")
    public String signUpPost(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("medicalpolicy") String medicalpolicy,

            ModelMap model
    ) {
        User user = new User(login, passwordEncoder.encode(password), roleSevice.findById(7));
        if (userService.userLoginIsExist(user) || login.equals("")) {
            model.addAttribute("userIsExist", true);
            return "singUp";
        }
        if (!password.equals(password2)) {
            model.addAttribute("notdublicate", true);
            return "singUp";
        }
        Patient patient = new Patient(firstname, lastname, new Medicalpolicy(Long.parseLong(medicalpolicy)), user);
        patientService.addPatient(patient);
        return "redirect:/login";
    }


    //PATIENTCONTROLLER

    @PostMapping("/patNewPassword")
    public String signUpPost(
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("oldpass") String oldpass,
            ModelMap model,
            Principal principal
    ) {
        Patient patient = patientService.getPatientbyLogin(principal.getName());
        String currPass = passwordEncoder.encode(patient.getUser().getPassword());
        System.out.println(currPass);
        if (!password.equals(password2)) {
            model.addAttribute("notdublicate", true);
            return "pat_newPassword";
        }
        if (!passwordEncoder.matches(oldpass, patient.getUser().getPassword())) {
            model.addAttribute("wrongoldpass", true);
            return "pat_newPassword";
        }
        patient.getUser().setPassword(passwordEncoder.encode(password));
        patientService.updatePatient(patient);
        return "redirect:/login";
    }


    @PostMapping("/pat_patSettings")
    public String getPat_SettingsPost(
            @RequestParam("birthday") Date birthday,
            @RequestParam("lastname") String lastname,
            @RequestParam("firstname") String firstname,
            @RequestParam("medicalpolicy") String medicalpolicy,
            @RequestParam("country") String country,
            @RequestParam("city") String city,
            @RequestParam("street") String street,
            @RequestParam("house") String house,
            @RequestParam("flat") String flat,
            Principal principal
    ) {
        Patient tmp = patientService.getPatientbyLogin(principal.getName());
        try {
            tmp.setBirthday(birthday);
        } catch (Exception x) {
            x.toString();
            System.err.println("Не правильный формат даты. Дата не изменена");
        }
        tmp.setLastname(lastname);
        tmp.setFirstname(firstname);
        tmp.getMedicalpolicy().setNumber(Long.parseLong(medicalpolicy));
        Address address = new Address();
        tmp.setAddress(address);
        tmp.getAddress().setCountry(country);
        tmp.getAddress().setCity(city);
        tmp.getAddress().setStreet(street);
        tmp.getAddress().setHouse(Integer.parseInt(house));
        tmp.getAddress().setFlat(Integer.parseInt(flat));
        patientService.updatePatient(tmp);
        return "redirect:/patient";
    }

    @PostMapping("/patAddvisit")
    public String getPatAddvisit(
            @RequestParam String currTime,
            Principal principal,
            @RequestParam String doctor
    ) {
        Timestamp t = visitService.getWorkCalendar().getWorkCalendar().get(Integer.parseInt(currTime));
        Visit visit = new Visit(t, doctorService.getDoctor(Integer.parseInt(doctor)), patientService.getPatientbyLogin(principal.getName()));
        visitService.addVisit(visit);
        return "redirect:/patient/allVisits";
    }

    //DOCTORCONTROLLER

    @PostMapping("/docAddvisit")
    public String getDocAddvisit(
            @RequestParam String currTime,
            Principal principal,
            @RequestParam String patient
    ) {
        Doctor current = doctorService.getDoctorbyLogin(principal.getName());
        Timestamp t = visitService.getWorkCalendar().getWorkCalendar().get(Integer.parseInt(currTime));
        Visit visit = new Visit(t, current, patientService.getPatient(Integer.parseInt(patient)));
        visitService.addVisit(visit);
        return "redirect:/doctor/allVisits";
    }

    @PostMapping("/docNewPassword")
    public String signUpPostForDoc(
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            @RequestParam("oldpass") String oldpass,
            ModelMap model,
            Principal principal
    ) {
        Doctor doctor = doctorService.getDoctorbyLogin(principal.getName());
        String currPass = passwordEncoder.encode(doctor.getUser().getPassword());
        System.out.println(currPass);
        if (!password.equals(password2)) {
            model.addAttribute("notdublicate", true);
            return "doc_newPassword";
        }
        if (!passwordEncoder.matches(oldpass, doctor.getUser().getPassword())) {
            model.addAttribute("wrongoldpass", true);
            return "doc_newPassword";
        }
        doctor.getUser().setPassword(passwordEncoder.encode(password));
        userService.updateUser(doctor.getUser());
        return "redirect:/login";
    }

    @RequestMapping(value = "/doc_docSettings", method = RequestMethod.POST)
    public String editDoctorbyDoc(
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
        tmp = doctorService.getDoctor(Integer.parseInt(doctorid));
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
        doctorService.updateDoctor(tmp);
        return "redirect:/doctor";
    }


}





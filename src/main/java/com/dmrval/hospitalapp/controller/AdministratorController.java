package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.*;
import com.dmrval.hospitalapp.service.DoctorService;
import com.dmrval.hospitalapp.service.PatientService;
import com.dmrval.hospitalapp.service.UserService;
import com.dmrval.hospitalapp.service.VisitService;
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
  @Autowired private VisitService visitService;

  @Autowired private PatientService patientService;

  @Autowired private DoctorService doctorService;

  @Autowired private UserService userService;

  // Mainpanel
  @GetMapping("")
  public String allVisistsMain() {
    return "adm_MainPanel";
  }

  // Visits
  @GetMapping("/allVisits")
  public String allVisists(Model model) {
    List<Visit> result = visitService.sortByTime();
    model.addAttribute("lstvst", result);
    return "adm_allVisits";
  }

  @GetMapping("/allVisits/{id}")
  public String getVisitById(@PathVariable("id") int id, Model model) {
    model.addAttribute("isADMIN", true);
    model.addAttribute("visit", visitService.getVisit(id));
    return "visit";
  }

  @GetMapping("/delete/{id}")
  public String deleteVisitGET(@PathVariable("id") int id) {
    visitService.removeVisit(id);
    return "redirect:/administrator/allVisits";
  }

  @GetMapping("/addVisit")
  public String addVisit(Model model) {
    model.addAttribute("doclist", doctorService.getAllDoctor());
    model.addAttribute("patlist", patientService.getAllPatient());
    return "addVisit";
  }

  @GetMapping("/update/{id}")
  public String updateVisit(@PathVariable("id") int id, Model model) {
    model.addAttribute("doclist", doctorService.getAllDoctor());
    model.addAttribute("patlist", patientService.getAllPatient());
    model.addAttribute("visit", visitService.getVisit(id));
    return "adm_editVisit";
  }

  @GetMapping("/allVisits/{id}/setDiagosis")
  public String setDiagnisis(@PathVariable("id") int id, Model model) {
    model.addAttribute("isADMIN", true);
    model.addAttribute("visit", visitService.getVisit(id));
    model.addAttribute("diag", visitService.getVisit(id).getDiagnosis());
    return "setDiagnosis";
  }

  @GetMapping("/allVisits/{id}/updateDiagnosis")
  public String updateDiagnisis(@PathVariable("id") int id, Model model) {
    model.addAttribute("isADMIN", true);
    model.addAttribute("diag", visitService.getVisit(id).getDiagnosis());
    model.addAttribute("visit", visitService.getVisit(id));
    return "updateDiagnosis";
  }

  // Patient
  @GetMapping("/allPatients")
  public String allPatients(Model model) {
    List<Patient> result = patientService.getAllPatient();
    model.addAttribute("lstpatient", result);
    return "adm_allPatients";
  }

  @GetMapping("/addPatient")
  public String addPatientGet() {
    return "addPatient";
  }

  @GetMapping("/allPatients/delete/{id}")
  public String deletePatient(@PathVariable("id") int id, Model model) {
    Patient tmp = patientService.getPatient(id);
    if (visitService.getAllVisit_ByOnePatient(tmp).size() != 0) {
      model.addAttribute("notEmpty", true);
      List<Patient> result = patientService.getAllPatient();
      model.addAttribute("lstpatient", result);
      return "adm_allPatients";
    }
    Patient r = patientService.getPatient(id);
    r.getUser().setState(State.NOTACTIVE);
    patientService.updatePatient(r);
    patientService.removePatient(id);
    return "redirect:/administrator/allPatients";
  }

  @GetMapping("/allPatients/update/{id}")
  public String editPatient(@PathVariable("id") int id, Model model) {
    Patient patient = patientService.getPatient(id);
    model.addAttribute("patient", patient);
    return "adm_editPatient";
  }

  // Doctor
  @GetMapping("/allDoctors")
  public String allDoctor(Model model) {
    List<Doctor> result = doctorService.getAllDoctor();
    model.addAttribute("lstdoctor", result);
    return "adm_allDoctors";
  }

  @RequestMapping(value = "/addDoctor", method = RequestMethod.GET)
  public String addDoctorGet() {
    return "addDoctor";
  }

  @GetMapping("/allDoctors/delete/{id}")
  public String deleteDoctor(@PathVariable("id") int id, Model model) {
    Doctor tmp = doctorService.getDoctor(id);
    if (visitService.getAllVisit_ByOneDoctor(tmp).size() != 0) {
      model.addAttribute("notEmpty", true);
      List<Doctor> result = doctorService.getAllDoctor();
      model.addAttribute("lstdoctor", result);
      return "adm_allDoctors";
    }
    User user = doctorService.getDoctor(id).getUser();
    user.setState(State.NOTACTIVE);
    userService.updateUser(user);
    doctorService.removeDoctor(id);
    return "redirect:/administrator/allDoctors";
  }

  @GetMapping("/allDoctors/update/{id}")
  public String editDoctor(@PathVariable("id") int id, Model model) {
    model.addAttribute("doctor", doctorService.getDoctor(id));
    return "adm_editDoctor";
  }
}

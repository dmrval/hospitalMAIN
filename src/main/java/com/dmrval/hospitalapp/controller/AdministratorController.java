package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.entity.Visit;
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

    @GetMapping("")
    public String allVisistsMain(Model model) {
        List<Visit> result = visitServise.sortByTime();
        model.addAttribute("lstvst", result);
        return "adm_allVisit";
    }
    /**
     * /==================/allVisit
     */
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

//    @RequestMapping(value = "/administrator/delete/{id}", method = RequestMethod.POST)
//    public String deleteVisitPOST(@PathVariable("id") int id) {
//        visitServise.removeVisit(id);
//        return "adm_visit";
//    }

//    @RequestMapping(value = "/administrator/delete/{id}", method = RequestMethod.GET)
    @GetMapping("/delete/{id}")
    public String deleteVisitGET(@PathVariable("id") int id) {
        visitServise.removeVisit(id);
        return "redirect:/administrator";
    }



}

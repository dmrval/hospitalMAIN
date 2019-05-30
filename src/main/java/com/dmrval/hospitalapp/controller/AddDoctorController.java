package com.dmrval.hospitalapp.controller;

import com.dmrval.hospitalapp.service.AddressService;
import com.dmrval.hospitalapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/addDoctor")
public class AddDoctorController {

    @Autowired
    AddressService addressServise;

    @Autowired
    DoctorService doctorServise;

    @GetMapping("/addDoctor")
    public String index() {
        return "addDoctor";
    }

    @RequestMapping(value = "/createDoctor", method = RequestMethod.GET)
    public String addDoctorAddressGet() {
        return "/addDoctor";
    }




}

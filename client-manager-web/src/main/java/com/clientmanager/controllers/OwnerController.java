package com.clientmanager.controllers;


import com.clientmanager.model.Owner;
import com.clientmanager.services.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;


@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners(Model model){

        Set<Owner> ownerList = ownerService.findAll();
        model.addAttribute("owners", ownerList);
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String findOwners(){
        return "notImplemented";
    }

    @RequestMapping({"/{ownerId}"})
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){

        ModelAndView mov = new ModelAndView("owners/ownerDetails");
        mov.addObject("owner", ownerService.findById(ownerId));
        return mov;
    }
}

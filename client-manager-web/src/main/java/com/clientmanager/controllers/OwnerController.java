package com.clientmanager.controllers;


import com.clientmanager.model.Owner;
import com.clientmanager.services.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String notFoundHandler (){
        return "notImplemented";
    }
}

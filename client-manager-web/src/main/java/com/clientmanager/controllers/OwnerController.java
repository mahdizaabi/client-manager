package com.clientmanager.controllers;


import com.clientmanager.model.Owner;
import com.clientmanager.services.OwnerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;


@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;
    private static final String CREATE_UPDATE_OWNER_TEMPLATE = "owners/createOrUpdateOwnerForm";

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    /*
    @GetMapping({"", "/index", "/index.html"})
    public String listOwners(Model model){

        Set<Owner> ownerList = ownerService.findAll();
        model.addAttribute("owners", ownerList);
        return "owners/index";
    }*/

    @GetMapping({"/find"})
    public String findOwners(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping()
    public String processIncomingRequestToFindOwnerOrOwners(Owner owner, BindingResult result,
                                                            Model model) {
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }
        //find owners or owner:
        Set<Owner> findResult = ownerService.findAllByLastName("%" + owner.getLastName() + "%");
        if (findResult.isEmpty() && !owner.getLastName().equals("")) {
            result.rejectValue("lastName", "not found", "not found");
            return "owners/findOwners";
        }
        if (findResult.size() == 1) {
            return ("redirect:/owners/" + findResult.iterator().next().getId());
        } else {
            Set<Owner> allOwners = ownerService.findAll();
            model.addAttribute("selections", allOwners);
            return "owners/ownersList";
        }
    }

    @GetMapping({"/{ownerId}"})
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {

        ModelAndView mov = new ModelAndView("owners/ownerDetails");
        mov.addObject("owner", ownerService.findById(ownerId));
        return mov;
    }

    @GetMapping({"/new"})
    public String initFormCreation(Model model) {
        model.addAttribute("owner", new Owner());
        return CREATE_UPDATE_OWNER_TEMPLATE;
    }

    @PostMapping("/new")
    public String collectDataAndSendIt(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return CREATE_UPDATE_OWNER_TEMPLATE;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    //initilize the edit form
    @GetMapping("{ownerId}/edit")
    public String initUpdateEditOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
        Owner owner = ownerService.findById(ownerId);
        model.addAttribute("owner", owner);
        return CREATE_UPDATE_OWNER_TEMPLATE;
    }

    @PostMapping("{ownerId}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId) {
        if (result.hasErrors()) {
            return CREATE_UPDATE_OWNER_TEMPLATE;
        } else {
            //id is not binded on the owner object(we excluded it for security reason)
            //set id explicitly::
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return ("redirect:/owners/" + savedOwner.getId());
        }

    }
}

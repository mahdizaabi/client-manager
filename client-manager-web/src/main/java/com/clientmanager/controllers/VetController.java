package com.clientmanager.controllers;


import com.clientmanager.services.VetService;
import com.clientmanager.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String   getVets(Model model){
        return "vets/index";
    }
}

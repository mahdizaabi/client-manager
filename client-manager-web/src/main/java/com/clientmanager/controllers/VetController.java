package com.clientmanager.controllers;
import com.clientmanager.model.Vet;
import com.clientmanager.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets.html", "/vets/index", "/vets/index.html"})
    public String getVets(Model model){
        Set<Vet> vetList = vetService.findAll();
        model.addAttribute("vetList", vetList);
        return "vets/index";
    }
}

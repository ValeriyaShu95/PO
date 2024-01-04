package org.example.controllers;

import org.example.models_entities.Templates;
import org.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private MaterialsRepo materialsRepo;


    private SizeRepo sizeRepo;
    private TemplatesRepo templatesRepo;



    @Autowired
    public MainController (MaterialsRepo materialsRepo,
                            SizeRepo sizeRepo, TemplatesRepo templatesRepo ){
        this.materialsRepo = materialsRepo;
        this.sizeRepo = sizeRepo;
        this.templatesRepo = templatesRepo;
    }

//    @GetMapping("/")
//    public String home() {
//        return "mainpage";
//    }



//    @PostMapping("templates/final")
//    public String materialChoosePost(@RequestParam Long idMaterials, @RequestParam Long minAmount,  @RequestParam String templateName, @RequestParam String templateSize) {
//        Templates templates = new Templates(idMaterials, minAmount, templateName, templateSize);
//        templatesRepo.save(templates);
//        return "templatesFinal";
//    }
//    @GetMapping("/templates/choose")
//    public String materialChoose(Model model) {
//        return "templatesChooseGet";
//    }




}

package org.example.controllers;


import org.example.models_entities.Cut;
import org.example.models_entities.Materials;
import org.example.models_entities.Size;
import org.example.repositories.MaterialsRepo;
import org.example.repositories.SizeRepo;
import org.example.repositories.TemplatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MaterialController {
    private MaterialsRepo materialsRepo;
    private final TemplatesRepo templatesRepo;

    @Autowired
    public MaterialController(MaterialsRepo materialsRepo,
                              TemplatesRepo templatesRepo) {
        this.materialsRepo = materialsRepo;
        this.templatesRepo = templatesRepo;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseMaterial")
    public List<Materials> materialsChoose(Model model) {
        List<Materials> materialsList = (List<Materials>) materialsRepo.findAll();
        System.out.println("материал");
        return materialsList;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseExectMaterial")
    public List<String> materialsChooseExect(@RequestParam Long idTemplate) {
//        System.out.println("------   chooseExectMaterial " + idTemplate);
        List<Long> idMaterialsList = templatesRepo.findById(idTemplate).get().getIdMaterials();
//        System.out.println("------   idMaterialsList " + idMaterialsList);
        List<String> materialsList = materialsRepo.exectMaterail(idMaterialsList);
//        System.out.println("------   materialsList " + materialsList);
        return materialsList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addMaterials")
    public ResponseEntity<String> addMaterials(@RequestParam String nameMaterial,
                                               @RequestParam int idSizeMaterial, @RequestParam BigDecimal priceMaterial) {
        try {
            Materials materials = new Materials(nameMaterial, idSizeMaterial, priceMaterial);
            materialsRepo.save(materials);
            return ResponseEntity.ok("Данные успешно добавлены!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении данных в базу.");
        }

    }
}

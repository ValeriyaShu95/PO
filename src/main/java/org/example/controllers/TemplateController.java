package org.example.controllers;

import org.example.models_entities.Materials;
import org.example.models_entities.Size;
import org.example.models_entities.Templates;
import org.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TemplateController {
    private TemplatesRepo templatesRepo;
    private final SizeRepo sizeRepo;
    private final MaterialsRepo materialsRepo;

    @Autowired
    public TemplateController(TemplatesRepo templatesRepo,
                              SizeRepo sizeRepo,
                              MaterialsRepo materialsRepo) {
        this.templatesRepo = templatesRepo;
        this.sizeRepo = sizeRepo;
        this.materialsRepo = materialsRepo;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseName")
    public List<Templates> nameChoose(Model model) {
        System.out.println("1");
        List<Templates> nameList = (List<Templates>) templatesRepo.findAll();
        System.out.println("2");
        return nameList;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/submitTemplate")
    public String materialChoose3(Model model) {
        return "sucess12344";// расписать, что он с этими данными сделает, что вернет
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/addTemplate")
    public ResponseEntity<String> addTemplate(@RequestParam List<Long> idSize, @RequestParam List<Long> idMaterials,
                                              @RequestParam String nameTemplate) {
        try {
            Templates t = new Templates(idSize, idMaterials, nameTemplate);
            templatesRepo.save(t);
            return ResponseEntity.ok("Данные успешно добавлены!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении данных в базу.");
        }
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/getSizeTemplate") //отдает все размеры, которые подходят для этого шаблона
    public List<Size> getSizeTemplate(@RequestParam long idTemplate) {
        Templates sizeTemplate = templatesRepo.findById(idTemplate).get();
        List<Long> idSizeList = sizeTemplate.getIdSize();
        ArrayList<Size> sizes = new ArrayList<>();
        for (int i = 0; i < idSizeList.size(); i++) {
            sizes.add(sizeRepo.findById(idSizeList.get(i)).get());
        }

        return sizes;

    }

    @CrossOrigin(origins = "*")
    @PostMapping("/getMaterialTemplate") //отдает все размеры, которые подходят для этого шаблона
    public List<Materials> getMaterialTemplate(@RequestParam long idTemplate) {
        Templates materialTemplate = templatesRepo.findById(idTemplate).get();
        List<Long> idMaterialList = materialTemplate.getIdMaterials();
        System.out.println(idMaterialList);
        ArrayList<Materials> materials = new ArrayList<>();
        for (int i = 0; i < idMaterialList.size(); i++) {
            System.out.println(i);
            materials.add(materialsRepo.findById(idMaterialList.get(i)).get());
        }
        return materials;

    }


}
//на вход id шаблонов, на выход list ыize}

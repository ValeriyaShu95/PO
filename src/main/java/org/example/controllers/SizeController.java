package org.example.controllers;

import org.example.models_entities.Size;
import org.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class SizeController {
    private final SizeRepo sizeRepo;
    private final TemplatesRepo templatesRepo;
    private final MaterialsRepo materialsRepo;


    @Autowired
    public SizeController(SizeRepo sizeRepo, TemplatesRepo templatesRepo, MaterialsRepo materialsRepo) {
        this.sizeRepo = sizeRepo;
        this.templatesRepo = templatesRepo;
        this.materialsRepo = materialsRepo;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseSize")
    public List<Size> sizeChoose(Model model) {
        List<Size> sizeList = (List<Size>) sizeRepo.findAll();
        return sizeList;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseExectSizes")
    public List<Size> materialsChooseExect(@RequestParam Long idTemplate, @RequestParam String nameMaterial) {
        System.out.println("------   STAAAAART ");
        System.out.println("------   chooseExectMaterial " + idTemplate);
        List<Long> sizes1 = templatesRepo.findById(idTemplate).get().getIdSize();
        System.out.println("------   sizes1 " + sizes1);
        List<Long> sizes2 = materialsRepo.findSizes(nameMaterial);
        System.out.println("------   sizes2 " + sizes2);

        Set<Long> set1 = new HashSet<>(sizes1);
        Set<Long> set2 = new HashSet<>(sizes2);

        // Операция пересечения множеств
        set1.retainAll(set2);

        // Преобразование обратно в список
        List<Long> commonSizes = new ArrayList<>(set1);

        // Вывод содержимого списка с общими элементами
        System.out.println("Common Sizes: " + commonSizes);

        List<Size> sizeList = (List<Size>) sizeRepo.findAllById(commonSizes);
        System.out.println(sizeList);


        return sizeList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addSize")
    public ResponseEntity<String> addMaterials(@RequestParam String type, @RequestParam long idSize,
                                               @RequestParam int widh, @RequestParam int length) {
        try {
            Size size2 = new Size(type, idSize, widh, length);
            sizeRepo.save(size2);
            return ResponseEntity.ok("Данные успешно добавлены!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении данных в базу.");
        }
    }
}

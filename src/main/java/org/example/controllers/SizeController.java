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

import java.math.BigDecimal;
import java.util.List;


@RestController
public class SizeController {
    private final SizeRepo sizeRepo;


    @Autowired
    public SizeController(SizeRepo sizeRepo) {
        this.sizeRepo = sizeRepo;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseSize")
    public List<Size> sizeChoose(Model model) {
        List<Size> sizeList = (List<Size>) sizeRepo.findAll();
        System.out.println("Запрос!!!");
        return sizeList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addSize")
    public ResponseEntity<String> addMaterials(@RequestParam String type, @RequestParam int size,
                                               @RequestParam int widh, @RequestParam int length) {
        try {
            Size size2 = new Size(type, size, widh, length);
            sizeRepo.save(size2);
            return ResponseEntity.ok("Данные успешно добавлены!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении данных в базу.");
        }
    }
}

package org.example.controllers;


import org.example.models_entities.Cut;
import org.example.models_entities.Size;
import org.example.repositories.CutRepo;
import org.example.repositories.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CutController {
    private final CutRepo cutRepo;

    @Autowired
    public CutController (CutRepo cutRepo){
        this.cutRepo = cutRepo;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/chooseCut")
    public List<Cut> cutChoose(Model model) {
        List<Cut> cutList = (List<Cut>) cutRepo.findAll();
        System.out.println("Cut");
        return cutList;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/addCut")
    public ResponseEntity<String> addCut(@RequestParam BigDecimal cutPrice,
                                         @RequestParam int amountCut, @RequestParam long sizeFrom, @RequestParam long sizeTo) {
        try {

            Cut cut = new Cut (cutPrice, amountCut, sizeFrom, sizeTo);
            cutRepo.save(cut);
            return ResponseEntity.ok("Данные успешно добавлены!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении данных в базу.");
        }
    }
}

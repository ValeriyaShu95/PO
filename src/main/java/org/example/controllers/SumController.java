package org.example.controllers;


import org.example.models_entities.Materials;
import org.example.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class SumController {
    private MaterialsRepo materialsRepo;

    private SizeRepo sizeRepo;
    private TemplatesRepo templatesRepo;
    private final CutRepo cutRepo;
    private final PrintingRepo printingRepo;

    @Autowired
    public SumController(MaterialsRepo materialsRepo,
                         SizeRepo sizeRepo, TemplatesRepo templatesRepo,
                         CutRepo cutRepo,
                         PrintingRepo printingRepo) {
        this.materialsRepo = materialsRepo;
        this.sizeRepo = sizeRepo;
        this.templatesRepo = templatesRepo;
        this.cutRepo = cutRepo;
        this.printingRepo = printingRepo;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/templates/sum")
    private BigDecimal sum(@RequestParam long idTemplate, @RequestParam long idSize, @RequestParam long idMaterial,
                           @RequestParam int amount) {
        BigDecimal priceMaterial = materialsRepo.findById(idMaterial).get().getPriceMaterial(); // цена материала
        int cutAmount = cutRepo.findSizeToAndSizeFrom(4, sizeRepo.findById(idSize).get().getSize());
        BigDecimal printing = printingRepo.findIdSize(idSize);

        long finalCutAmount = amount / cutAmount; // нужно умножать не amount, а кол-во листов А4
        if (amount % cutAmount > 0){
            finalCutAmount = finalCutAmount + cutAmount; // добавляем сколько раз нужно резать
        }

        BigDecimal finalSum = priceMaterial.multiply(BigDecimal.valueOf(amount))
                .add(BigDecimal.valueOf(cutAmount).multiply(BigDecimal.valueOf(amount)))
                .add(printing.multiply(BigDecimal.valueOf(amount)));

        return finalSum;

    }
}
//метод получения по шаблону, получение доступных сайзов и материалов
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
    @GetMapping("/templates/sum")
    private BigDecimal sum(@RequestParam long idTemplate,
                           @RequestParam long idSize,
                           @RequestParam String nameMaterial,
                           @RequestParam int amount) {
        BigDecimal priceMaterial = materialsRepo.getPrice(nameMaterial, idSize); // получение цены по 2
        // параметрам name и size
        int cutAmount = cutRepo.findSizeFromAndSizeTo(4, idSize);
        BigDecimal printingPrice = printingRepo.findPrintingPrice(idSize);
        int cutAmountSquare = cutAmount * cutAmount;

        long paperAmount = amount / cutAmountSquare;
        if (amount % cutAmountSquare > 0){
            paperAmount = paperAmount + 1;
        }

        BigDecimal finalSum = priceMaterial.multiply(BigDecimal.valueOf(paperAmount)) // стоимость материалов
                .add(BigDecimal.valueOf(paperAmount*cutAmount)) // стоимость резки
                .add(printingPrice.multiply(BigDecimal.valueOf(amount))); // стоимость печати

        return finalSum;

    }
}
//метод получения по шаблону, получение доступных сайзов и материалов
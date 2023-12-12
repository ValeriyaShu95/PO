package org.example.controllers;

import org.example.models_entities.Cut;
import org.example.models_entities.Materials;
import org.example.models_entities.Printing;
import org.example.repositories.CutRepo;
import org.example.repositories.PrintingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PrintingController {
    private final PrintingRepo printingRepo;

    @Autowired
    public PrintingController (PrintingRepo printingRepo){
        this.printingRepo = printingRepo;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/templates/choosePrinting")
    public List<Printing> printingChoose(Model model) {
        List<Printing> printingList = (List<Printing>) printingRepo.findAll();
        System.out.println("Printing");
        return printingList;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addPrinting")
    public ResponseEntity<String> addPrinting(@RequestParam BigDecimal printingPrice, @RequestParam long idSize) {
        try {
            Printing printing = new Printing(printingPrice, idSize);
            printingRepo.save(printing);
            return ResponseEntity.ok("Данные успешно добавлены!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении данных в базу.");
        }
    }
}

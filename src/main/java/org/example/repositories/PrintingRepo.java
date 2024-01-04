package org.example.repositories;

import org.example.models_entities.Cut;
import org.example.models_entities.Printing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface PrintingRepo extends CrudRepository<Printing, Long> {

    @Query("SELECT s.printingPrice FROM Printing s WHERE s.idSize = :idSize")
    BigDecimal findPrintingPrice(long idSize);

}


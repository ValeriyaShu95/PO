package org.example.repositories;

import org.example.models_entities.Cut;
import org.example.models_entities.Materials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface CutRepo extends CrudRepository<Cut, Long> {

    @Query("SELECT c.amountCut FROM Cut c WHERE c.sizeFrom = :par1 AND c.sizeTo = :par2")
    int findSizeToAndSizeFrom(int par1, int par2);
    }

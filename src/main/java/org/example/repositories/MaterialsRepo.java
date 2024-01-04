package org.example.repositories;
import org.example.models_entities.Materials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface MaterialsRepo extends CrudRepository<Materials, Long> {

    @Query("SELECT DISTINCT m.nameMaterial FROM Materials m WHERE m.idMaterial IN (:ids)")
    List<String> exectMaterail(@Param("ids") List<Long> ids);


    @Query("SELECT DISTINCT m.idSizeMaterial FROM Materials m WHERE m.nameMaterial = :nameMaterial")
    List<Long> findSizes(@Param("nameMaterial") String nameMaterial);


    @Query("SELECT priceMaterial FROM Materials m WHERE m.nameMaterial = :nameMaterial and m.idSizeMaterial = :idSize")
    BigDecimal getPrice(@Param("nameMaterial") String nameMaterial, @Param("idSize") Long idSize);
}

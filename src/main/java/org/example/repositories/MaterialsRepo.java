package org.example.repositories;
import org.example.models_entities.Materials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MaterialsRepo extends CrudRepository<Materials, Long> {

//    @Query("SELECT m.materialPrice FROM Material m WHERE m.materialName = :materialName")
//    Double findMaterialPriceByName(@Param("materialName") String materialName);
//
//
//
//    @Query(value = "SELECT "
//            + " new org.example.models_entities.Materials(m.size as int, m.materialPrice,  p.calorieIndexIn100) as caloriesAmount)  "
//            + "FROM Materials as m "
//            + " join Products as p ON c.nameOfProduct = p.nameOfProducts "
//            + "group by c.date")
//    List<Statistic> statistic();
//
//    @Query(nativeQuery = true, value = "SELECT c.date FROM client_food c WHERE c.name_of_product = :product")
//    List<Date> getDate(@Param("product") String product); // это параметр для фильтрации
}

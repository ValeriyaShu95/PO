package org.example.repositories;
import org.example.models_entities.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepo extends CrudRepository<Size, Long> {
}

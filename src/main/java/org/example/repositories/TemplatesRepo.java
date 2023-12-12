package org.example.repositories;
import org.example.models_entities.Templates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplatesRepo extends CrudRepository<Templates, Long> {
}

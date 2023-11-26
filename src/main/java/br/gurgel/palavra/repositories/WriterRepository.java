package br.gurgel.palavra.repositories;

import br.gurgel.palavra.domain.Writer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends MongoRepository<Writer, String> {

}

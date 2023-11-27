package br.gurgel.palavra.services;

import br.gurgel.palavra.domain.Writer;
import br.gurgel.palavra.repositories.WriterRepository;
import br.gurgel.palavra.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public List<Writer> findAll(){
        return writerRepository.findAll();
    }

    public Writer findById(String id){
        Optional<Writer> writer = writerRepository.findById(id);
        return writer.orElseThrow(() -> new ObjectNotFoundException("Escritor não encontrado"));
    }

    public Writer insert(Writer writer){
        return writerRepository.insert(writer);
    }

    public void delete(String id){
        findById(id);
        writerRepository.deleteById(id);
    }
}

package br.gurgel.palavra.services;

import br.gurgel.palavra.domain.Writer;
import br.gurgel.palavra.dto.WriterDTO;
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

    public Writer update(Writer writer){
        Writer newWriter = findById(writer.getId());
        updateData(newWriter, writer);
        return writerRepository.save(newWriter);
    }

    private void updateData(Writer newWriter, Writer writer){
        newWriter.setEmail(writer.getEmail());
        newWriter.setPseudonym(writer.getPseudonym());
    }

    public Writer fromDTO (WriterDTO writerDTO){
        return new Writer(writerDTO.getId(), writerDTO.getPseudonym(), writerDTO.getEmail(), writerDTO.getPassword());
    }
}


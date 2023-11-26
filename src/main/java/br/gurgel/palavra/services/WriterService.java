package br.gurgel.palavra.services;

import br.gurgel.palavra.domain.Writer;
import br.gurgel.palavra.repositories.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public List<Writer> findAll(){
        return writerRepository.findAll();
    }
}

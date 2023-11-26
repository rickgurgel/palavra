package br.gurgel.palavra.resources;

import br.gurgel.palavra.domain.Writer;
import br.gurgel.palavra.dto.WriterDTO;
import br.gurgel.palavra.services.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/writers")
public class WriterResources {

    @Autowired
    private WriterService writerService;

    @GetMapping
    public ResponseEntity<List<Writer>> findAll(){
        List<Writer> writersList = writerService.findAll();
        return ResponseEntity.ok().body(writersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WriterDTO> findById(@PathVariable String id){
        Writer writer = writerService.findById(id);
        return ResponseEntity.ok().body(new WriterDTO(writer));
    }

}

package br.gurgel.palavra.resources;

import br.gurgel.palavra.domain.Writer;
import br.gurgel.palavra.dto.WriterDTO;
import br.gurgel.palavra.services.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.WildcardType;
import java.net.URI;
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

    @PostMapping(value="/register")
    public ResponseEntity<WriterDTO> insert(@RequestBody Writer writer){
        writer = writerService.insert(writer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(writer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/exclude/{id}")
    public ResponseEntity<WriterDTO> delete(@PathVariable String id){
        writerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/update-data/{id}")
    public ResponseEntity<Void> update(@RequestBody WriterDTO writerDTO,@PathVariable String id){
        Writer writer = writerService.fromDTO(writerDTO);
        writer.setId(id);
        writer = writerService.update(writer);
        return ResponseEntity.noContent().build();
    }
}

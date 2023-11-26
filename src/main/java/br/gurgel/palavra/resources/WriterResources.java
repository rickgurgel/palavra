package br.gurgel.palavra.resources;

import br.gurgel.palavra.domain.Writer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/writers")
public class WriterResources {

    @GetMapping
    public ResponseEntity<List<Writer>> findAll(){
        Writer ricardo = new Writer("1", "morley", "ricardo@gmail.com", "hesoyam");
        Writer felipe = new Writer("1", "ciaran", "felipe@gmail.com", "hesoyam2");
        List<Writer> writersList = new ArrayList<>(Arrays.asList(ricardo, felipe));
        return ResponseEntity.ok().body(writersList);
    }
}

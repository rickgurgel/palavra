package br.gurgel.palavra.dto;

import br.gurgel.palavra.domain.Writer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class WriterDTO implements Serializable {

    private String id;
    private String pseudonym;
    private String email;

    public WriterDTO(Writer writer){
        id = writer.getId();
        pseudonym = writer.getPseudonym();
        email = writer.getEmail();
    }
}

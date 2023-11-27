package br.gurgel.palavra.dto;

import br.gurgel.palavra.domain.Writer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WriterDTO implements Serializable {

    private String id;
    private String pseudonym;
    private String email;
    private String password;

    public WriterDTO(Writer writer){
        id = writer.getId();
        pseudonym = writer.getPseudonym();
        email = writer.getEmail();
    }
}

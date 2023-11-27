package br.gurgel.palavra.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Writer implements Serializable {

    @Id
    private String id;
    private String pseudonym;
    private String email;
    private String password;
}

package br.gurgel.palavra.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Writer implements Serializable {

    private String id;
    private String pseudonym;
    private String email;
    private String password;
}

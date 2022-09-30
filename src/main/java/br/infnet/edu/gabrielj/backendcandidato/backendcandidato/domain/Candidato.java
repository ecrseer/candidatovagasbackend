package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Candidato extends Usuario {

    long cpf;
    final String tipo = "C";


    @OneToMany(mappedBy = "candidatoFk", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference(value="candidatoResposta")
    private List<RespostaVaga> respostas;

}


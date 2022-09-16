package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resposta {
    @Id
    long idResposta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criterioFK")
    @JsonBackReference(value = "criterioFK")
    @PrimaryKeyJoinColumn
    Criterio criterio;

    private int conhecimento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respostaCriterioFk")
    @JsonBackReference
    RespostaVaga respostaCriterioFk;
}

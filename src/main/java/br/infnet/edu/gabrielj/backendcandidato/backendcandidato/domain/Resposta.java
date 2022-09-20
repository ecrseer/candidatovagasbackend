package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idResposta;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criterioFk")
    @JsonBackReference(value = "criterioFk")
    Criterio criterioFk;*/

    long criterioFk;

    private int conhecimento;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respostaCriterioFk")
    @JsonBackReference(value = "respostaCriterioFk")
    RespostaVaga respostaCriterioFk;
}

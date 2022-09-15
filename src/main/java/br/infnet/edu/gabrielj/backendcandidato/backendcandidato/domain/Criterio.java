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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "criterio")
public class Criterio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idCriterio;
    String descricao;
    int perfilMinimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vagaFk")
    @JsonBackReference
    Vaga vagaFk;

}

package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RespostaVaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRespostaVaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vagaFk")
    @JsonBackReference(value = "respostaVagas")
    private Vaga vagaFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidatoFk")
    @JsonBackReference
    private Candidato candidatoFk;

    @OneToMany(mappedBy = "respostaCriterioFk", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference(value = "respostaCriterio")
    private List<Resposta> respostas;

}

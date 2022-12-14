package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RespostaVaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRespostaVaga;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vagaFk")
    @JsonBackReference(value = "respostaVagas")
    private Vaga vagaFk;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidatoFk")
    @JsonBackReference(value = "candidatoResposta")
    private Candidato candidatoFk;

    @OneToMany(mappedBy = "respostaCriterioFk", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference(value = "respostaCriterioFk")
    private List<Resposta> respostas;

}

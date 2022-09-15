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

@Entity(name = "vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vaga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idVaga;
    String cargo;


    @OneToMany(mappedBy = "vagaFk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Criterio> criterios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresaFk")
    @JsonBackReference(value = "vagasDaEmpresa")
    Empresa empresaFk;

    @OneToMany(mappedBy = "vagaFk", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference(value = "respostaVagas")
    List<RespostaVaga> respostaVagas;


    public Vaga(long idVaga, String cargo) {
        this.idVaga = idVaga;
        this.cargo = cargo;
    }

}

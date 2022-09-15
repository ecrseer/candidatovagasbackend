package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Empresa extends Usuario {
    public String causaSocial;

    @OneToMany(mappedBy = "empresaFk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "vagasDaEmpresa")
    List<Vaga> vagas;

    final String tipo = "E";
}

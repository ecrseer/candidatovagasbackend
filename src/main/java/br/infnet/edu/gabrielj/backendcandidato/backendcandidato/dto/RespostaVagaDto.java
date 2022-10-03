package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.dto;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Resposta;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Vaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@AllArgsConstructor
@NoArgsConstructor
public class RespostaVagaDto
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private long idRespostaVaga;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vaga vagaFk;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Candidato candidatoFk;


    private List<Resposta> respostas;


}

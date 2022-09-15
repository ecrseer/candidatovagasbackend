package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.RespostaVaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaVagaRepository extends JpaRepository<RespostaVaga, Long> {

}

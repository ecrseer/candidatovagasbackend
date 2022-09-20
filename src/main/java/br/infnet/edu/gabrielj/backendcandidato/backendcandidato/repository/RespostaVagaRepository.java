package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.RespostaVaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaVagaRepository extends JpaRepository
        <RespostaVaga, Long> {
    public List<RespostaVaga> findAllByCandidatoFk_IdUsuario(long idUsuario);
}

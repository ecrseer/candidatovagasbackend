package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.RespostaVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaVagaRepository extends JpaRepository
        <RespostaVaga, Long> {

    List<RespostaVaga> findAllByCandidatoFk_IdUsuario(long candidatoFk);


}

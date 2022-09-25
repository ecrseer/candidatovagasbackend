package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository;


import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    Vaga findVagaByIdVaga(Long idVaga);
}

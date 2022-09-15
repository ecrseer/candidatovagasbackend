package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Candidato, Long> {
    Candidato findCandidatoByLogin(String login);
}

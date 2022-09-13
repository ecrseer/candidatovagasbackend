package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByLogin(String login);
}
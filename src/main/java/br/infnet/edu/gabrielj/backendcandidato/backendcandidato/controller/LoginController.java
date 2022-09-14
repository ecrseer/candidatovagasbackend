package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.controller;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Usuario;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginRepository repository;

    @GetMapping
    List<Candidato> list() {
        return repository.findAll();
    }


    private boolean isFieldsMissing(Usuario usuario) {
        if (usuario.getIdUsuario() == 0)
            return true;
        return false;
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrarCandidato(@RequestBody Candidato usuario) {
        if (isFieldsMissing(usuario)) {
            var add = repository.findAll().size() + 1;
            usuario.setIdUsuario(add);
        }
        Candidato usr = repository.save(usuario);
        return usr;

    }

    @PostMapping("/logar")
    public ResponseEntity<Candidato> logarUsuario(@RequestBody Candidato usuario) {

        Candidato foundUser = repository.findCandidatoByLogin(usuario.getLogin());
        System.out.println("find foundUser " + foundUser);
        if (foundUser != null) {
            boolean isPasswordCorrect = foundUser.getPassword().equals(usuario.getPassword());
            if (isPasswordCorrect) {
                return ResponseEntity.ok(foundUser);
            }
        }

        return ResponseEntity.notFound().build();

    }

}

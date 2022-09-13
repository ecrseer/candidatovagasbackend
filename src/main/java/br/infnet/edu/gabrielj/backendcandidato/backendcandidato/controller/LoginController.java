package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.controller;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Usuario;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginRepository repository;

    @GetMapping
    Iterable<Usuario> list() {
        return repository.findAll();
    }


    private boolean isFieldsMissing(Usuario usuario) {
        if (usuario.getIdUsuario() == 0)
            return true;
        return false;
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrarCandidato(@RequestBody Usuario usuario) {

        if (isFieldsMissing(usuario)) {
            var add = repository.findAll().size() + 1;
            usuario.setIdUsuario(add);
        }
        var usr = repository.save(usuario);
        return usr;

    }

}

package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.controller;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.RespostaVaga;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Usuario;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.LoginRepository;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.RespostaVagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostaVaga")
public class RespostaVagaController {

    @Autowired
    RespostaVagaRepository repository;

    @GetMapping
    List<RespostaVaga> list() {
        return repository.findAll();
    }



    @PostMapping("/responder")
    public ResponseEntity<RespostaVaga> salvaResposta(@RequestBody RespostaVaga resposta) {
        RespostaVaga saved = repository.save(resposta);
        return ResponseEntity.ok(saved);

    }

    @PostMapping("/logar")
    public ResponseEntity<Candidato> logarUsuario(@RequestBody Candidato usuario) {

        Candidato foundUser = null;//repository.findCandidatoByLogin(usuario.getLogin());
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

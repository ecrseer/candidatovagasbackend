package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.controller;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Candidato;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Resposta;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.RespostaVaga;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.Usuario;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.LoginRepository;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.RespostaRepository;
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

    @Autowired
    RespostaRepository respostaRepository;

    @GetMapping
    List<RespostaVaga> list() {
        return repository.findAll();
    }

    /*@PostMapping("/responder")
    public ResponseEntity<Resposta> salvaResposta(@RequestBody Resposta resposta) {
        //RespostaVaga saved = repository.save(resposta);


        try {
            var result = respostaRepository.save(resposta);
            System.out.println(result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.accepted().build();
    }*/

    @PostMapping("/responder")
    public ResponseEntity<RespostaVaga> salvaResposta(@RequestBody RespostaVaga respostaAvaga) {
        var shallowClone = new RespostaVaga(respostaAvaga.getIdRespostaVaga(),
                respostaAvaga.getVagaFk(),
                respostaAvaga.getCandidatoFk(), null);


        try {
            RespostaVaga saved = repository.save(respostaAvaga);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Resposta resposta :
                respostaAvaga.getRespostas()) {

            try {
                var shallowResposta = new Resposta(resposta.getIdResposta(),
                        resposta.getCriterioFk(), resposta.getConhecimento(), null);
                respostaRepository.save(resposta);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        return ResponseEntity.ok().build();
    }
    @GetMapping("/respostas/${idCandidato}")
    public ResponseEntity<List<RespostaVaga>> getVagasRespondidas(@PathVariable long idCandidato){

        Candidato foundUser = null;//repository.findCandidatoByLogin(usuario.getLogin());


        return ResponseEntity.notFound().build();
    }


}

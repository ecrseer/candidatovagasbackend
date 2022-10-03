package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.controller;

import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain.*;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.dto.RespostaVagaDto;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.LoginRepository;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.RespostaRepository;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.RespostaVagaRepository;
import br.infnet.edu.gabrielj.backendcandidato.backendcandidato.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/respostaVaga")
public class RespostaVagaController {

    @Autowired
    RespostaVagaRepository repository;

    @Autowired
    RespostaRepository respostaRepository;

    @Autowired
    VagaRepository vagaRepository;

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
    public ResponseEntity<RespostaVaga> salvaResposta(@RequestBody RespostaVagaDto respostaAvaga) {
        RespostaVaga shallowClone = new RespostaVaga(respostaAvaga.getIdRespostaVaga(),
                respostaAvaga.getVagaFk(),
                respostaAvaga.getCandidatoFk(), null);


        try {
            RespostaVaga saved = repository.save(shallowClone);

            for (Resposta resposta : respostaAvaga.getRespostas()) {

                try {
                    var shallowResposta = new Resposta(resposta.getIdResposta(),
                            resposta.getCriterioFk(), resposta.getConhecimento(), saved);
                    respostaRepository.save(shallowResposta);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return ResponseEntity.ok().build();
    }

    @GetMapping("/respostas/{idCandidato}")
    public ResponseEntity<List<RespostaVagaDto>> getVagasRespondidas
            (@PathVariable long idCandidato) {

        try {
            List<RespostaVagaDto> respostasDoCandidato = new ArrayList<>();
            List<RespostaVaga> query = repository
                    .findAllByCandidatoFk_IdUsuario(idCandidato);

            for (int ii = 0; ii < query.size(); ii++) {
                var resposta = query.get(ii);
                var dto = new RespostaVagaDto(resposta.getIdRespostaVaga(),
                        resposta.getVagaFk(), resposta.getCandidatoFk(),
                        resposta.getRespostas());
                respostasDoCandidato.add(dto);
            }

            /*List<Vaga> vagas = new ArrayList<>();

            System.out.println(vagas);
            for (int ii = 0; ii < query.size(); ii++) {
                RespostaVaga resposta = query.get(ii);
                respostasDoCandidato.add(resposta);
            }

            for (int ii = 0; ii < query.size(); ii++) {
                var currentResposta = query.get(ii);

                var currentVaga = currentResposta.getVagaFk();
                vagas.add(currentVaga);
                respostasDoCandidato.get(ii).setVagaFk(currentVaga);
            }*/

            if (query == null) {
                throw new Exception("");
            }
            System.out.println("AAAAAAAAAAAA" + respostasDoCandidato);
            return ResponseEntity.ok(respostasDoCandidato);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ResponseEntity.notFound().build();
    }


}

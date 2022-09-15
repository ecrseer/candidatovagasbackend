package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {
    /*    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idResposta;

    private RespostaVaga resposta;*/
    private int conhecimento;
}

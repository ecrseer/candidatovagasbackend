package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "candidato")
public class Candidato extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idCandidato;
    long cpf;
    final String tipo="C";

}


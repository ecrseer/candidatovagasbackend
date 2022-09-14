package br.infnet.edu.gabrielj.backendcandidato.backendcandidato.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idUsuario;

    private String login;
    private String password;


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

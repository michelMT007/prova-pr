package com.michel.dto;

import com.michel.entities.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
    private Long id;
    private String cpf;
    private String email;
    private String telefone;

    public PessoaDTO(Pessoa entitiy){
        id = entitiy.getId();
        cpf=entitiy.getCpf();
        email=entitiy.getEmail();
        telefone = entitiy.getTelefone();
    }
    public PessoaDTO(Long id, String cpf, String email, String telefone){
        super();
        this.id = id;
        this.cpf = cpf;
        this.email=email;
        this.telefone=telefone;
    }
}
